import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Expense {
    private String description;
    private double amount;

    public Expense(String description, double amount) {
        this.description = description;
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Description: " + description + ", Amount: $" + amount;
    }
}

public class ExpenseTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Expense> expenses = new ArrayList<>();
        double totalExpenses = 0.0;

        while (true) {
            System.out.println("Expense Tracker Menu:");
            System.out.println("1. Add an expense");
            System.out.println("2. View expenses");
            System.out.println("3. Exit");
            System.out.print("Select an option (1/2/3): ");
            
            int option = scanner.nextInt();
            
            switch (option) {
                case 1:
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter expense description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter expense amount: $");
                    double amount = scanner.nextDouble();
                    expenses.add(new Expense(description, amount));
                    totalExpenses += amount;
                    System.out.println("Expense added successfully.");
                    break;
                case 2:
                    if (expenses.isEmpty()) {
                        System.out.println("No expenses recorded yet.");
                    } else {
                        System.out.println("List of Expenses:");
                        for (Expense expense : expenses) {
                            System.out.println(expense);
                        }
                        System.out.println("Total Expenses: $" + totalExpenses);
                    }
                    break;
                case 3:
                    System.out.println("Exiting the Expense Tracker.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please select 1, 2, or 3.");
            }
        }
    }
}
