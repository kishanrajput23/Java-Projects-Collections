import java.util.*;

public class Buttons
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int annaMoves = a + (c + 1) / 2;
            int katieMoves = b + c / 2;
            if (annaMoves > katieMoves)
                System.out.println("First");
            else
                System.out.println("Second");
        }
    }
}
