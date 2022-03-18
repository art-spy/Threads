public class Main {

    public static Object lock1 = new Object();
    public static Object lock2 = new Object();

    public static void main(String[] args) {
        new Thread1(lock1, lock2).start();
        new Thread2(lock1, lock2).start();

    }




}







