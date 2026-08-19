import java.util.*;

public class HalloumiBoxes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            int[] sorted = arr.clone();
            Arrays.sort(sorted);

            if (k == 1 && !Arrays.equals(arr, sorted)) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }
}
