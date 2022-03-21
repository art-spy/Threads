public class Thread2Deadlock extends Thread {

    private static Object lock1 = null;
    private static Object lock2 = null;

    public Thread2Deadlock(Object lock1, Object lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    /**
     * Acquires lock-1 on object-1 and lock-2 on object-2.
     * This run-method-version causes a deadlock.
     */
    public void run() {
        synchronized (lock2) {
            System.out.println("Thread 2: Has acquired lock-2 on object-2");
            try {Thread.sleep(500);}
            catch(InterruptedException e) {}

            System.out.println("Thread 2: Waiting for acquiring lock-1 on object-1");
            try {Thread.sleep(500);}
            catch(InterruptedException e) {}

            synchronized (lock1) {
                System.out.println("Thread 2: Has acquired lock-1  on object-1 and lock-2 on object-2");
                try {Thread.sleep(500);}
                catch(InterruptedException e) {}
            }
            System.out.println("Thread 2: released lock-1 from object-1");
            try {Thread.sleep(500);}
            catch(InterruptedException e) {}
        }
        System.out.println("Thread 2: Released lock-2 from object-2. Exiting...");
        try {Thread.sleep(500);}
        catch(InterruptedException e) {}
    }

}