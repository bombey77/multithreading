package main.java.ScheduledExecutorService;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Worker extends Thread{

    @Override
    public void run() {
        doJob();
    }

    public void doJob() {
        printCurrentTime();
        System.out.println("worker is doing his job...");
    }

    public static void printCurrentTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        System.out.println(dateFormat.format(date));
    }
}
