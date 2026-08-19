import java.util.Scanner;

public class EasyProblem {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t--!=0)
        {
            int n=sc.nextInt();
            System.out.println(n-1);
        }
        sc.close();
    }
}
