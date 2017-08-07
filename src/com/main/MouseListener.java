package com.main;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class MouseListener extends MouseAdapter implements Runnable {
    public Game g;public int GS;box[][]D2;int turn;String[] Player;
    public MouseListener(Game g, int GS,box[][] D2,String[] Player){
        this.g = g;
        this.Player = Player;
        this.GS = GS;
        this.D2 = D2;
        this.Player[0] = Player[0]+"|"+turn;
        this.Player[1] = Player[1]+"|"+1;
        new Thread(this).start();

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //System.out.println(turn+" <-INTIAL ? <-");
        //System.out.println("CLICK" + e.getPoint());
            if (!g.Destorying) {
                if (e.getY() < Game.GS * box.size && e.getX() < Game.GS * box.size) {
                    for (int k = 0; k < GS; k++) {
                        for (int i = 0; i < GS; i++) {
                            if (D2[i][k].Contain(e.getPoint())) {
                                    g.turn.nextTurn(i,k);
                            }
                            if(g.Ai == true){
                                //g.turn.nextTurn();
                            }
                        }
                    }
                } else {
                    System.out.println("Out Of Bounds");
                }
            }
    }
    public void run(){
        System.out.println("Mouse Listener Started...");
        g.addMouseListener(this);
    }
}
