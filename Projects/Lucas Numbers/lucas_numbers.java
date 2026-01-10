public class LucasNumbers {
    public static void main(String[] args) {
        int n = 10; // Number of Lucas numbers to generate
        int[] lucasNumbers = new int[n];
        
        lucasNumbers[0] = 2; // The first Lucas number
        lucasNumbers[1] = 1; // The second Lucas number

        for (int i = 2; i < n; i++) {
            lucasNumbers[i] = lucasNumbers[i - 1] + lucasNumbers[i - 2];
        }

        System.out.println("Lucas Numbers:");
        for (int i = 0; i < n; i++) {
            System.out.print(lucasNumbers[i] + " ");
        }
    }
}
