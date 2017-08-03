package com.main;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseListener extends MouseAdapter implements Runnable {
    public Game g;public int GS;box[][]D2;int turn;String[] Player;
    public MouseListener(Game g, int GS,box[][] D2,String[] Player){
        this.g = g;
        this.Player = Player;
        this.GS = GS;
        this.D2 = D2;
        new Thread(this).start();

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //System.out.println(turn+" <-INTIAL ? <-");
        //System.out.println("CLICK" + e.getPoint());
        for (int k = 0; k < GS; k++) {
            for (int i = 0; i < GS; i++) {
                //System.out.println(i + " k "+k);
                if(D2[i][k].Contain(e.getPoint())){
                    //System.out.println("true .. "+ e.getX() +" y "+e.getY());
                    if(turn >0){new O(D2[i][k],Player[turn]+turn,g);}
                    else {new X(D2[i][k],Player[turn]+turn,g);}
                    turn=!D2[i][k].isOccupied()?turn:turn>0?0:1;
                    //System.out.println(this.turn+" <- After Dup Check");
                    D2[i][k].setXO(turn);
                }
            }
        }

        //new winCheck(g,D2,Player[turn]).winCheck();
        //turn = turn>0?-1:0;
        //turn++;

        turn=turn>0?0:1;
        //System.out.println(turn+" <=- After Reset");
    }

    public void run(){
        turn = 0;
        System.out.println("Mouse Listener Started...");
        g.addMouseListener(this);
    }
}
