package QuestionsAnswers;

import java.util.List;
import java.util.Random;

/**
 * Producer puts questions inside a list.
 */

public class Producer implements Runnable{

    List<Integer> questionList = null; // shared List between Producer and Consumer
    final int LIMIT = 5;
    private int questionNo;

    public Producer(List<Integer> questionList) {
        this.questionList = questionList;
    }

    public void askQuestion(int questionNo) throws InterruptedException {
        synchronized (questionList) {
            while(questionList.size() == LIMIT) {
                // Thread.sleep(1000);
                System.out.println("Too many questions, waiting for Consumer to answer questions.");

                // Causes the current thread to wait until it is awakened, typically by being notified or interrupted.
                questionList.wait();
            }
        }

        synchronized (questionList) {
            System.out.println("New question: " + questionNo);
            questionList.add(questionNo);

            Random random = new Random();
            Thread.sleep(random.nextInt(1000)); // usually it's faster to ask a question than to answer one

            // Wakes up a single thread that is waiting on this object's monitor.
            // If any threads are waiting on this object, one of them is chosen to be awakened.
            questionList.notify();
        }

    }

    @Override
    public void run() {

        while(true) {
            try {
                askQuestion(questionNo++);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
