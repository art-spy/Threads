public class Thread2 extends Thread {

    private static Object lock1 = null;
    private static Object lock2 = null;

    public Thread2(Object lock1, Object lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    /**
     * Acquires lock-1 on object-1 and lock-2 on object-2.
     * The order of acquiring locks is the same for every thread and it's synchronized, so a deadlock can't occur.
     * If the order of the locks in ONE of the two threads would be the other way around
     * (e.g. one of the threads is first acquiring lock-2 and then lock-1)
     * it would cause a deadlock.
     */
    public void run() {
        synchronized (lock1) {
            System.out.println("Thread 2: Has acquired lock-1 on object-1");
            try {Thread.sleep(500);}
            catch(InterruptedException e) {}

            System.out.println("Thread 2: Waiting for acquiring lock-2 on object-2");
            try {Thread.sleep(500);}
            catch(InterruptedException e) {}

            synchronized (lock2) {
                System.out.println("Thread 2: Has acquired lock- 1  on object-1 and lock-2 on object-2");
                try {Thread.sleep(500);}
                catch(InterruptedException e) {}
            }
            System.out.println("Thread 2: released lock-2 from object-2");
            try {Thread.sleep(500);}
            catch(InterruptedException e) {}
        }
        System.out.println("Thread 2: Released lock-1 from object-1. Exiting...");
        try {Thread.sleep(500);}
        catch(InterruptedException e) {}
    }

}