import java.util.Scanner;

public class secondbeat{
   public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       int n=sc.nextInt();
       int arr[]=new int[n];
       int ans=0;
       int first=0;
       int second=0;
       for (int idx = 0; idx < arr.length; idx++) 
       {
            arr[idx]=sc.nextInt();
            first=Math.max(arr[idx],first);
       }
       for(int i=0;i<arr.length;i++)
       {
        if(arr[i]!=first)
        {
            second=Math.max(second,arr[i]);
        }
       }
       for(int i=0;i<n;i++)
       {
        if(arr[i]==second)
        {
            ans=i+1;
        }
       }
       System.out.println(ans);
       sc.close();
    }
} 
