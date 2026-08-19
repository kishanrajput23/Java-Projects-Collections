import java.util.Scanner;
public class prime{
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int count=0;
        for (int i=1;i<=n;i++)
        {
            if(n%i==0)
            count++;
        }
        if(count==2)
        {
            System.out.println("prime");
        }
        else
        {
            System.out.println("not prime");
        }
        sc.close();
    }
}
