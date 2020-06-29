package main.java.Semaphore;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Runner {

    public static void main(String[] args) {
        Semaphore table = new Semaphore(2);

        List<Pizzeria> list = new ArrayList<>();
        list.add(new Pizzeria(table));
        list.add(new Pizzeria(table));
        list.add(new Pizzeria(table));
        list.add(new Pizzeria(table));
        list.add(new Pizzeria(table));

        for (Pizzeria pizzeria : list) {
            hostingGuest(pizzeria);
        }

//        Thread-3 - is waiting for the table
//        Thread-3 - is eating at the table table
//        Thread-0 - is waiting for the table
//        Thread-1 - is waiting for the table
//        Thread-2 - is waiting for the table
//        Thread-4 - is waiting for the table
//        Thread-0 - is eating at the table table
//        Thread-3 - the table is released
//        Thread-1 - is eating at the table table
//        Thread-0 - the table is released
//        Thread-2 - is eating at the table table
//        Thread-1 - the table is released
//        Thread-4 - is eating at the table table
//        Thread-2 - the table is released
//        Thread-4 - the table is released
    }

    private static void hostingGuest(Thread thread) {
        thread.start();
    }
}
