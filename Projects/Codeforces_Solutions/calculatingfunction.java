import java.util.Scanner;

public class calculatingfunction {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long n=sc.nextLong();
        if(n%2==0)
        {
            System.out.println(n/2);
        }
        else
        {
            System.out.println(-(n+1)/2);
        }
        sc.close();
    }
}
