import java.util.Arrays;
import java.util.Scanner;

public class Insomniacure {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int k=sc.nextInt();
        int l=sc.nextInt();
        int m=sc.nextInt();
        int n=sc.nextInt();
        int d=sc.nextInt();
        boolean arr[]=new boolean[d+1];
        Arrays.fill(arr, false);
        for(int i=k;i<=d;i+=k)
        arr[i]=true;
        for(int i=l;i<=d;i+=l)
        arr[i]=true;
        for(int i=m;i<=d;i+=m)  
        arr[i]=true;
        for(int i=n;i<=d;i+=n)
        arr[i]=true;
        int ans=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i])
            ans++;
        }
        System.out.println(ans);
        sc.close();
    }
}