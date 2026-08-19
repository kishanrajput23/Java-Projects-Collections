import java.util.Scanner;

public class Desorting {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t--!=0)
        {
            int arr[]=new int[sc.nextInt()];
            for(int i=0;i<arr.length;i++)
            {
                arr[i]=sc.nextInt();
            }
            if(help(arr))
            {
                System.out.println("0");
            }
            else
            {
                int ans=Integer.MAX_VALUE;
                for(int i=0;i<arr.length-1;i++)
                {
                    ans=Math.min(ans,Math.abs(arr[i]-arr[i+1]));
                }
                System.out.println((ans/2)+1);
            }

        }
        sc.close();
    }
    static boolean help(int arr[])
    {
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i-1]>arr[i])
                return true;
        }
        return false;
    }
}
