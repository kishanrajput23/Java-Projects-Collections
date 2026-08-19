import java.util.*;
public class HowMuchDoesDaytonaCost {
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t--!=0)
        {
            int n=sc.nextInt();
            int k=sc.nextInt();
            Map<Integer,Integer>mp=new HashMap<>();
            for(int i=0;i<n;i++)
            {
                int a=sc.nextInt();
                mp.put(a,mp.getOrDefault(a, 0)+1);
            }
            if(mp.containsKey(k))
            System.out.println("YES");
            else
            System.out.println("NO");
        }
        sc.close();
    }
}
