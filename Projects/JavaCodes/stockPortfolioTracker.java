import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Stock {
    private String symbol;
    private String name;
    private double price;
    private int quantity;

    public Stock(String symbol, String name, double price, int quantity) {
        this.symbol = symbol;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public double getValue() {
        return price * quantity;
    }

    public String getSymbol() {
        return symbol;
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
}

public class StockPortfolioTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Stock> portfolio = new ArrayList<>();

        while (true) {
            System.out.println("Stock Portfolio Tracker Menu:");
            System.out.println("1. Add Stock");
            System.out.println("2. View Portfolio");
            System.out.println("3. Exit");
            System.out.print("Select an option (1/2/3): ");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    scanner.nextLine();
                    System.out.print("Enter stock symbol: ");
                    String symbol = scanner.nextLine();
                    System.out.print("Enter stock name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter stock price: $");
                    double price = scanner.nextDouble();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();

                    portfolio.add(new Stock(symbol, name, price, quantity));
                    System.out.println("Stock added successfully.");
                    break;
                case 2:
                    if (portfolio.isEmpty()) {
                        System.out.println("Your portfolio is empty.");
                    } else {
                        System.out.println("Stock Portfolio:");
                        for (Stock stock : portfolio) {
                            System.out.println("Symbol: " + stock.getSymbol());
                            System.out.println("Name: " + stock.getName());
                            System.out.println("Price: $" + stock.getPrice());
                            System.out.println("Quantity: " + stock.getQuantity());
                            System.out.println("Value: $" + stock.getValue());
                            System.out.println();
                        }
                    }
                    break;
                case 3:
                    System.out.println("Exiting the Stock Portfolio Tracker.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please select 1, 2, or 3.");
            }
        }
    }
}
