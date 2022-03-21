
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Application {

    public static void main(String[] args) {

        BlockingQueue<Integer> questionQueue = new ArrayBlockingQueue<Integer>(5); // expects a Limit for elements in queue

        // populates the question list
        Thread t1 = new Thread(new Producer(questionQueue));
        t1.start();

        // answers and removes the questions from the list
        Thread t2 = new Thread(new Consumer(questionQueue));
        t2.start();

    }

}