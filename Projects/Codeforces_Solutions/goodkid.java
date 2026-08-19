import java.util.Scanner;

public class goodkid {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t--!=0)
        {
            int n=sc.nextInt();
            int arr[]=new int[n];
            int min=0;
            for(int i=0;i<n;i++)
            {
                arr[i]=sc.nextInt();
                if(arr[min]>arr[i])
                {
                    min=i;
                }
            }
            arr[min]++;
            int ans=1;
            for(int el:arr)
            {
                ans*=el;
            }
            System.out.println(ans);
        }
        sc.close();
    }
}
