package main.java.Condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {

    private static int count = 0;
    private static Lock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();

    public static void main(String[] args) {
        new ThreadMinus().start();
        new ThreadPlus().start();

//        count 1 = 0
//        count 4 = 10
//        count 2 = 10
//        count 3 = 0
    }

    static class ThreadPlus extends Thread {

        @Override
        public void run() {
            lock.lock();
            count += 10;
            System.out.println("count 4 = " + count);
            condition.signal();
            lock.unlock();
        }
    }


    static class ThreadMinus extends Thread {

        @Override
        public void run() {
            if (count < 10) {
                try {
                    lock.lock();
                    System.out.println("count 1 = " + count);
                    condition.await();
                    lock.unlock();
                    System.out.println("count 2 = " + count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count -= 10;
            }
            System.out.println("count 3 = " + count);
        }
    }
}
