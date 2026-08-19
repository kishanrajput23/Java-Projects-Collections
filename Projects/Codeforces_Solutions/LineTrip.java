import java.util.*;
public class LineTrip {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); 

        while (t-- > 0) 
        {
            int n = sc.nextInt(); 
            int x = sc.nextInt(); 
            int arr[]=new int[n];
            int ans=0;
            int prev=0;
            for(int i=0;i<n;i++)
            {
                arr[i]=sc.nextInt();
                ans=Math.max(ans,arr[i]-prev);
                prev=arr[i];
            }
            ans=Math.max(ans,(x-arr[n-1])*2);
            System.out.println(ans);
        }

        sc.close();
    }
}
