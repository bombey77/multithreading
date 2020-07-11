package main.java.BlocingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class Runner {

    public static void main(String[] args) {
        BlockingQueue<String> queue = new PriorityBlockingQueue<>();

        new Thread(() -> {
            try {
                //this thread is waiting when the method add is finished its work
                System.out.println(queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            queue.add("Hi Roman");
        }).start();
    }

    //"Hi Roman"
}
