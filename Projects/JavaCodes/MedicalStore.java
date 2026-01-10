import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MedicalStore {
    public static class Product {
        private int id;
        private String name;
        private double price;
        private int quantity;

        public Product(int id, String name, double price, int quantity) {
            this.id = id;
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }

    private List<Product> products;

    public MedicalStore() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void listProducts() {
        System.out.println("Products available:");
        for (Product product : products) {
            System.out.println(product.getId() + ". " + product.getName() + " - $" + product.getPrice());
        }
    }

    public Product findProductById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public void sellProduct(int productId, int quantity) {
        Product product = findProductById(productId);
        if (product != null && product.getQuantity() >= quantity) {
            product.setQuantity(product.getQuantity() - quantity);
            System.out.println(quantity + " " + product.getName() + " sold for $" + (product.getPrice() * quantity));
        } else {
            System.out.println("Product not available or insufficient quantity.");
        }
    }

    public static void main(String[] args) {
        MedicalStore store = new MedicalStore();
        store.addProduct(new Product(1, "Painkiller", 5.99, 50));
        store.addProduct(new Product(2, "Bandages", 3.49, 100));
        store.addProduct(new Product(3, "Vitamins", 8.99, 30);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. List Products");
            System.out.println("2. Sell Product");
            System.out.println("3. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    store.listProducts();
                    break;
                case 2:
                    System.out.print("Enter product ID: ");
                    int productId = scanner.nextInt();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    store.sellProduct(productId, quantity);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
