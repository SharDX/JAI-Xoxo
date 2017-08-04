package com.main;

import java.util.List;

public class Destructor {
    public Destructor(box b[][], List<X> xList,List<O> oList,winCheck wC){
        for (int i = 0; i < Game.GS; i++) {
            for (int j = 0; j < Game.GS; j++) {
                b[j][i].setXO(2);
                b[j][i].setOccupier(-1);
                b[j][i].setOccupied(false);
            }
        }
        xList.removeAll(xList);
        oList.removeAll(oList);
        wC.GameResult = -1;
        wC.setWinner(-1);
        wC.winState = false;
        wC.EmptySp = 9;
        System.out.println("[+] Destroyed ..");
        wC.winCheck();
    }
}
