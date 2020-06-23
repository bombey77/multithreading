package main.java.ExecutorService;

import java.util.concurrent.*;

public class Runner {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
//        java.main.ExecutorService executorService = Executors.newScheduledThreadPool(2);
//        java.main.ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> System.out.println(Thread.currentThread().getName() + ", in run method"));
        executorService.execute(() -> System.out.println(Thread.currentThread().getName() + ", in run method"));

        //returns -> an Object (Person)
        Future future = executorService.submit(() -> {
            Person person = new Person();
            person.setName("Roman");
            return person;
        });
        System.out.println(((Person) future.get()).getName());

        executorService.shutdown();

//        pool-1-thread-1, in run method
//        pool-1-thread-2, in run method
//        Roman
    }
}
