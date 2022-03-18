package QuestionsAnswers;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        List<Integer> questionList = new ArrayList<Integer>();

        // populates the question list
        Thread t1 = new Thread(new Producer(questionList));
        t1.start();

        // answers and removes the questions from the list
        Thread t2 = new Thread(new Consumer(questionList));
        t2.start();

    }

}
