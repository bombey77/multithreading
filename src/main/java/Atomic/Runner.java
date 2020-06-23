package main.java.Atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class Runner {

    public static void main(String[] args) {
        increase();
    }

    public static void increase() {
        for (int i = 0; i < 10_000; i++) {
            new IncrementThread().start();
        }
        System.out.println(IncrementThread.getX());
    }

    static class IncrementThread extends Thread {

        private static AtomicInteger x = new AtomicInteger();

        @Override
        public void run() {
            x.incrementAndGet();
        }

        public static int getX() {
            return x.intValue();
        }
    }
}


