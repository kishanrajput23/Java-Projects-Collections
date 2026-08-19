import java.util.*;
public class ORDSUM23 
{
    static long dp[]=new long[10000010];
    static long mod=1000000007;
    static
    {
        Arrays.fill(dp,-1);
        dp[0]=0;
        dp[1]=0;
        dp[2]=1;
        dp[3]=1;
    }
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t--!=0)
        {
            int n=sc.nextInt();
            System.out.println(help(n,dp));            
        }
    }
    static int help(int n,long dp[])
    {
        if(dp[n]!=-1)
        {
            return (int)(dp[n]%mod);
        }
        return (int)(dp[n]=((help(n-2,dp)%mod)+(help(n-3,dp)%mod))%mod);
    }
}
