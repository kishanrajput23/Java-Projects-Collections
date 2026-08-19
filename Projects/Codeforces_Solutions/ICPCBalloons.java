import java.util.*;
public class ICPCBalloons
 {
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t--!=0)
        {
            Set<Character>set=new HashSet<>();
            int n=sc.nextInt();
            String s=sc.next();
            int ans=0;
            for(int i=0;i<n;i++)
            {
                if(!set.contains(s.charAt(i)))
                {
                    set.add(s.charAt(i));
                    ans+=2;
                }
                else
                {
                    ans++;
                }
            }
            System.out.println(ans);
        }
        sc.close();
    }
 }