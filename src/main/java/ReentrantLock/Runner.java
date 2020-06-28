package main.java.ReentrantLock;

public class Runner {

    public static void main(String[] args) throws InterruptedException {
        Resource resource = new Resource();
        resource.setX(5);

        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();
        myThread1.resource = resource;
        myThread2.resource = resource;
        myThread1.setName("one");
        myThread1.start();
        myThread2.start();

        myThread1.join();
        myThread2.join();

        System.out.println(resource.getX());

//        7
    }

    static class MyThread extends Thread {

        private Resource resource;

        @Override
        public void run() {
            resource.changeX();
        }
    }
}
