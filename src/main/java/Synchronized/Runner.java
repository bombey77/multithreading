package main.java.Synchronized;

public class Runner {

    public static void main(String[] args) throws InterruptedException {
        Resource resource = new Resource();
        resource.setX(5);

        MyThread myThread1 = new MyThread(resource);
        MyThread myThread2 = new MyThread(resource);
        myThread1.setName("one");

        myThread1.start();
        myThread2.start();

        myThread1.join();
        myThread2.join();

        System.out.println(resource.getX());
    }
}

class MyThread extends Thread {

    private Resource resource;

    public MyThread(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        resource.changeX();
    }
}
