package main.java.Yield;

public class Runner {

    public static void main(String[] args) {
        //the method moves status from Running to Runnable without any guarantee that it won't run first
        Thread.yield();

        MyThread myThread = new MyThread();
        myThread.start();

        System.out.println("main");

//        result could be
//        Thread-0
//        main

//        or
//        main
//        Thread-0
    }
}

class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println(getName());
    }
}
