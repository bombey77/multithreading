package main.java.TryLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {

    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        new MyThread1().start();
        new MyThread2().start();

//        run
//        thread is waiting...
//        thread is waiting...
//        thread is waiting...
//        thread is unlocked
    }


    static class MyThread1 extends Thread {

        @Override
        public void run() {
            lock.lock();
            System.out.println("run");
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.unlock();
        }
    }

    static class MyThread2 extends Thread {

        @Override
        public void run() {
            while (true) {
                if (lock.tryLock()) {
                    System.out.println("thread is unlocked");
                    break;
                } else {
                    System.out.println("thread is waiting...");
                }
            }
        }
    }
}
