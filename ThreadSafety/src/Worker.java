class Worker extends Thread {

    Sequence sequence = null;

    public Worker(Sequence sequence) {
        this.sequence = sequence;
    }

    public void run() {
        for(int i=0; i < 100; i++) {
            synchronized(sequence) {
                System.out.println(Thread.currentThread().getName() + " vot value: " + sequence.getNext());
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}