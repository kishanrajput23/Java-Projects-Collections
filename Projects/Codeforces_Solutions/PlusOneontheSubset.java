import java.util.Scanner;

public class PlusOneontheSubset {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t--!=0)
        {
            int n=sc.nextInt();
            int arr[]=new int[n];
            int min=Integer.MAX_VALUE;
            int max=Integer.MIN_VALUE;
            for(int i=0;i<n;i++)
            {
                arr[i]=sc.nextInt();
                max=Math.max(max, arr[i]);
                min=Math.min(min,arr[i]);
            }
            System.out.println(max-min);
            
        }
        sc.close();
    }
}
