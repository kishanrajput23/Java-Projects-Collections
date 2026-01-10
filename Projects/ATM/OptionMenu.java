import java.text.DecimalFormat; // Import for formatting balance outputs as currency
import java.util.HashMap; // Import for storing customer number and PIN pairs
import java.util.Scanner; // Import for capturing user input from the console

public class OptionMenu extends Account {

    Scanner menuInput = new Scanner(System.in); // Scanner object for reading user input
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00"); // Currency formatter

    HashMap<Integer, Integer> data = new HashMap<>(); // Stores customer number as key, PIN as value

    // Handles login process
    public void getLogin() {
        int x = 1;
        do {
            try {
                // Predefined dummy accounts
                data.put(952141, 191904);
                data.put(989947, 717976);

                System.out.println("Welcome to ATM");
                System.out.println("Enter your Customer Number");
                setCustomerNumber(menuInput.nextInt()); // Reads and sets customer number

                System.out.println("Enter your PIN Number");
                setPinNumber(menuInput.nextInt()); // Reads and sets PIN
            }
            catch(Exception e) {
                // Handles non-numeric input
                System.out.println("\nInvalid Characters Only Numbers Allowed\n" + e);
                x = 2; // Prevents loop continuation on error
            }

            int cn = getCustomerNumber();
            int pn = getPinNumber();

            // Validates login credentials
            if (data.containsKey(cn) && data.get(cn) == pn) {
                getAccountType(); // Proceed to account menu
            }
            else {
                System.out.println("\nWrong Customer Number or Wrong PIN Number\n\n");
            }
        } while (x == 1); // Loop continues until valid login or exception
    }

    // Displays account type options
    public void getAccountType() {
        System.out.println("Select Account Type you want to Access");
        System.out.println("Type 1 - Checking Account");
        System.out.println("Type 2 - Savings Account");
        System.out.println("Type 3 - Exit");

        int selection = menuInput.nextInt();

        // Handles user selection
        switch (selection) {
            case 1 -> getChecking(); // Redirects to checking account menu
            case 2 -> getSaving();   // Redirects to saving account menu
            case 3 -> System.out.println("Thank you for using ATM, BYE\n"); // Exit message
            default -> System.out.println("\n Invalid Choice \n"); // Handles invalid input
        }
    }

    // Menu for checking account options
    public void getChecking() {
        System.out.println("Checking Account");
        System.out.println("Type 1 - View Balance");
        System.out.println("Type 2 - Withdraw Money");
        System.out.println("Type 3 - Deposit Funds");
        System.out.println("Type 4 - Exit");

        int selection = menuInput.nextInt();

        // Handles user selection
        switch (selection) {
            case 1 -> {
                // Display balance
                System.out.println("Checking Account Balance: " + moneyFormat.format(getCheckingBalance()));
                getAccountType(); // Return to main menu
            }
            case 2 -> {
                getCheckingWithdrawInput(); // Perform withdrawal
                getAccountType();
            }
            case 3 -> {
                getCheckingDepositInput(); // Perform deposit
                getAccountType();
            }
            case 4 -> System.out.println("Thank you for using ATM, Bye"); // Exit message
            default -> {
                System.out.println("\nInvalid Choice\n");
                getChecking(); // Re-prompt on invalid input
            }
        }
    }

    // Menu for saving account options
    public void getSaving() {
        System.out.println("Saving Account");
        System.out.println("Type 1 - View Balance");
        System.out.println("Type 2 - Withdraw Money");
        System.out.println("Type 3 - Deposit Funds");
        System.out.println("Type 4 - Exit");
        System.out.print("Choice: ");

        int selection = menuInput.nextInt();

        // Handles user selection
        switch (selection) {
            case 1 -> {
                // Display balance
                System.out.println("Saving Account Balance: " + moneyFormat.format(getSavingBalance()));
                getAccountType(); // Return to main menu
            }
            case 2 -> {
                getSavingWithdrawInput(); // Perform withdrawal
                getAccountType();
            }
            case 3 -> {
                getSavingDepositInput(); // Perform deposit
                getAccountType();
            }
            case 4 -> System.out.println("Thank you for using ATM, Bye\n"); // Exit message
            default -> {
                System.out.println("\nInvalid Choice\n");
                getChecking(); // Re-prompt (note: this may be intended to redirect to saving, consider reviewing)
            }
        }
    }
}
