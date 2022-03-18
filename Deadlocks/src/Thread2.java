public class Thread2 extends Thread {

    private static Object lock1 = null;
    private static Object lock2 = null;

    public Thread2(Object lock1, Object lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    public void run() {
        synchronized (lock1) {
            System.out.println("Thread 2: Has lock1");
            try {Thread.sleep(500);}
            catch(InterruptedException e) {}

            System.out.println("Thread 2: Waiting for lock2");
            try {Thread.sleep(500);}
            catch(InterruptedException e) {}

            synchronized (lock2) {
                System.out.println("Thread 2: Has lock1 and lock2");
                try {Thread.sleep(500);}
                catch(InterruptedException e) {}
            }
            System.out.println("Thread 2: released lock2");
            try {Thread.sleep(500);}
            catch(InterruptedException e) {}
        }
        System.out.println("Thread 2: Released lock1. Exiting...");
        try {Thread.sleep(500);}
        catch(InterruptedException e) {}
    }
}