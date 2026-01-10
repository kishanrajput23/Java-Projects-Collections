import java.util.Scanner;

public class BudgetTracker {
    private double balance;

    public BudgetTracker() {
        balance = 0.0;
    }

    public void addIncome(double amount) {
        balance += amount;
    }

    public void addExpense(double amount) {
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BudgetTracker tracker = new BudgetTracker();

        while (true) {
            System.out.println("1. Add Income");
            System.out.println("2. Add Expense");
            System.out.println("3. View Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter income amount: ");
                    double income = scanner.nextDouble();
                    tracker.addIncome(income);
                    break;
                case 2:
                    System.out.print("Enter expense amount: ");
                    double expense = scanner.nextDouble();
                    tracker.addExpense(expense);
                    break;
                case 3:
                    System.out.println("Current Balance: Rs" + tracker.getBalance());
                    break;
                case 4:
                    System.out.println("Exiting... Thank you!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}