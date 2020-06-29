package main.java.CyclicBarrier;

public class CarWasher extends Thread {

    @Override
    public void run() {
        System.out.println("The car is washing...");
    }
}
