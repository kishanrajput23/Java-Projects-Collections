import java.util.Scanner;

public class MaximumIncrease {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        int cur=1;
        int ans=1;
        int prev=arr[0];
        for(int i=1;i<n;i++)
        {
            if(prev<arr[i])
            {
                cur++;
                ans=Math.max(cur,ans);
            }
            else
            {
                cur=1;

            }
            prev=arr[i];
        }
        System.out.println(ans);
        sc.close();
    }
}
