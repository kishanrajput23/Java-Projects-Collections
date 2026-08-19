import java.util.Scanner;

public class AlternatingSeries {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t--!=0)
        {
            int n=sc.nextInt();
            for(int i=0;i<n;i++)
            {
                if(i%2==0)
                {
                   System.out.print((i+1)*-1+" ");
                }
                else
                {
                    System.out.print((i+1)*+" ");
                }
            }
            System.out.println();
        }
        sc.close();
    }
}
