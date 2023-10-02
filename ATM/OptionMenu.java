import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

public class OptionMenu extends Account {
    
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    HashMap<Integer, Integer> data = new HashMap<>();

    public void getLogin() {
        int x = 1;
        do{
            try{
                data.put(952141, 191904);
                data.put(989947, 717976);

                System.out.println("Welcome to ATM");
                System.out.println("Enter your Customer Number");
                setCustomerNumber(menuInput.nextInt());

                System.out.println("Enter your PIN Number");
                setPinNumber(menuInput.nextInt());
            }
            catch(Exception e){
                System.out.println("\nInvalid Characters Only Numbers Allowed\n" + e);
                x = 2;
            }

            int cn = getCustomerNumber();
            int pn = getPinNumber();
            if(data.containsKey(cn) && data.get(cn) == pn){
                getAccountType();
            }
            else{
                System.out.println("\nWrong Customer Number or Wrong PIN Number\n\n");
            }
        }while(x == 1);
    }

    public void getAccountType() {
        System.out.println("Select Account Type you want to Access");
        System.out.println("Type 1 - Checking Account");
        System.out.println("Type 2 - Savings Account");
        System.out.println("Type 3 - Exit");

        int selection = menuInput.nextInt();

        switch (selection) {
            case 1 -> getChecking();
            case 2 -> getSaving();
            case 3 -> System.out.println("Thank you for using ATM, BYE\n");
            default -> System.out.println("\n Invalid Choice \n");
        }
    }

    public void getChecking() {
        System.out.println("Checking Account");
        System.out.println("Type 1 - View Balance");
        System.out.println("Type 2 - Withdraw Money");
        System.out.println("Type 3 - Deposit Funds");
        System.out.println("Type 4 - Exit");

        int selection = menuInput.nextInt();

        switch (selection) {
            case 1 -> {
                System.out.println("Checking Account Balance: " + moneyFormat.format(getCheckingBalance()));
                getAccountType();
            }
            case 2 -> {
                getCheckingWithdrawInput();
                getAccountType();
            }
            case 3 -> {
                getCheckingDepositInput();
                getAccountType();
            }
            case 4 -> System.out.println("Thank you for using ATM, Bye");
            default -> {
                System.out.println("\nInvalid Choice\n");
                getChecking();
            }
        }
    }

    public void getSaving() {
        System.out.println("Saving Account");
        System.out.println("Type 1 - View Balance");
        System.out.println("Type 2 - Withdraw Money");
        System.out.println("Type 3 - Deposit Funds");
        System.out.println("Type 4 - Exit");
        System.out.print("Choice: ");

        int selection = menuInput.nextInt();

        switch (selection) {
            case 1 -> {
                System.out.println("Saving Account Balance: " + moneyFormat.format(getSavingBalance()));
                getAccountType();
            }
            case 2 -> {
                getSavingWithdrawInput();
                getAccountType();
            }
            case 3 -> {
                getSavingDepositInput();
                getAccountType();
            }
            case 4 -> System.out.println("Thank you for using ATM, Bye\n");
            default -> {
                System.out.println("\nInvalid Choice\n");
                getChecking();
            }
        }
    }
}