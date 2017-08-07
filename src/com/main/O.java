package com.main;

import java.awt.*;

public class O {
    box b;
    String Player;
    int turn;

    public O(box b, Game g) {
        this.b = b;
        this.turn = Turn.turn;
        this.Player = g.Players[turn];
        g.oList.add(this);
        b.setOccupied(true);
        b.setXO(turn);
        b.setOccupier(turn);
        new winCheck(g);

    }

    public void draw(Graphics g) {
            g.setColor(Color.blue);
            g.drawOval(b.bX() + 25, b.bY() + 25, b.size() - 50, b.size() - 50);
            g.setColor(Color.RED);
            g.setFont(new Font(Font.SERIF,1,25));
            g.drawString(Player,(b.bX()+(b.size()/2))-35,b.bY()+(b.size/2));
    }
}