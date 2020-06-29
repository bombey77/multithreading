package main.java.Exchanger;

import java.util.concurrent.Exchanger;

public class Client extends Thread {

    private Exchanger<String> exchanger;

    public Client(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            exchanger.exchange("Hi server!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
