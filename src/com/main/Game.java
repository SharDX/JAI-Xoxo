package com.main;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static com.main.OptionMenue.g;

public class Game extends JPanel{
    public JLabel Wins;

    //public static int Grix = 0;
    public static winCheck Checker;

    public List<O>oList = new ArrayList<>();
    public List<X>xList = new ArrayList<>();

    private static int Griy = 0;
    public static int GS = 3;

    public static box D2[][] = new box[GS][GS];
    public static String Players[];
    public static void main(String[] args) {
        Game g = new Game();
        new OptionMenue(g).start();
        int i;
        for (int e=0;e<GS;e++){
            for (i=0;i<GS;i++) {
                D2[i][e] = i > 0 ?new box(D2[i-1][e].bX()+box.size,Griy):new box(0,Griy);
            }
            Griy += 200;
        }
        Checker = new winCheck(g,D2,Players);
        while (true){
            try {

                g.repaint();
            }
            catch (Exception e){ e.printStackTrace(); }

        }
    }
    public void setPlayerNames(String[] Players,Game g){
        this.Players = Players;
        new MouseListener(g,GS,D2,Players);
    }
    public void Frame(){
        JFrame mFrame = new JFrame();
            mFrame.setVisible(true);
            mFrame.setSize(800,800);
            mFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            mFrame.add(this);
            mFrame.setTitle("JAI Xoxo");

        Wins = new JLabel();
            Wins.setVisible(true);
            Wins.setSize(100,100);

        mFrame.add(Wins,BorderLayout.SOUTH);
    }
    @Override
    public void paint(Graphics g3d) {
        Graphics2D g = (Graphics2D) g3d;
        g.setStroke(new BasicStroke(10));
        int i;
        for (int j = 0; j < GS; j++) {
            for (i = 0; i < GS; i++) {
                D2[i][j].draw(g);
            }
            //D2[i-1][j].draw(g);
        }
        //System.out.println(D2[2][0].bX());
        for (X x:xList){
            x.draw(g);
        }
        for (O o:oList){
            o.draw(g);
        }
    }
}