import java.util.Scanner;
public class JaggedSwaps{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t--!=0)
        {
            int n=sc.nextInt();
            int arr[]=new int[n];
            for(int i=0;i<n;i++)
            {
                arr[i]=sc.nextInt();
            }
            if(help(arr))
            {
                System.out.println("YES");
            }
            else
            {
                
                if(arr[0]==1)
                {
                    System.out.println("YES");
                }
                else
                {
                    System.out.println("NO");
                }
            }
        }
        sc.close();
    }
    static boolean help(int arr[])
    {
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i-1]>arr[i])
                return false;
        }
        return true;
    }
}