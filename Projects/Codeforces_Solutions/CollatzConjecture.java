import java.util.Scanner;

public class CollatzConjecture {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t--!=0)
        {
            int k=sc.nextInt();
            int x=sc.nextInt();
            while(k--!=0)
            {
                if(x%2==0)
                {
                    x=x*2;
                }
                else
                {
                    x=x*3+1;
                }
            }
            System.out.println(x);
        }
    }
}
