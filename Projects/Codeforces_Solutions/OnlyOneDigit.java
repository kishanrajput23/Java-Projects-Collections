import java.util.Scanner;

public class OnlyOneDigit
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t--!=0)
        {
            String s=sc.next();
            int ans=Integer.MAX_VALUE;
            for(int i=0;i<s.length();i++)
            {
                ans=Math.min(ans,s.charAt(i)-'0');
            }
            System.out.println(ans);
        }
        sc.close();
    }
}