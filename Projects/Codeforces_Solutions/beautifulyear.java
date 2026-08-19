
import java.util.Scanner;

public class beautifulyear {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        n++;
        while (!hasDistinctDigits(n)) {
            n++;
        }
        System.out.println(n);
            sc.close();
    }
    public static boolean hasDistinctDigits(int year) {
        String s = year+"";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    }

