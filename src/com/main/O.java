package com.main;

import java.awt.*;

public class O {
    box b;
    String Player;

    public O(box b, String Player, Game g) {

        this.b = b;
        this.Player = Player;
        g.oList.add(this);

    }

    public void draw(Graphics g) {
        if (!b.isOccupied()) {
            g.setColor(Color.blue);
            //System.out.println(Player);
            g.drawOval(b.bX() + 25, b.bY() + 25, b.size() - 50, b.size() - 50);
            //System.out.println("Bx : "+b.bX()+" /By : "+b.bY());
            b.setOccupied(true);
            b.setOccupier(Player);
            g.setColor(Color.RED);
            g.setFont(new Font(Font.SERIF,1,25));
            g.drawString(Player,(b.bX()+(b.size()/2))-35,b.bY()+(b.size/2));
        }
    }
}
