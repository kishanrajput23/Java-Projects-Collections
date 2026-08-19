import java.util.Scanner;

public class RequiredRemainder {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t--!=0)
        {
            int a=sc.nextInt();
            int b=sc.nextInt();
            int c=sc.nextInt();
            System.out.println(((c/a)*a+b<=c)?((c/a)*a+b):((c/a)-1)*a+b);
        }
        sc.close();
    }
}
