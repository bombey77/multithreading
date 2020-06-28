package main.java.Callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Runner {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable myCallable = new MyCallable();
        FutureTask futureTask = new FutureTask(myCallable);
        new Thread(futureTask).start();

        System.out.println("main thread started");
        System.out.println(futureTask.get());
        System.out.println("main thread finished");

//        main thread started
//        10
//        main thread finished
    }

    static class MyCallable implements Callable<Integer> {

        private int result;

        public void sum(int a, int b) {
            result = a + b;
        }

        @Override
        public Integer call() throws Exception {
            Thread.sleep(3000);
            sum(7, 3);
            return result;
        }
    }
}
