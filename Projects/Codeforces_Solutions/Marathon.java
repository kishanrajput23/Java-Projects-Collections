import java.util.Scanner;

public class Marathon {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t--!=0)
        {
            int n=4;
            int arr[]=new int[n];
            arr[0]=sc.nextInt();
            int ans=0;
            for(int i=1;i<n;i++)
            {
                arr[i]=sc.nextInt();
                if(arr[i]>=arr[0])
                ans++;
            }
            System.out.println(ans);
        }
        sc.close();
    }
}