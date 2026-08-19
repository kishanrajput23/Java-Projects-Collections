import java.util.Scanner;

public class CanISquare {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t--!=0)
        {
            int n=sc.nextInt();
            long sum=0;
            for(int i=0;i<n;i++)
            {
                sum+=sc.nextLong();
            }
            if(binarysearch(1,sum+1000,sum))
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
    static boolean binarysearch(long s,long e,long tar)
    {
        while(s<=e)
        {      
            long mid=s+(e-s)/2;
            if(mid*mid==tar)
            {
                return true;
            }
            else if(mid*mid>tar)
            {
                e=mid-1;
            }
            else
            {
                s=mid+1;
            }
        }
        return false;
    }
}
