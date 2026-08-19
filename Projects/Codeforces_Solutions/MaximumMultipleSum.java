import java.util.Scanner;

public class MaximumMultipleSum
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t--!=0)
        {
            int n=sc.nextInt();
            if(n==3)
            System.out.println("3");
            else if(n==1)
            System.out.println("0");
            else
            System.out.println("2");
        }
        sc.close();
    }
}
