import java.util.Scanner;

public class Lasers{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t--!=0)
        {
            int n=sc.nextInt();
            int m=sc.nextInt();
            int x=sc.nextInt();
            int y=sc.nextInt();
            int arr[]=new int[n];
            int brr[]=new int[m];
            for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
            for(int i=0;i<m;i++)
            brr[i]=sc.nextInt();
            System.out.println(Math.min(n,y-1)+Math.min(m,x-1));
        }
        sc.close();
    }
}