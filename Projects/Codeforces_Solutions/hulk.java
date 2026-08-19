import java.util.Scanner;

public class hulk {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int that=n-1;
        if(n%2==1)
        {
            while(n--!=0)
            {
                if(n%2==0)
                {
                    System.out.print("I hate ");
                }
                else
                {
                    System.out.print("I love ");
                }
                if(that>0)
                {
                    System.out.print("that ");
                    that--;
                }
            }
        }
        else
        {
            while(n--!=0)
            {
                if(n%2==0)
                {
                    System.out.print("I love ");
                }
                else
                {
                    System.out.print("I hate ");
                }
                if(that>0)
                {
                    System.out.print("that ");
                    that--;
                }
            }
        }
        System.out.print("it");
        sc.close();
    }
}
