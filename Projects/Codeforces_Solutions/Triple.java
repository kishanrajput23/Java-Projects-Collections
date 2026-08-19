import java.util.*;

public class Triple {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int tc=sc.nextInt();
        while(tc--!=0)
        {
            int n=sc.nextInt();
            Map<Integer,Integer>mp=new HashMap<>();
            for(int i=0;i<n;i++)
            {
                int a=sc.nextInt();
                mp.put(a,mp.getOrDefault(a,0)+1);
            }
            boolean found=true;
            for(int el:mp.keySet())
            {
                if(mp.get(el)>=3)
                {
                    System.out.println(el);
                    found=false;
                    break;
                }
            }
            if(found)
            {
                System.out.println("-1");
            }
        }
    }
}
