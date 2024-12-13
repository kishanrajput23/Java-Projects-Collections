import java.util.Scanner;

public class recursiveFactorial {

    public static void main(String args[]) {
        // Scanner object for capturing the user input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number:");
        // Stored the entered value in variable
        int num = scanner.nextInt();
        // Called the user defined function fact
        int factorial = fact(num);
        System.out.println("Factorial of entered number is: " + factorial);
    }

    static int fact(int n) {
        int output;
        if (n == 1) {
            return 1;
        }
        // Recursion: Function calling itself!!
        output = fact(n - 1) * n;
        return output;
    }
}
