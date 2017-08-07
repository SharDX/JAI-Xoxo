package com.main;


import java.util.Random;

public class winCheck {
    public boolean winState = false;boolean Tie = false;
    int GameResult = -1;
    boolean Destroying;
    int Count = 0;
    int Gamec = 0;
    Game game;int EmptySp = 9;
    int n = 3;
    box[][] b;
    String Players[];
    int Winner;
    String[] CV = new String[3];String CVLine = "";

    public winCheck(Game game) {
        this.Players = game.Players;
        this.game = game;
        this.b = game.D2;



        System.out.println("[+++] Performing Win Check" + game.xList.size() + " O Amount " + game.oList.size());
        //tie Checker
        //Diagonal Checkers
        if (b[0][0].getXO() != 2) {
            if (b[0][0].getXO() == b[1][1].getXO() && b[0][0].getXO() == b[2][2].getXO()) {
                winState = true;System.out.println("Diag win");
                setWinner(game.turn.turn);
            }
        }    else {System.out.println(b[0][0].getXO() + " and " + b[1][1].getXO() + " and" + b[2][2].getXO());}
        // anti-diagonal Checker
        if (b[0][2].getXO() != 2) {
            if (b[0][2].getXO() == b[1][1].getXO() && b[0][2].getXO() == b[2][0].getXO()) {
                winState = true;System.out.println("anti-Diag win");
                setWinner(game.turn.turn);
            }
        }
        //Check for Horizontal && Vertical
        for (int i = 0; i < 3; i++) {
            if (b[i][0].getXO() != 2) {
                if ((b[i][0].getXO() == b[i][1].getXO() && b[i][0].getXO() == b[i][2].getXO()))
                {
                    winState = true;
                    System.out.println("V win");
                    setWinner(game.turn.turn);
                    break;
                }
            }
            if(b[0][i].getXO() != 2){
                if (b[0][i].getXO() == b[1][i].getXO() && b[0][i].getXO() == b[2][i].getXO()){
                    winState = true;
                    System.out.println("H win");
                    setWinner(game.turn.turn);
                    break;
                }
            }
        }
        CVLine = "|  ";
        for (int r = 0; r < n; r++) {
            for (int i = 0; i < n; i++) {
                //System.out.print(b[r][i].getXO() + "  ");
                CVLine += b[r][i].getXO() + "   |  ";
                if(b[r][i].getXO() != 2){EmptySp--;}
                //else if(b[0][i].getXO() != b[0][i>0?i-1:i].getXO()) {}
            }
            //System.out.println("");
            CVLine += "|L|  ";
        }
        System.out.println(EmptySp);
        CV = CVLine.split("L");
        if(EmptySp==0){Tie=true;System.out.println("Its A Tie");}else{EmptySp=9;}
        //System.out.println("-------");
        Count++;
        game.stats.update(CV,GameResult);
        if(winState == true || Tie == true) {
            GameResult = winState ? getWinner() : 2;
            game.stats.update(CV,GameResult);
            System.out.println("Game Ended With State " + GameResult + " Totall Amount of Checks .. " + Count);
            Gamec++;
            new Destructor(b, game.xList, game.oList, this);

        }
    }

    public int getResult(){ return this.GameResult; }
    public int getWinner(){ return this.Winner; }
    public void setWinner(int Winner){this.Winner = Winner;}
}
