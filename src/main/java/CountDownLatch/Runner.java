package main.java.CountDownLatch;

import java.util.concurrent.CountDownLatch;

public class Runner {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch file = new CountDownLatch(3);
        new Parser(file).start();
        new Parser(file).start();
        new Parser(file).start();

        file.await();
        System.out.println("The file is parsed");

//        The part of the file is parsed
//        The part of the file is parsed
//        The part of the file is parsed
//        The file is parsed
    }
}
