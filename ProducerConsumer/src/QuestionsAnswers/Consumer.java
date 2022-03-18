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
                questionList.wait(); // waits until it gets notified to continue
            }
        }

        synchronized (questionList) {
            System.out.println("Answered question: " + questionList.remove(0));

            Random random = new Random();
            Thread.sleep(random.nextInt(2000));

            questionList.notify(); // notifies the thread to wake up and continue processing
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
