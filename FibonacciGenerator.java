import java.util.Scanner;

public class FibonacciGenerator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of terms in the Fibonacci sequence: ");
        int numTerms = sc.nextInt();

        generateFibonacci(numTerms);

        sc.close();
    }

    public static void generateFibonacci(int numTerms) {
        int[] fibonacciSequence = new int[numTerms];
        fibonacciSequence[0] = 0;
        if (numTerms > 1) {
            fibonacciSequence[1] = 1;
        }

        for (int i = 2; i < numTerms; i++) {
            fibonacciSequence[i] = fibonacciSequence[i - 1] + fibonacciSequence[i - 2];
        }

        System.out.println("Fibonacci sequence up to " + numTerms + " terms:");
        for (int i = 0; i < numTerms; i++) {
            System.out.print(fibonacciSequence[i] + " ");
        }
    }
}
