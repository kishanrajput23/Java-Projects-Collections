import java.util.Scanner;

public class PolycarpandCoins {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t--!=0)
        {
            int n=sc.nextInt();
            if(n%3==0)
            {
                System.out.println(n/3+" "+n/3);
            }
            else
            {
                int mid=n/3;
                if(mid+(mid+1)*2==n)
                {
                    System.out.println(mid+" "+(mid+1));
                }
                else
                {
                    System.out.println((mid+1)+" "+mid);
                }
            }
        }
        sc.close();
    }
}
