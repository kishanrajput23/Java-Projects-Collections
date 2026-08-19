import java.util.Scanner;

public class balancedarray {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();        
        while(t--!=0)
        {
            int n=sc.nextInt();
            int esum=0;
            int osum=0;
            if(n%4!=0)
            {
                System.out.println("No");
            }
            else
            {   System.out.println("Yes");
                for(int i=1;i<=n/2;i++)
                {
                    esum+=i*2;
                    System.out.print(i*2+" ");
                }
                for(int i=1;i<n/2;i++)
                {
                    osum+=(i*2)-1;
                    System.out.print((i*2)-1+" ");
                }
                System.out.println(esum-osum);

            }

        }
        sc.close();
    }
}
