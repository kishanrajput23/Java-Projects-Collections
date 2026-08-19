import java.util.*;
public class luckynumber {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long n=sc.nextLong();
        int count=0;
        String s=n+"";
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='4'||s.charAt(i)=='7')
            {
                count++;
            }
        }
        s=count+"";
        count=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='4'||s.charAt(i)=='7')
            {
                count++;
            }
        }
        if(count==s.length())
        System.out.println("YES");
        else
        System.out.println("NO");
        sc.close();
    }
}
