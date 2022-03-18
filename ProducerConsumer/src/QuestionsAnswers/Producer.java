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
                questionList.wait(); // waits until it gets notified to continue
            }
        }

        synchronized (questionList) {

            System.out.println("New question: " + questionNo);
            questionList.add(questionNo);
            Random random = new Random();
            Thread.sleep(random.nextInt(2000));
            questionList.notify(); // notifies the thread to wake up and continue processing
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
