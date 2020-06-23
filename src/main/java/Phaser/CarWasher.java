package main.java.Phaser;

import java.util.concurrent.Phaser;

public class CarWasher extends Thread {

    private Phaser phaser;

    public CarWasher(Phaser phaser) {
        this.phaser = phaser;
        this.phaser.register();
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(getName() + " - is washing car...");
            phaser.arriveAndAwaitAdvance();
        }
    }
}
