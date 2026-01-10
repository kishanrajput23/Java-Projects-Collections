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

            switch (choice) {
                case 1:
                    System.out.println("Balance: " + atm.getBalance());
                    break;

                case 2:
                    System.out.println("Enter the amount to deposit:");
                    int depositAmount = sc.nextInt();
                    atm.deposit(depositAmount);
                    break;

                case 3:
                    System.out.println("Enter the amount to withdraw:");
                    int withdrawAmount = sc.nextInt();
                    atm.withdraw(withdrawAmount);
                    break;

                case 4:
                    System.out.println("1. OM");
                    System.out.println("2. SHAM");
                    System.out.println("3. KARAN");
                    System.out.println("4. RAMAN");
                    System.out.println("ENTER THE RECIPIENT:");
                    int recipient = sc.nextInt();
                    
                    System.out.println("Enter amount to transfer:");
                    int transferAmount = sc.nextInt();
                    
                    if (transferAmount <= 0) {
                        System.out.println("Invalid amount");
                        break;
                    }
                    
                    if (transferAmount > atm.getBalance()) {
                        System.out.println("Insufficient balance");
                        break;
                    }
                    
                    int gst = transferAmount * 2 / 100;
                    atm.withdraw(transferAmount + gst);
                    System.out.println("Transfer successful to recipient " + recipient);
                    System.out.println("GST (2%): " + gst);
                    System.out.println("Current balance: " + atm.getBalance());
                    break;

                case 5:
                    System.out.println("Enter current password:");
                    int currentPin = sc.nextInt();
                    
                    if (!atm.verifyPassword(currentPin)) {
                        System.out.println("Wrong password");
                        break;
                    }
                    
                    System.out.println("Enter new password:");
                    int newPin = sc.nextInt();
                    System.out.println("Confirm new password:");
                    int confirmPin = sc.nextInt();
                    
                    if (newPin == confirmPin) {
                        atm.changePassword(newPin);
                    } else {
                        System.out.println("Passwords don't match");
                    }
                    break;

                case 6:
                    sessionActive = false;
                    System.out.println("Thank you for banking with us!");
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        }
        sc.close();
    }
}
