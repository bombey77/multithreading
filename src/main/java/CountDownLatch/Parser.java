package main.java.CountDownLatch;

import java.util.concurrent.CountDownLatch;

public class Parser extends Thread {

    private CountDownLatch file;

    public Parser(CountDownLatch file) {
        this.file = file;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("The part of the file is parsed");
        file.countDown();
    }
}
