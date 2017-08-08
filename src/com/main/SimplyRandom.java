package com.main;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SimplyRandom {
    Game game;
    List<String> FreeSpaces = new ArrayList<>();
    SimplyRandom(Game game){
        this.game = game;
    }
    public void randMove(){
        int SC = 0;
        for(int r = 0; r < 3;r++){
            for (int i = 0; i < 3; i++) {
                if(game.D2[i][r].getXO() == 2){
                    SC++;
                    FreeSpaces.add(i+""+r);
                }
            }
        }
        String EmptyGrid = FreeSpaces.get(new Random().nextInt(FreeSpaces.size()));
        String Cords[] = EmptyGrid.split("");
        game.turn.nextTurn(Integer.parseInt(Cords[0]),Integer.parseInt(Cords[1]));
    }
    public void ESP(Graphics g){
        int alpha = 80;Color color = new Color(155, 250, 5, alpha);
        g.setColor(color);
        for (String e:
             FreeSpaces) {
            String Cords[] = e.split("");
            g.fillRect(game.D2[Integer.parseInt(Cords[0])][0].x,
                    game.D2[0][Integer.parseInt(Cords[1])].y,200,200);
        }
    }
}
