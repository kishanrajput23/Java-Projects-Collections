import java.util.Scanner;

public class OrderBookApp {

    public static void main(String[] args) {
        Orderbook ob = new Orderbook(true);
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                             ___          _           ____              _         __    _                  \r
                            / _ \\ _ __ __| | ___ _ __| __ )  ___   ___ | | __    / /   (_) __ ___   ____ _ \r
                           | | | | '__/ _` |/ _ \\ '__|  _ \\ / _ \\ / _ \\| |/ /   / /    | |/ _` \\ \\ / / _` |\r
                           | |_| | | | (_| |  __/ |  | |_) | (_) | (_) |   <   / /     | | (_| |\\ V / (_| |\r
                            \\___/|_|  \\__,_|\\___|_|  |____/ \\___/ \\___/|_|\\_\\ /_/     _/ |\\__,_| \\_/ \\__,_|\r
                                                                                     |__/                  """ //
        //
        //
        //
        //
        );
        while (true) {
            System.out.println("Options\n-----------------------------------\n|1. Print Orderbook               |\n|2. Submit order                  |\n|3. Exit                          |\n-----------------------------------\nChoice: ");
            int action = scanner.nextInt();

            if (action == 1) {
                ob.print();
            } else if (action == 2) {
                System.out.println("Enter order type:\n1. Market order\n2. Limit order\nSelection: ");
                int orderTypeInput = scanner.nextInt();
                String orderType = (orderTypeInput == 1) ? "MARKET" : "LIMIT";

                System.out.println("\nEnter side:\n1. Buy\n2. Sell\nSelection: ");
                int sideInput = scanner.nextInt();
                String side = (sideInput == 1) ? "BUY" : "SELL";

                System.out.println("\nEnter order quantity: ");
                int quantity = scanner.nextInt();

                if (orderType.equals("MARKET")) {
                    System.out.println("\nSubmitting market " + (side.equals("BUY") ? "buy" : "sell")
                            + " order for " + quantity + " units..\n");

                    long startTime = System.nanoTime();
                    OrderFill fill = ob.handleOrder(orderType, quantity, side, 0.0);
                    long endTime = System.nanoTime();

                    Helpers.printFill(fill, quantity, startTime, endTime);
                } else if (orderType.equals("LIMIT")) {
                    System.out.println("\nEnter limit price: ");
                    double price = scanner.nextDouble();

                    System.out.println("\nSubmitting limit " + (side.equals("BUY") ? "buy" : "sell")
                            + " order for " + quantity + " units @ \u20B9" + price + "..\n");

                    long startTime = System.nanoTime();
                    OrderFill fill = ob.handleOrder(orderType, quantity, side, price);
                    long endTime = System.nanoTime();

                    Helpers.printFill(fill, quantity, startTime, endTime);
                }
                System.out.println();
            } else if(action == 3) {
                break;
            }
        }
        scanner.close();
        System.out.println("Program terminated.");
    }
}
