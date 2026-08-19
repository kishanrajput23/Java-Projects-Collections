import java.util.Scanner;

public class GamewithIinteger {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t--!=0)
        {
            int n=sc.nextInt();
            /* int f=n;
            int s=n; */
            /* boolean found=false; */
            /* for(int i=0;i<10&&s>0&&f>0;i++)
            {
                if(f%3==0||s%3==0)
                {
                    found=true;
                    break;
                }
                f++;
                n--;
            } */
            if(n%3!=0)
            {
                System.out.println("First");
            }
            else
            {
                System.out.println("Second");
            }
        }
        sc.close();
    }
}
