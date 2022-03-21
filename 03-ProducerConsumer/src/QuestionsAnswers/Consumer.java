package QuestionsAnswers;

import java.util.List;
import java.util.Random;

/**
 * Consumer takes questions from a list.
 */

public class Consumer implements Runnable{

    List<Integer> questionList = null; // shared List between Producer and Consumer

    public Consumer(List<Integer> questionList) {
        this.questionList = questionList;
    }

    public void answerQuestion() throws InterruptedException {
        synchronized (questionList) {
            while(questionList.isEmpty()) {
                System.out.println("No questions to answer, waiting for Producer to ask questions.");

                // Causes the current thread to wait until it is awakened, typically by being notified or interrupted.
                questionList.wait();
            }
        }

        synchronized (questionList) {
            Random random = new Random();
            Thread.sleep(random.nextInt(3000)); // usually it takes longer to answer a question than ask one

            System.out.println("Answered question: " + questionList.remove(0));

            // Wakes up a single thread that is waiting on this object's monitor.
            // If any threads are waiting on this object, one of them is chosen to be awakened.
            questionList.notify();
        }

    }

    @Override
    public void run() {

        while(true) {
            try {
                answerQuestion();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
