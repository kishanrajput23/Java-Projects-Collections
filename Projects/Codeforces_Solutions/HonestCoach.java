import java.util.*;

public class HonestCoach {
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
            System.out.println(sc);
            Arrays.sort(arr);
            int ans=Integer.MAX_VALUE;
            for(int i=1;i<n;i++)
            {
                ans=Math.min(arr[i]-arr[i-1],ans);
            }
            System.out.println(ans);
        }
    }
}
