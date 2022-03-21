
import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * Consumer takes questions from a list.
 */

public class Consumer implements Runnable{

    BlockingQueue<Integer> questionQueue = null; // shared List between Producer and Consumer

    public Consumer(BlockingQueue<Integer> questionQueue) {
        this.questionQueue = questionQueue;
    }

    @Override
    public void run() {
        while(true){
            try {
                Random random = new Random();
                Thread.sleep(random.nextInt(3000)); // usually it takes longer to answer a question than ask one

                // take -> Retrieves and removes the head of this queue, waiting if necessary until an element becomes available.
                System.out.println("Answered question: " + questionQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
