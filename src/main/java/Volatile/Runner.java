package main.java.Volatile;

public class Runner {

    private volatile static int x = 0;

    public static void main(String[] args) {
        new WriteThread().start();
        new ReadThread().start();

//        1
//        2
//        local = 1
//        3
//        local = 2
//        4
//        local = 3
//        5
//        local = 4
    }

    static class WriteThread extends Thread {

        @Override
        public void run() {
            while (x < 5) {
                System.out.println(++x);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class ReadThread extends Thread {

        @Override
        public void run() {
            int local = x;
            while (local < 5) {
//                without volatile this part didn't run because x is cached
                if (local != x) {
                    System.out.println("local = " + local);
                    local = x;
                }
            }
        }
    }
}

