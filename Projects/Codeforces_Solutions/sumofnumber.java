import java.util.Scanner;

public class sumofnumber{
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t--!=0)
        {
            int num=sc.nextInt();
            String s=num+"";
            int ans=0;
            int i=0;
            for(i=0;i<s.length();i++)
            {
                if(s.charAt(i)!='0')
                 ans++;
            }
            System.out.println(ans);
            i=0;
            ans=0;
            while(num!=0)
            {
                int rem=num%10;
                ans=rem*(int)Math.pow(10,i++);
                if(rem!=0)
                {
                    System.out.print(ans+" ");
                }
                num=num/10;
            }
        }
        sc.close();
    }
}