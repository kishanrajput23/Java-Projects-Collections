import java.util.*;

public class RecyclingCenter {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t--!=0)
        {
            int n=sc.nextInt();
            int k=sc.nextInt();
            int arr[]=new int[n];
            for(int i=0;i<n;i++)
            {
                arr[i]=sc.nextInt();
            }
            Arrays.sort(arr);
            int po=0,ans=0;
            for(int i=n-1;i>=0;i--)
            {
                if((1L<<(n-i))*arr[i]>k)
                {
                    ans++;
                }

            }
            System.out.println(ans);
        }
    }
}
