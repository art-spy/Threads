import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class InventoryManager {

    List<Product> soldProductList = new CopyOnWriteArrayList<Product>();
    List<Product> purchasedProductsList = new CopyOnWriteArrayList<Product>();

    public void pupulateSoldProducts() {
        for(int i = 1; i <= 1000; i++) {
            Product prod = new Product (i, "test_product_" + i);
            soldProductList.add(prod);
            System.out.println("Added: " + prod);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void displaySoldProducts() {
        for (Product product: soldProductList) {
            System.out.println("Sold: " + product);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
