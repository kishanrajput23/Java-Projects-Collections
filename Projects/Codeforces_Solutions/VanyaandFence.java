
import java.util.*;

public class VanyaandFence{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int ans=0;
        while(n--!=0)
        {
            int a=sc.nextInt();
            ans+=(int)Math.ceil(a/(double)m);
        }
        System.out.println(ans);
        sc.close();
    }
}