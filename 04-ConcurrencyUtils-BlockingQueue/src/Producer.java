
import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * Producer puts questions inside a list.
 */

public class Producer implements Runnable{

    int questionNo;
    BlockingQueue<Integer> questionQueue = null; // shared List between Producer and Consumer

    public Producer(BlockingQueue<Integer> questionQueue) {
        this.questionQueue = questionQueue;
    }

    @Override
    public void run() {
        while(true){
            // synchronized block -> atomic operation
            try {
                synchronized (this){
                    Random random = new Random();
                    Thread.sleep(random.nextInt(1000)); // usually it's faster to ask a question than to answer one

                    // getNextQuestion() is an atomic operation
                    int nextQuestion = questionNo++;
                    System.out.println("Got new Question: " + nextQuestion);
                    // "put" is thread-save, "add" is not!
                    questionQueue.put(nextQuestion);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
