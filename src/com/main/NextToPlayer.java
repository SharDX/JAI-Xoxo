package com.main;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NextToPlayer {

        Game game;int c;int r;int newC;int newR;
        List<String> FreeSpaces = new ArrayList<>();
        NextToPlayer(Game game) {
            this.game = game;c = game.turn.c;r = game.turn.r;
        }
        public void NxtMove(){
            boolean fS = true;
            Graphics g= game.getGraphics();ESP(g);
            int RanC = new Random().nextInt(2);
            int RanR = new Random().nextInt(2);
            newC = c!=1?game.D2[c<2?c+1:c-1][r].getXO() == 2?
                    c<2?c+1:c-1:c:game.D2[RanC>0?c-1:c+1][r].getXO() == 2?
                        RanC>0?c-1:c+1:game.D2[RanC>0?c+1:c-1][r].getXO() == 2?
                            RanC>0?c+1:c-1:c;

            newR = r!=1?game.D2[c][r<2?r+1:r-1].getXO() == 2?
                    r<2?r+1:r-1:r:game.D2[c][RanR==0?r-1:r+1].getXO() == 2?
                        RanR>0?r-1:r+1:
                        game.D2[c][RanR==0?r+1:r-1].getXO() == 2?
                                RanR==0?r+1:r-1:r;

            int Random = new Random().nextInt(2);
            //System.out.println("If C ( "+newC+", "+r+")");
            //System.out.println("If R ( "+c+", "+newR+")");
            if(Random > 0){
                if(newC != c){
                    game.turn.nextTurn(newC, r);
                }
                else if(newC == c && newR != r){
                    game.turn.nextTurn(c, newR);
                }
                else {
                    new SimplyRandom(game).randMove();
                }
            }
            else if(Random < 1){
                if(newR != r){
                    game.turn.nextTurn(c, newR);
                }
                else if(newR == r && newC != c){
                    game.turn.nextTurn(newC, r);
                }
                else {
                    new SimplyRandom(game).randMove();
                }
            }
        }
        public void ESP(Graphics g){
            int alpha = 127; // 50% transparent
            Color myColour = new Color(100, 100, 250, alpha);
            g.setColor(myColour);
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if(game.D2[j][0].getXO() == 2) {
                        if (c + 1 == j || c - 1 == j) {
                            g.fillRect(game.D2[j][0].x,
                                    game.D2[c][r].y,200,200);
                        }
                        if (r + 1 == i || r - 1 == i) {
                            g.fillRect(game.D2[c][r].x,
                                    game.D2[0][i].y,200,200);
                        }
                    }

                } }
        } }