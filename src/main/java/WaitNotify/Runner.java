package main.java.WaitNotify;

public class Runner {

    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();
        System.out.println("main");

        synchronized (myThread) {
            myThread.wait();
        }

        System.out.println(myThread.x);
    }

    private static class MyThread extends Thread {

        private int x;

        @Override
        public void run() {
            synchronized (this) {
                for (int i = 0; i < 10; i++) {
                    x++;
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                notify();
            }
        }
    }
}
