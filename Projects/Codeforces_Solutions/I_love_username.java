import java.util.Scanner;
public class I_love_username{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        int ans=0;
        int max=arr[0],min=arr[0];
        for(int i=1;i<n;i++)
        {
            if(max<arr[i])
                {
                    ans++;
                    max=arr[i];
                }
            if(min>arr[i])
                {
                    ans++;
                    min=arr[i];
                }
        }
        System.out.println(ans);
        sc.close();
    }
}
