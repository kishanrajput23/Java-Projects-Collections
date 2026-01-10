package hello;
import java.util.*;
public class Atm {
    private static class ATM {
        private int balance = 5000;
        private static int password = 1991;
        public int getBalance() {
            return balance;
        }
        public void deposit(int amount) {
            if (amount > 0) {
                balance += amount;
                System.out.println("Deposit successful. Current balance: " + balance);
            } else {
                System.out.println("Invalid deposit amount");
            }
        }
        public void withdraw(int amount) {
            if (amount <= 0) {
                System.out.println("Invalid withdrawal amount");
            } else if (balance >= amount) {
                balance -= amount;
                int gst = amount * 2 / 100;
                balance -= gst;
                System.out.println("Withdrawal successful. GST (2%): " + gst);
                System.out.println("Current balance: " + balance);
            } else {
                System.out.println("Insufficient balance");
            }
        }
        public boolean verifyPassword(int input) {
            return input == password;
        }
        public void changePassword(int newPassword) {
            password = newPassword;
            System.out.println("Password updated successfully");
        }
    }
    public static void main(String[] args) {
        ATM atm = new ATM();
        Scanner sc = new Scanner(System.in);
        boolean sessionActive = true;
        System.out.println("Enter the User Name:");
        String username = sc.nextLine();
        if (!username.equals("chaitanya")) {
            System.out.println("Invalid username");
            return;
        }
        while (sessionActive) {
            System.out.println("ENTER THE PASSWORD:");
            int pin = sc.nextInt();
            if (!atm.verifyPassword(pin)) {
                System.out.println("Wrong password. Transaction cancelled.");
                continue;
            }
            System.out.println("__WELCOME__");
            System.out.println("\nWelcome to --------BANK OF INDIA-------:");
            System.out.println("1. Check the balance");
            System.out.println("2. Deposit the amount");
            System.out.println("3. Withdraw the amount");
            System.out.println("4. Send Money");
            System.out.println("5. Change Password");
            System.out.println("6. Exit");
            System.out.println("___________________________________");
            System.out.println("ENTER YOUR CHOICE:");
            int choice = sc.nextInt();
            // ...existing code...
        }
    }
}
