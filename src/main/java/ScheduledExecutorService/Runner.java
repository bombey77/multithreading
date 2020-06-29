package main.java.ScheduledExecutorService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Runner {

    public static void main(String[] args) {
        Worker.printCurrentTime();

        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.schedule(new Worker(), 5, TimeUnit.SECONDS);
        service.shutdown();

//        17:42:34
//        17:42:39
//        worker is doing his job...
    }
}
