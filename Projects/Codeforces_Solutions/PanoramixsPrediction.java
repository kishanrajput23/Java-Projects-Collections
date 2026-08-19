import java.util.Scanner;

public class PanoramixsPrediction {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int i=0;
        if(isprime(n))
        {
            for(i=n+1;i<=m;i++)
            {
                if(isprime(i))
                    {
                        break;
                    }
            }
            if(i==m)
            {
                System.out.println("YES");
            }
            else
            {
                System.out.println("NO");
            }

        }
        else
        {
            System.out.println("NO");
        }
        sc.close();
    }
    static boolean isprime(int n)
    {
        for(int i=2;i<n;i++)
        {
            if(n%i==0)
            return false;
        }
        return true;
    }
}
