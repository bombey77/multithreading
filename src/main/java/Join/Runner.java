package main.java.Join;

public class Runner {

    public static void main(String[] args) {

        MyThread myThread = new MyThread();
        myThread.start();
        try {
            //Waits for this thread to die
            myThread.join();
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
