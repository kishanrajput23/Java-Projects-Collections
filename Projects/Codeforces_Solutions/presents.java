
import java.util.Scanner;

public class presents {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int ans[]=new int[n];
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
            ans[arr[i]-1]=i+1;
        }
        for(int el: ans)
        {
            System.out.print(el+" ");
        }
        sc.close();
    }
}
