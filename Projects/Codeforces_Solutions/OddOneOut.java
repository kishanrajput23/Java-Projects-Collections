import java.util.Scanner;

public class OddOneOut {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t--!=0)
        {
            int a=sc.nextInt();
            int b=sc.nextInt();
            int c=sc.nextInt();
            if(a==b)
            System.out.println(c);
            else if(a==c)
            System.out.println(b);
            else
            System.out.println(a);
        }
        sc.close();
    }
}
