import java.util.List;

public class Thread1 extends Thread {

    private static Object lock1 = null;
    private static Object lock2 = null;

    public Thread1(Object lock1, Object lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    public void run() {
        synchronized (lock1) {
            System.out.println("Thread 1: Has lock1");
            try {Thread.sleep(500);}
            catch(InterruptedException e) {}

            System.out.println("Thread 1: Waiting for lock 2");
            try {Thread.sleep(500);}
            catch(InterruptedException e) {}

            synchronized (lock2) {
                System.out.println("Thread 1: Has lock1 and lock2");
                try {Thread.sleep(500);}
                catch(InterruptedException e) {}
            }
            System.out.println("Thread 1: Released lock2");
            try {Thread.sleep(500);}
            catch(InterruptedException e) {}
        }
        System.out.println("Thread 1: Released lock1. Exiting...");
        try {Thread.sleep(500);}
        catch(InterruptedException e) {}
    }
}