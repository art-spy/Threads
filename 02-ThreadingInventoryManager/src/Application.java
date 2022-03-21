public class Application {

    public static void main(String[] args) throws InterruptedException {

        InventoryManager manager = new InventoryManager();

        Thread inventoryTask = new Thread(new Runnable() {
            @Override
            public void run() {
                manager.pupulateSoldProducts();
            }
        });

        Thread displayTask = new Thread(new Runnable() {
            @Override
            public void run() {
                manager.displaySoldProducts();
            }
        });

        inventoryTask.start();
        Thread.sleep(2000); // wair until the list have at least some objects
        // inventoryTask.join(); // wait until inventoryTask.start(); is finished
        displayTask.start();

    }

}
