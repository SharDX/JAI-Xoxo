package com.main;

import java.awt.*;

public class box extends Rectangle {
    int x,y;int XO = 2;
    public static final int size = 200;
    boolean Occupied = false;
    static int Occupier;Game g;
    public box(int x,int y,Game g){this.x=x;this.y=y;this.g = g;}
    public void draw(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawRect(x, y, size, size);
    }
    public int bX(){ return this.x;}
    public int bY(){ return this.y;}
    public int size(){ return this.size;}
    public int getOccupier(){ return this.Occupier; }
    public boolean isOccupied(){return this.Occupied;}
    public boolean Contain(Point p){
        int px = p.x;int py = p.y;boolean Eval = false;
        if(px > this.x && py > this.y){
            if (px < this.x + size && py < this.y + size){
                Eval = true;
            }
        }else {
            Eval = false;
        }
        return Eval;
    }

    public void setOccupier(int Occupier){ this.Occupier = Occupier; }
    public void setOccupied(boolean S){this.Occupied = S;}
    public void setXO(int XO){ this.XO = XO; }
    public int getXO(){return this.XO;}

}
