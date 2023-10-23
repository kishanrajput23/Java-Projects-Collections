import java.util.Scanner;

public class CandyVendor {

    private int candies;
    private int money;

    public CandyVendor(int can) {
        this.candies = can;
        this.money = 0;
    }

    public int buy(int amt) {
        if (amt < 1 || candies == 0) {
            return 0;
        }

        if (amt > candies) {
            amt = candies;
        }

        candies -= amt;
        money += amt;

        return amt;
    }

    public void print() {
        System.out.println("Candies left: " + candies);
        System.out.println("Money collected: " + money);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the candy vending machine!");

        int candies = sc.nextInt();

        CandyVendor vendor = new CandyVendor(candies);

        while (true) {
            System.out.println("How much money do you want to insert?");

            int money = sc.nextInt();

            int candiesDispensed = vendor.buy(money);

            if (candiesDispensed == 0) {
                System.out.println("Not enough candies or money!");
            } else {
                System.out.println("Here are your candies!");
            }

            vendor.print();

            System.out.println("Do you want to buy more candy? (y/n)");

            String choice = sc.next();

            if (!choice.equalsIgnoreCase("y")) {
                break;
            }
        }

        sc.close();
    }
}