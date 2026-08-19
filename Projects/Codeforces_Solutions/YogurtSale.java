import java.util.Scanner;

public class YogurtSale {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t--!=0)
        {
            int n=sc.nextInt();
            int a=sc.nextInt();
            int b=sc.nextInt();
            System.out.println(Math.min(n*a,(n/2)*b+((n%2==0)?0:a)));
        }
    }
}
