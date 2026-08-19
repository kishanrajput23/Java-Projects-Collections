import java.util.Scanner;

public class MaximumGCD {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t--!=0)
        {
            int a=sc.nextInt();
            /* int ans=1;
            for(int i=a;i>=2;i--)
            {
                for(int j=i-1;j>=2;j--)
                {
                    if(i%j==0)
                    {
                        ans=Math.max(j,ans);
                        break;
                    }
                }
            } */
            System.out.println(a/2);
        }
        sc.close();
    }
}
