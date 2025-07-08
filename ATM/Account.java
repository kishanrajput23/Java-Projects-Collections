import java.text.DecimalFormat; // Import for formatting numbers into currency format
import java.util.Scanner; // Import for taking user input from the console

public class Account {

    private int customerNumber; // Stores customer number
    private int pinNumber; // Stores customer's PIN
    private double checkingBalance = 0; // Stores checking account balance
    private double savingBalance = 0; // Stores saving account balance

    Scanner input = new Scanner(System.in); // Scanner object for user input
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00"); // Format to display currency values

    // Sets the customer number
    public void setCustomerNumber(int customerNumber){
        this.customerNumber = customerNumber;
    }

    // Returns the customer number
    public int getCustomerNumber(){
        return customerNumber;
    }

    // Sets the PIN number
    public void setPinNumber(int pinNumber){
        this.pinNumber = pinNumber;
    }

    // Returns the PIN number
    public int getPinNumber(){
        return pinNumber;
    }

    // Returns the checking account balance
    public double getCheckingBalance() {
        return checkingBalance;
    }

    // Returns the saving account balance
    public double getSavingBalance(){
        return savingBalance;
    }

    // Deducts the amount from checking account
    public void calcCheckingWithdraw(double amount){
        checkingBalance = (checkingBalance - amount);
    }

    // Deducts the amount from saving account
    public void calcSavingWithdraw(double amount){
        savingBalance = (savingBalance - amount);
    }

    // Adds the amount to checking account
    public void calcCheckingDeposit(double amount){
        checkingBalance = (checkingBalance + amount);
    }

    // Adds the amount to saving account
    public void calcSavingDeposit(double amount){
        savingBalance = (savingBalance + amount);
    }

    // Prompts user to withdraw money from checking account
    public void getCheckingWithdrawInput() {
        System.out.println("Checking Account balance: " + moneyFormat.format(checkingBalance));
        System.out.print("Amount you want to withdraw from Checking Account: ");
        double amount = input.nextDouble();

        if(checkingBalance - amount >= 0){
            calcCheckingWithdraw(amount);
            System.out.println("New Checking Account Balance: " + moneyFormat.format(checkingBalance));
        }
        else{
            System.out.println("Not Enough Money to Withdraw");
        }
    }

    // Prompts user to withdraw money from saving account
    public void getSavingWithdrawInput() {
        System.out.println("Saving Account balance: " + moneyFormat.format(savingBalance));
        System.out.print("Amount you want to withdraw from Saving Account: ");
        double amount = input.nextDouble();

        if(savingBalance - amount >= 0){
            calcSavingWithdraw(amount);
            System.out.println("New Saving Account Balance: " + moneyFormat.format(savingBalance));
        }
        else{
            System.out.println("Not Enough Money to Withdraw");
        }
    }

    // Prompts user to deposit money into checking account
    public void getCheckingDepositInput(){
        System.out.println("Checking Account Balance: " + moneyFormat.format(checkingBalance));
        System.out.print("Amount you want to deposit to Checking Account: ");
        double amount = input.nextDouble();

        if(checkingBalance + amount >= 0){
            calcCheckingDeposit(amount);
            System.out.println("New Checking Account Balance: " + moneyFormat.format(checkingBalance));
        }
        else{
            System.out.println("No Money to Deposit");
        }
    }

    // Prompts user to deposit money into saving account
    public void getSavingDepositInput(){
        System.out.println("Saving Account Balance: " + moneyFormat.format(savingBalance));
        System.out.print("Amount you want to deposit to Saving Account: ");
        double amount = input.nextDouble();

        if(checkingBalance + amount >= 0){
            calcSavingDeposit(amount);
            System.out.println("New Saving Account Balance: " + moneyFormat.format(savingBalance));
        }
        else{
            System.out.println("No Money to Deposit");
        }
    }

}
