package com.main;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Game extends JPanel{
    public static int ErrC = 0;
    public static boolean Ai = true;
    public static boolean Destorying = false;

    public static MouseListener ML;
    public static Statistics stats;
    public static NextToPlayer NxtP;
    public static SimplyRandom simplyRandom;
    public static winCheck Checker;
    public static Turn turn;

    Iterator<X> xs;
    Iterator<O> os;
    public List<O>oList = new ArrayList<>();
    public List<X>xList = new ArrayList<>();

    public static int Grix = 25;
    private static int Griy = 15;
    public static int GS = 3;

    public static box D2[][] = new box[GS][GS];
    public static String Players[];
    public static void main(String[] args) throws InterruptedException {
        Game g = new Game();
        simplyRandom = new SimplyRandom(g);
        stats = new Statistics(g);
        turn = new Turn(g);
        new OptionMenue(g).start();
        int i;
        for (int e = 0; e < GS; e++) {
            for (i = 0; i < GS; i++) {
                D2[i][e] = i > 0 ? new box(D2[i - 1][e].bX() + box.size, Griy,g) : new box(Grix, Griy,g);
            }
            Griy += 200;
        }
        /*while (true) {

                g.repaint();

        }*/
    }
    public void rePaint() throws InterruptedException {
        if(!Destorying){repaint();}
    }
    public void setPlayerNames(String[] Players,Game g){
        this.Players = Players;
        ML = new MouseListener(g,GS,D2,Players);
        //new AiWorker(g,10);
    }
    public void Frame(){
        JFrame mFrame = new JFrame();
            mFrame.setVisible(true);
            mFrame.setSize(700,800);
            mFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            mFrame.add(this);
            mFrame.setTitle("JAI Xoxo");
        mFrame.setLocationRelativeTo(null);
    }
    @Override
    public void paint(Graphics g3d) {
            super.paint(g3d);
            Graphics2D g = (Graphics2D) g3d;
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            if(stats != null){stats.drawStats(g);}
            g.setStroke(new BasicStroke(10));
            int i;
            for (int j = 0; j < GS; j++) {
                for (i = 0; i < GS; i++) {
                    D2[i][j].draw(g);
                }
            }
            if(NxtP != null){NxtP.ESP(g);g.setColor(Color.black);}
        if(simplyRandom != null){simplyRandom.ESP(g);g.setColor(Color.black);}
            if(turn.drawable){turn.drawTurn(g);}
                for (xs=xList.iterator();xs.hasNext();) {
                    if(!Destorying) {
                        X x = xs.next();
                        x.draw(g);
                    }
                }
                for (os = oList.iterator();os.hasNext();) {
                    if(!Destorying) {
                        O o = os.next();
                        o.draw(g);
                    }
                }
    }
}