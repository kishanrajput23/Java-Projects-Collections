import java.util.Scanner;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;

        System.out.println("Enter numbers (enter 0 to calculate the sum):");

        while (true) {
            int number = scanner.nextInt();
            if (number == 0) {
                break; // Exit the loop if the user enters 0
            }
            sum += number;
        }

        System.out.println("The sum of the numbers is: " + sum);

        scanner.close(); // Don't forget to close the scanner
    }
}