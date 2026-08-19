import java.util.*;

public class ArrivaloftheGeneral {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        int min=0;
        int max=0;
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
            if(arr[i]>arr[max])
            {
                max=i;
            }
            if(arr[i]<=arr[min])
            {
                min=i;
            }
        }
        System.out.println((max+n-1-min)-((max>min)?1:0));
        sc.close();
    }
}
