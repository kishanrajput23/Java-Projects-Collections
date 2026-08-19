import java.util.Scanner;

public class BeautifulAverage {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t--!=0)
        {
            int n=sc.nextInt();
            int arr[]=new int[n];
            for(int i=0;i<n;i++)
            {
                arr[i]=sc.nextInt();
            }
            int ans=Integer.MIN_VALUE;
            for(int i=0;i<n;i++)
            {
                ans=Math.max(ans, arr[i]);
            }
            System.out.println(ans);
        }
    }
}
