import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ExpenseTrackerCLI {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Expense> expenses = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("=== Expense Tracker CLI ===");
        System.out.println("Manage your daily expenses from the terminal.\n");

        boolean running = true;
        while (running) {
            printMenu();
            System.out.print("Choose an option: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1 -> addExpense();
                    case 2 -> viewExpenses();
                    case 3 -> showSummary();
                    case 4 -> {
                        System.out.println("Exiting Expense Tracker. Goodbye!");
                        running = false;
                    }
                    default -> System.out.println("Please enter a valid option.\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a number.\n");
                scanner.nextLine();
            }
        }

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("1. Add expense");
        System.out.println("2. View expenses");
        System.out.println("3. Show summary");
        System.out.println("4. Exit");
    }

    private static void addExpense() {
        System.out.print("Enter description: ");
        String description = scanner.nextLine().trim();

        if (description.isEmpty()) {
            System.out.println("Description cannot be empty.\n");
            return;
        }

        System.out.print("Enter amount: ");
        double amount;
        try {
            amount = scanner.nextDouble();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Amount must be a number.\n");
            scanner.nextLine();
            return;
        }

        System.out.print("Enter category: ");
        String category = scanner.nextLine().trim();
        if (category.isEmpty()) {
            category = "General";
        }

        expenses.add(new Expense(description, amount, category));
        System.out.println("Expense added successfully.\n");
    }

    private static void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded yet.\n");
            return;
        }

        System.out.println("Recorded expenses:");
        for (Expense expense : expenses) {
            System.out.printf("- %s | %.2f | %s%n", expense.description, expense.amount, expense.category);
        }
        System.out.println();
    }

    private static void showSummary() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded yet.\n");
            return;
        }

        double total = 0;
        for (Expense expense : expenses) {
            total += expense.amount;
        }

        System.out.printf("Total expenses: %.2f%n", total);
        System.out.println("Number of entries: " + expenses.size());
        System.out.println();
    }

    private static class Expense {
        private final String description;
        private final double amount;
        private final String category;

        private Expense(String description, double amount, String category) {
            this.description = description;
            this.amount = amount;
            this.category = category;
        }
    }
}
