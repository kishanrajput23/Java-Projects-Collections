import java.util.Scanner;

public class BlankSpace {
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
            int count=0,ans=0;
            for(int i=0;i<n;i++)
            {
                if(arr[i]==0)
                count++;
                else
                {
                    ans=Math.max(ans, count);
                    count=0;
                }
            }
            System.out.println(Math.max(count,ans));
        }
        sc.close();
    }
}
