package com.main;

import com.sun.xml.internal.ws.api.message.Message;

import java.awt.*;

public class X
{
    box b;String Player;
            public X(box b, String Player,Game g) {
                    this.b = b;
                    this.Player = Player;
                    g.xList.add(this);
            }

            public void draw(Graphics g) {
                    g.setColor(Color.RED);
                    g.drawLine(b.bX()+20,b.bY()+20,b.bX()+b.size-20,b.bY()+b.size()-20);
                    g.drawLine(b.bX()+20,b.bY()+b.size-20,b.bX()+b.size()-20,b.bY()+20);
                    b.setOccupied(true);
                    b.setOccupier(Player);
                    //System.out.println("Bx : " + b.bX() + " /By : " + b.bY());
                    g.setColor(Color.blue);
                    g.setFont(new Font(Font.SERIF,1,25));
                    g.drawString(Player,(b.bX()+(b.size()/2))-35,b.bY()+(b.size/2));
            }
}
