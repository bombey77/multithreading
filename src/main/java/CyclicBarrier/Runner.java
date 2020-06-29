package main.java.CyclicBarrier;

import java.util.concurrent.CyclicBarrier;

public class Runner {

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(2, new CarWasher());

        System.out.println("before workers started");
        new Worker(barrier).start();
        new Worker(barrier).start();
        System.out.println("monitor isn't locked");
    }
}
