
import java.util.Scanner;

public class nextround {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int f=sc.nextInt();
        int arr[]=new int[n];
        int count=0;
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++)
        {
            if(arr[i]>=arr[f-1]&&arr[i]>0)
            count++;
        }
        System.out.println(count);
        sc.close();
    }
}
