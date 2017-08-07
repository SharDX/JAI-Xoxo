package com.main;

import com.sun.xml.internal.ws.api.message.Message;

import java.awt.*;

public class X
{
    box b;String Player;int turn;
            public X(box b,Game g) {
                    this.b = b;
                    this.turn = Turn.turn;
                    this.Player = g.Players[turn];
                    g.xList.add(this);
                    b.setOccupied(true);
                    b.setXO(turn);
                    b.setOccupier(turn);
                    new winCheck(g);

            }

            public void draw(Graphics g) {
                    g.setColor(Color.RED);
                    g.drawLine(b.bX()+20,b.bY()+20,b.bX()+b.size-20,b.bY()+b.size()-20);
                    g.drawLine(b.bX()+20,b.bY()+b.size-20,b.bX()+b.size()-20,b.bY()+20);
                    g.setColor(Color.blue);
                    g.setFont(new Font(Font.SERIF,1,25));
                    g.drawString(Player,(b.bX()+(b.size()/2))-35,b.bY()+(b.size/2));
            }
}

