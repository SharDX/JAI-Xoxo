package com.main;

import java.util.List;

public class Destructor {
    public Destructor(box b[][], List<X> xList,List<O> oList,winCheck wC){
        for (int i = 0; i < Game.GS; i++) {
            for (int j = 0; j < Game.GS; j++) {
                b[j][i].setXO(2);
                b[j][i].setOccupier("");
                b[j][i].setOccupied(false);
            }
        }
        xList.clear();
        oList.clear();
        wC.GameResult = "";
        wC.setWinner("");
        wC.winState = false;
        wC.run();
    }
}
