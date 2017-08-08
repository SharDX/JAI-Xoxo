package com.main;

public class AiWorker implements Runnable {
    Game g;int Delay;
    public AiWorker(Game g, int Delay){
        this.g = g;this.Delay = Delay;
        new Thread(this).start();
    }
    public void play() throws InterruptedException {
        int e = 0;
        while (e < 900) {
            if (g.Ai == true) {
                g.simplyRandom = new SimplyRandom(g);
                g.simplyRandom.randMove();
                Thread.sleep(Delay);
                g.NxtP = new NextToPlayer(g);
                g.NxtP.NxtMove();
                e++;
            }
        }
    }
    @Override
    public void run(){
        try {
            play();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
