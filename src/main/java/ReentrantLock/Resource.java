package main.java.ReentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Resource {

    private int x = 0;
    private Lock lock = new ReentrantLock();

    public void changeX() {
        lock.lock();
        int x = this.x;

        Thread.yield();
        x++;
        this.x = x;
        lock.unlock();
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }
}
