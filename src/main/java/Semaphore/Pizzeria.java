package main.java.Semaphore;

import java.util.concurrent.Semaphore;

public class Pizzeria extends Thread {

    private Semaphore table;

    public Pizzeria(Semaphore table) {
        this.table = table;
    }

    public Semaphore getTable() {
        return table;
    }

    public void setTable(Semaphore table) {
        this.table = table;
    }

    @Override
    public void run() {
        System.out.println(getName() + " - is waiting for the table");
        try {
            table.acquire();
            System.out.println(getName() + " - is eating at the table table");
            Thread.sleep(2000);
            table.release();
            System.out.println(getName() + " - the table is released");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
