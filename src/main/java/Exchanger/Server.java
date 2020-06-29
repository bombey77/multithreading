package main.java.Exchanger;

import java.util.concurrent.Exchanger;

public class Server extends Thread {

    private Exchanger<String> exchanger;

    public Server(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            System.out.println(exchanger.exchange(null));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
