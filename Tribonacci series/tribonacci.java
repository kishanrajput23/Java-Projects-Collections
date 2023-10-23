public class TribonacciSeries {
    public static void main(String[] args) {
        int n = 10; // Change this value to the number of Tribonacci numbers you want to generate
        generateTribonacciSeries(n);
    }

    public static void generateTribonacciSeries(int n) {
        if (n <= 0) {
            System.out.println("Invalid input. Please enter a positive integer.");
            return;
        }

        long[] tribonacci = new long[n];
        tribonacci[0] = 0;
        if (n > 1) {
            tribonacci[1] = 1;
        }
        if (n > 2) {
            tribonacci[2] = 1;
        }

        for (int i = 3; i < n; i++) {
            tribonacci[i] = tribonacci[i - 1] + tribonacci[i - 2] + tribonacci[i - 3];
        }

        System.out.println("Tribonacci Series (First " + n + " numbers):");
        for (int i = 0; i < n; i++) {
            System.out.print(tribonacci[i] + " ");
        }
    }
}
