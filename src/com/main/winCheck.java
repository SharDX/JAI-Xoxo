package com.main;

import javax.swing.*;
import java.awt.*;

public class winCheck implements Runnable {
    public boolean winState = false;boolean Tie = false;
    String GameResult;
    int[] pwin = new int[2];int[] ploss = new int[2];
    int tieC = 0;
    int Count = 0;
    Game g;int EmptySp = 9;
    int n = 3;
    box[][] b;
    String Players[];
    String Winner;

    public winCheck(Game g, box[][] b, String Players[]) {
        this.Players = Players;
        this.g = g;
        this.b = b;
        new Thread(this).start();
    }

    /*
    0 1 2
  0 [1][][]
  1 [2][][]
  2 [3][][]
     */
    public void winCheck() {
        while (winState == false) {
            //tie Checker

            //Diagonal Checkers
            if (b[0][0].getXO() != 2) {
                if (b[0][0].getXO() == b[1][1].getXO() && b[0][0].getXO() == b[2][2].getXO()) {
                    winState = true;System.out.println("Diag win");
                    setWinner(b[0][2].getOccupier());
                    break;
                }
            }
            // anti-diagonal Checker
            if (b[0][2].getXO() != 2) {
                if (b[0][2].getXO() == b[1][1].getXO() && b[0][2].getXO() == b[2][0].getXO()) {
                    winState = true;System.out.println("anti-Diag win");
                    setWinner(b[0][2].getOccupier());
                    break;
                }
            }
            //Check for Horizontal && Vertical
            for (int i = 0; i < 3; i++) {
                if (b[i][0].getXO() != 2) {
                    if ((b[i][0].getXO() == b[i][1].getXO() && b[i][0].getXO() == b[i][2].getXO()))
                    {
                        winState = true;
                        System.out.println("V win");
                        setWinner(b[0][2].getOccupier());
                        break;
                    }
                }
                if(b[0][i].getXO() != 2){
                    if (b[0][i].getXO() == b[1][i].getXO() && b[0][i].getXO() == b[2][i].getXO()){
                        winState = true;
                        System.out.println("H win");
                        setWinner(b[0][2].getOccupier());
                        break;
                    }
                }
            }
            for (int r = 0; r < n; r++) {
                for (int i = 0; i < n; i++) {
                    System.out.print(b[r][i].getXO() + "  ");
                    if(b[r][i].getXO() != 2){EmptySp--;}
                    //else if(b[0][i].getXO() != b[0][i>0?i-1:i].getXO()) {}
                }
                System.out.println("");
            }
            if(EmptySp==0){Tie=true;break;}else{EmptySp=9;}

            System.out.println("-------");
            Count++;
            try { Thread.sleep(10); } catch (InterruptedException e) { e.printStackTrace(); }
        }
        GameResult = winState?getWinner():"Tie";
        makeStats(GameResult);
        System.out.println("Game Ended With State " + GameResult + " Totall Amount of Checks .. "+Count);
        new Destructor(b,g.xList,g.oList,this);
    }
    public String getResult(){ return this.GameResult; }
    public String getWinner(){ return this.Winner; }
    public void setWinner(String Winner){this.Winner = Winner;}
    public void run(){
            winCheck();
    }
    public void makeStats(String GameResult){
            if(GameResult.equals("Tie")){
                tieC++;
            }
            if (GameResult.equals(Players[0])) {
                pwin[0] += 1;
                ploss[1] += 1;
            }
            if (GameResult.equals(Players[1])) {
                pwin[1] += 1;
                ploss[0] += 1;
            }
        }
    public void drawStats(Graphics g){
        g.setFont(new Font(Font.SERIF, 1,20));
        String Player0Stats = "Player : "+Players[0]+" Wins : "+pwin[0] + " |Losses : "+ploss[0];
        String Player1Stats = "Player : "+Players[1]+" Wins : "+pwin[1] + " |Losses : "+ploss[1];
        g.drawString(Player0Stats,0,(box.size*Game.GS)+50);
        g.drawString(Player1Stats,0,(box.size*Game.GS)+100);
        g.drawString("Tie Count : "+tieC,0,(box.size*Game.GS)+150);
    }
}
