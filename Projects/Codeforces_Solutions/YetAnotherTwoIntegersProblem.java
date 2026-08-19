import java.util.Scanner;

public class YetAnotherTwoIntegersProblem {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t--!=0)
        {
            int a=sc.nextInt();
            int b=sc.nextInt();
            int total=Math.abs(a-b);
            System.out.println(total%10==0?total/10:(total/10)+1);
        }
        sc.close();
    }
}
