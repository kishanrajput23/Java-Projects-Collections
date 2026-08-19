import java.util.*;
public class games {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        int brr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
            brr[i]=sc.nextInt();
        } 
        int ans=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(arr[i]==brr[j])
                {
                    ans++;
                }
            }
        }
        System.out.println(ans);
        sc.close();
    }
}