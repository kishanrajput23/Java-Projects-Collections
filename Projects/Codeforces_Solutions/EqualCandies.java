import java.util.Scanner;

public class EqualCandies {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t--!=0)
        {
            int n=sc.nextInt();
            int arr[]=new int[n];
            for (int index = 0; index < arr.length; index++) 
            {
                arr[index]=sc.nextInt();
            }
            int min=arr[0];
            for(int i=1;i<n;i++)
            {
                min=Math.min(min, arr[i]);
            }
            int ans=0;
            for(int i=0;i<n;i++)
            {
                ans+=arr[i]-min;
            }
            System.out.println(ans);
        }
        sc.close();
    }
}
