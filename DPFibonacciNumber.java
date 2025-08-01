import java.util.Scanner;

public class DPFibonacciNumber {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter a number: ");
    int input = scanner.nextInt();

    if (input < 0) {
      System.out.println("Number must be greater than 0");
    } else {
      System.out.println(input + "th "+ "fibonacci number: " + fibonacciNumber(input));
    }
    

  }
  public static int fibonacciNumber(int n) {
    if (n == 0) {
      return 0;
    }

    int[] dp = new int[n + 1];
    dp[1] = 1;

    for(int i = 2; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }

    return dp[n];
  }
}
