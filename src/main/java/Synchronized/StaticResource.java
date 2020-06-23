package main.java.Synchronized;

public class StaticResource {

    private static int x;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public static synchronized void changeX() {
        x++;
    }

//    Note!!! Don't mix static and non static synchronization at the same time

//    public void changeX() {
//        synchronized (StaticResource.class) {
//            x++;
//        }
//    }
}
