package orderbook;

import java.util.Scanner;

public class OrderBookApp {
    
    public static void main(String[] args) {

        OrderBook orderBook = new OrderBook();
        Scanner sc = new Scanner(System.in);

        while(true) {

            System.out.println("---ORDER BOOK MENU---");
            System.out.println("1) Add Order");
            System.out.println("2) View Orders");
            System.out.println("3) Delete Order");
            System.out.println("4) Exit");

            int choice = sc.nextInt();
            String id;

            switch (choice) {
                case 1:
                    System.out.print("Enter OrderId: ");
                    id = sc.next();
                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();
                    System.out.print("Enter quantity: ");
                    int quantity = sc.nextInt();
                    System.out.print("Is it a Buy Order(true/false): ");
                    boolean isBuyOrder = sc.nextBoolean();
                    orderBook.addOrder(new Order(id, price, quantity, isBuyOrder));
                    System.out.println("Order added successfully!");
                    break;
                case 2:
                    orderBook.viewOrders();
                    break;
                case 3:
                    if(orderBook.buyOrders.isEmpty() && orderBook.sellOrders.isEmpty()) {
                        System.out.println("There are no orders to be removed.");
                        break;
                    }
                    System.out.print("Enter the OrderId to be removed: ");
                    id = sc.next();
                    boolean isRemoved = orderBook.removeOrders(id);
                    if(isRemoved) {
                        System.out.println("Order Removed Successfully!");
                    } else {
                        System.out.println("No such order.");
                    }
                    break;
                case 4: 
                    System.out.println("exited.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
