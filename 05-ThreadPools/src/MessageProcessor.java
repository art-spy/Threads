public class MessageProcessor implements Runnable {

    private int message;

    public MessageProcessor(int message){
        this.message = message;

    }

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + "[Received] Message = " + message);
        process(); // make thread sleep to simulate doing some work
        System.out.println(Thread.currentThread().getName() + "[Done] Processing Message = " + message);
        process(); // make thread sleep to simulate doing some work

    }

    private void process() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Unable to process message " + message);
        }

    }
}
