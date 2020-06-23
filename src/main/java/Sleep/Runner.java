package main.java.Sleep;

public class Runner {

    public static void main(String[] args) {
        new MyThread().start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("main");

//        Thread-0
//        main
    }
}

class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println(getName());
    }
}
