package main.java.Synchronized;

public class Resource {

    private int x;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public synchronized void changeX() {
        x++;
    }

//    public void changeX() {
//        synchronized (this) {
//            x++;
//        }
//    }
}
