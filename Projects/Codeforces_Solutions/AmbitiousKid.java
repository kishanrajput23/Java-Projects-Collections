import java.util.*;
public class AmbitiousKid{
    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       int a=sc.nextInt();
        int arr[]=new int[a];
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<a;i++)
        {
            arr[i]=sc.nextInt();
            ans=Math.min(Math.abs(arr[i]),ans);
        }
        System.out.println(ans);
    }
}