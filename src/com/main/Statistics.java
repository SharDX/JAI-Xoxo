/*package com.main;

import javax.swing.text.Style;
import java.awt.*;

public class Statistics {
    String[] Players;String gameResutl;
    int[] pwin = new int[2];int tieC = 0;
    public Statistics(String[] Players, String gameResult){
        this.Players = Players;
        this.gameResutl = gameResult;
        makeStats();
    }
    public void makeStats(){
        if(gameResutl!="Tie"){
            tieC++;
        }
        if (gameResutl.equals(Players[0])) {
            pwin[0] += 1;
        }
        if (gameResutl.equals(Players[0])) {
            pwin[1] += 1;
        }
    }
    public void drawStats(Graphics g){
        makeStats();
        System.out.println(tieC + " " + pwin[0] + "  //Player 1 =>" + pwin[1]);
        g.setFont(new Font(Font.SERIF, 1,20));
        g.drawString(Players[1],0,box.size*Game.GS);
    }
}
*/
