package com.main;

import java.awt.*;

public class Turn {
    public int c;public int r;boolean drawable;
    static int turn = 0;box[][] D2;String Players[];Game g;
    public Turn(Game g) {
        this.g = g;
    }
    public void nextTurn(int c, int r) {
        drawable = true;
        D2 = g.D2;
        Players = g.Players;
        if (!D2[c][r].isOccupied()) {
            if (turn > 0) {
                new O(D2[c][r], g);
            } else if (turn > -1) {
                new X(D2[c][r], g);
            }
        }
        else {
            turn = turn > 0 ? 0 : 1;
        }
        turn = turn > 0 ? 0 : 1;
        this.c = c;this.r=r;
        try { g.rePaint(); } catch (InterruptedException e) { e.printStackTrace(); }
    }
    public void drawTurn(Graphics g){
        Color LastTurn = new Color(255, 100, 150, 127);
        g.setColor(LastTurn);
        g.fillRect(D2[c][r].x,
                D2[c][r].y,200,200);
    }
}