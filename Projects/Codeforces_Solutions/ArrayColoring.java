import java.util.Scanner;

public class ArrayColoring {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t--!=0)
        {
            int n=sc.nextInt();
            int arr[]=new int[n];
            int sum=0;
            for(int i=0;i<n;i++)
            {
                arr[i]=sc.nextInt();
                sum+=arr[i];
            }
            boolean found=false;
            for(int i=0;i<n;i++)
            {
                if((sum-arr[i])%2==0&&arr[i]%2==0||(sum-arr[i])%2!=0&&arr[i]%2!=0)
                {
                    found=true;
                    break;
                }
            }
            if(found)
            System.out.println("YES");
            else
            System.out.println("NO");

        }
        sc.close();
    }
}
