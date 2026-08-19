import java.util.HashSet;
import java.util.Scanner;


public class AsumBAgain {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t--!=0)
        {
            String s=sc.next();
            int sum=0;
            for(int i=0;i<s.length();i++)
            {
                sum+=s.charAt(i)-'0';
            }
            System.out.println(sum);
        }
        sc.close();
    }
}
