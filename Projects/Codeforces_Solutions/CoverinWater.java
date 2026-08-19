import java.util.*;
public class CoverinWater {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t--!=0)
        {
            int n=sc.nextInt();
            String str=sc.next();
            int ans=0;
            int cnt=0;
            int tot=0;
            for(char ch:str.toCharArray())
            {
                if(ch=='.')
                {
                    cnt++;
                    tot++;
                    ans=Math.max(ans,cnt);
                }
                else
                {
                    cnt=0;
                }
            }
            ans=Math.max(cnt,ans);
            if(ans>2)
                System.out.println("2");
            else            
                System.out.println(tot);
        }
        sc.close();
    }
}
