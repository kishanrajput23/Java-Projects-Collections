import java.util.Scanner;

public class CandiesforNephews{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t--!=0)
        {
            int n=sc.nextInt();
            if(n%3==0)
            {
                System.out.println("0");
            }
            else
            {
                int cur=(n/3)+1;
                System.out.println(cur*3-n);
            }
        }
    }
}