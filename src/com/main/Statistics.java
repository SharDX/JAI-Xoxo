package com.main;


import java.awt.*;

public class Statistics {
    Game game;
    int[] pwin = new int[2];int[] ploss = new int[2];
    int tieC = 0;
    int Count = 0;
    int Gamec = 0;
    int GameResult;
    String[] CV = new String[3];
    public Statistics(Game game){
        CV[0]="0";CV[1]="0";CV[2]="0";
        this.game = game;
    }
    public void update(String[] CV,int GameResult){
        this.CV = CV;
        this.GameResult = GameResult;
        Count++;
        makeStats(GameResult);
    }
    public void makeStats(int GameResult) {
            if(GameResult != -1){
                Gamec++;
            }
            if (GameResult == 2) {
                tieC++;
            }
            if (GameResult == 1) {
                pwin[0] += 1;
                ploss[1] += 1;
            }
            if (GameResult == 0) {
                pwin[1] += 1;
                ploss[0] += 1;
            }
        }

    public void drawStats(Graphics g) {
        g.setFont(new Font(Font.SERIF, 1, 25));
        String Player0Stats = "Player : " + game.Players[0] + " Wins : " + pwin[0] + " |Losses : " + ploss[0];
        String Player1Stats = "Player : " + game.Players[1] + " Wins : " + pwin[1] + " |Losses : " + ploss[1];
        g.drawString(Player0Stats, Game.Grix, (box.size * Game.GS) + 50);
        g.drawString(Player1Stats, Game.Grix, (box.size * Game.GS) + 80);
        g.drawString("Tie Count => " + tieC, Game.Grix, (box.size * Game.GS) + 110);
        for (int i = 0; i < 3; i++) {
            g.drawString(CV[i], 430, (box.size * Game.GS) + 40 + (i * 30));
        }
        g.drawString("Games Played => " + Gamec + " || Turn => " + game.turn.turn +
                        " || WinChecks => " + Count
                , Game.Grix, box.size * Game.GS + 150);
    }
}