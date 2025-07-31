import java.awt.print.Book;
import java.util.*;


    class Product{
        private int productId;
        private String productName;
        private double price;

        Product(int productId, String productName, double price) {
            this.productId = productId;
            this.productName = productName;
            this.price = price;
        }

        public int getProductId() {
            return productId;
        }

        public String getProductName() {
            return productName;
        }

        public double getPrice() {
            return price;
        }
    }

    class Cart {
        ArrayList<Product> products = new ArrayList<>();

        void addItem(Product product, int quantity) {
            System.out.println(product.getProductName() + ", quantity of " + quantity + " was added.");

            for(int i = 1; i <= quantity; i++) {
                products.add(product);
            }
        }

        void displayItems() {
            for(Product product : products) {
                System.out.println(product.getProductName() + " - " + product.getPrice());
            }

            System.out.println("Subtotal: " + getTotal());
        }

        boolean removeItem(int id) {
            int track = 0;
            for (Product product : products) {
                if (product.getProductId() == id) {
                    System.out.println(product.getProductName() + " was removed.");
                    products.remove(track);
                    return true;
                }

                track++;
            }
            return false;
        }

        double getTotal() {
            double sum = 0;
            for(Product product : products) {
                sum += product.getPrice();
            }
            return sum;
        }



    }




public class Main {
    public static void main(String[] args) {

        // I follow what is on the use stories, i made a revisions

        // The user browses the online store and sees a list of products. //
        // The user adds a “Wireless Mouse” to their shopping cart.       //
        // The user adds two “USB-C Cables” to the cart.                  //
        // The user reviews the cart to see what’s inside and the total price.    //
        // The user removes the “Wireless Mouse” from the cart.           //
        // The user proceeds to checkout and completes the purchase.      //
        Product product1 = new Product(1000, "Wireless Mouse", 18.50);
        Product product2 = new Product(1001, "USB-C Cables", 2.30);

        Cart cart = new Cart();

        cart.addItem(product1, 1);
        cart.addItem(product2, 2);

        cart.displayItems();

        cart.removeItem(1000);

        cart.displayItems();




    }
}