import java.util.Scanner;
public class ExceptionHandlingExample {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Code that might throw an exception
            System.out.print("Enter the first number: ");
            int num1 = scanner.nextInt();

            System.out.print("Enter the second number: ");
            int num2 = scanner.nextInt();

            int result = num1 / num2; // May throw ArithmeticException
            System.out.println("The result of division is: " + result);
        } catch (ArithmeticException e) {
            // Handles division by zero
            System.out.println("Error: Division by zero is not allowed.");
        } catch (java.util.InputMismatchException e) {
            // Handles invalid input type
            System.out.println("Error: Please enter valid integers.");
        } finally {
            // Executes no matter what
            System.out.println("Execution completed.");
            scanner.close(); 
        }
    }
}
