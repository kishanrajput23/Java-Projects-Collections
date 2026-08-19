import java.util.*;

public class UnitedWeStand {
    static void solve(Scanner sc) {
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);

        // If all elements are equal → no solution
        if (a[0] == a[n - 1]) {
            System.out.println("-1");
            return;
        }

        // Count how many times the smallest element occurs
        int it = 0;
        while (it < n && a[it] == a[0]) it++;

        // Output sizes
        System.out.println(it + " " + (n - it));

        // Array b = all smallest elements
        for (int j = 0; j < it; j++) System.out.print(a[j] + " ");
        System.out.println();

        // Array c = the rest
        for (int j = it; j < n; j++) System.out.print(a[j] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            solve(sc);
        }
    }
}
