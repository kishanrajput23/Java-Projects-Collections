import java.util.HashMap;
import java.util.Scanner;

public class DoremysPaint3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t--!=0)
        {
            int n=sc.nextInt();
            HashMap<Integer,Integer>mp=new HashMap<>();
            for(int i=0;i<n;i++)
            {
                int a=sc.nextInt();
                mp.put(a,mp.getOrDefault(a,0)+1);
            }
            if(mp.size()>=3)
            {
                System.out.println("NO");
            }
            else
            {
                if(mp.size()==1)
                {
                    System.out.println("YES");
                }
                else
                {
                    int fist=0,sec=0;
                    boolean found=true;
                    for(int el:mp.keySet())
                    {
                        if(found)
                        {
                            found=false;
                            fist=mp.get(el);
                        }
                        else
                        {
                            sec=mp.get(el);
                            break;
                        }
                    }
                    if(Math.abs(fist-sec)<=1)
                    {
                        System.out.println("YES");
                    }
                    else
                    {
                        System.out.println("NO");
                    }
                }
            }
        }
    }
}
