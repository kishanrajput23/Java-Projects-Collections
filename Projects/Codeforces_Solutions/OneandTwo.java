import java.util.Scanner;

public class OneandTwo {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t--!=0)
        {
            int n=sc.nextInt();
            int arr[]=new int[n];
            boolean found=true;
            for(int i=0;i<n;i++)
            {
                arr[i]=sc.nextInt();
            }
            long pre[]=new long[n];
            pre[0]=arr[0];
            for(int i=1;i<n;i++)
            {
                pre[i]=pre[i-1]*arr[i];
            }
            for(int i=0;i<n;i++)
            {
                if(pre[i]==pre[n-1]/pre[i])
                {
                    System.out.println(i+1);
                    found=false;
                    break;
                }
            }
            if(found)
            {
                System.out.println(-1);
            }
        }
    }
}
