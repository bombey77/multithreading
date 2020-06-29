package main.java.Exchanger;

import java.util.concurrent.Exchanger;

public class Runner {

    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();

        Client client = new Client(exchanger);
        client.start();

        Server server = new Server(exchanger);
        server.start();
    }
}
