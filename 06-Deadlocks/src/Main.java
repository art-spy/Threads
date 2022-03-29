/**
 * Application with two threads that are acquiring two locks on two objects.
 */
public class Main {

    public static Object lock1 = new Object();
    public static Object lock2 = new Object();

    // Use Thread2Deadlock to cause a deadlock.
    public static void main(String[] args) {
        new Thread1(lock1, lock2).start();
        new Thread2(lock1, lock2).start();

        // use Thread2Deadlock to cause a deadlock;
        // new Thread2Deadlock(lock1, lock2).start();

    }




}







