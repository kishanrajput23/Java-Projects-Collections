import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class unstop {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int ans=0;
        
        int arr[]=new int[n];
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++)
        {
            if(arr[i]>5000&&q.size()!=0)
                q.poll();
            else
                q.add(arr[i]);
            ans=Math.max(q.size(),ans);
        }
        System.out.println(ans);   
        sc.close();
    }  
}