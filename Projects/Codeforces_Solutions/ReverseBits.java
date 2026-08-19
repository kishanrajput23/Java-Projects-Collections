
public class ReverseBits {
   /* // Function to reverse t4he bits of a given number
    public static long reverseBits(int n) {
        long result = 0;
        for (int i = 0; i < 32; i++) {
            // Shift result to left to make space for the next bit
            result <<= 1;
            // Add the least significant bit of n to result
            result |= (n & 1);
            // Right shift n to process the next bit
            n >>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // Number of test cases
        while (T-- > 0) {
            int N = scanner.nextInt(); // Read each number
            System.out.println(reverseBits(N)); // Output the result
        }
        scanner.close();
    }*/
    
        public static String addBinary(String x, String y) {
            int num1 = Integer.parseInt(x, 2);
            int num2 = Integer.parseInt(y, 2);
            int sum = num1 + num2;
            return Integer.toBinaryString(sum);
        }
    
        public static void main(String[] args) {
            String x = "11";
            String y = "1";
            System.out.println("Sum: " + addBinary(x, y));
        }
    
}
