package com.main;

import javax.swing.text.Style;
import java.awt.*;

public class Statistics {
    String[] Players;String gameResutl;
    public Statistics(String[] Players, String gameResult){
        this.Players = Players;
        this.gameResutl = gameResult;
    }
    public void makeStats(Graphics g){
        g.setFont(new Font(Font.SERIF, 1,20));
        g.drawString();
    }
}
