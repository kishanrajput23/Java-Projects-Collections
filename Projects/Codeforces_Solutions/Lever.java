import java.util.Scanner;

public class Lever{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t--!=0)
        {
            int n=sc.nextInt();
            int arr[]=new int[n];
            int brr[]=new int[n];
            for(int i=0;i<n;i++)
                arr[i]=sc.nextInt();
            for(int i=0;i<n;i++)
                brr[i]=sc.nextInt();
            int ans=0;
            for(int i=0;i<n;i++)
            {
                ans+=Math.max(0,arr[i]-brr[i]);
            } 
            System.out.println(ans+1);
        }
        sc.close();
    }
}