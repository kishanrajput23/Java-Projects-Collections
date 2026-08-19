import java.util.Scanner;

public class evenarray{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t--!=0)
        {
            int n=sc.nextInt();
            int arr[]=new int[n];
            for(int i=0;i<n;i++)
            {
                arr[i]=sc.nextInt();
            }
            int miscrt=0,crt=0;
            int eve=0,odd=0;
            for(int i=0;i<n;i++)
            {
                if(i%2==0&&arr[i]%2==0)
                    crt++;
                if(i%2!=0&&arr[i]%2!=0)
                    crt++;
                if(arr[i]%2!=0)
                    odd++;
                if(arr[i]%2==0)
                    eve++;
            }
            if(crt==n)
            System.out.println("0");
            else
            {
                if(eve!=(n+1)/2||eve==0||odd==0)
                System.out.println("-1");
                else
                System.out.println((n-crt)/2);
            }
            
        }
        sc.close();
    }
}