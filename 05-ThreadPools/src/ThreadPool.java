import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {

    public static void main(String[] args) {

        final int numberOfThreads = 3;
        final int numberOfMessages = 10;

        // pool comes from the Executors class
        // 2 threads allowed in this pool
        ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);

        for(int i = 1; i <= numberOfMessages; i++){
            Runnable processor = new MessageProcessor(i);
            executor.execute(processor);
        }

        executor.shutdown(); // Rejects any new services from being submitted. Gracefully shuts down the service.

        // infinite-loop runs while executor is running
        while(!executor.isTerminated()){

        }

        // printed only after executor shuts down and infinite-loop ends
        System.out.println("Submitted all tasks :)");

    }

}
