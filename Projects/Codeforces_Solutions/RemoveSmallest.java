import java.util.*;
public class RemoveSmallest {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t--!=0)
        {
            int n=sc.nextInt();
            List<Integer>li=new ArrayList<>();
            for(int i=0;i<n;i++)
            {
                li.add(sc.nextInt());
            }
            Collections.sort(li);
            int i=0,j=i+1;
            while(li.size()!=1)
            {
                i=0;
                if(Math.abs(li.get(i)-li.get(i+1))<=1)
                {
                    if(li.get(i)<li.get(i+1))
                    {
                        li.remove(i);
                        n--;
                    }
                    else
                    {
                        li.remove(i+1);
                        n--;
                    }
                }
                else
                {
                    break;
                }
            }
            if(n==1)
            {
                System.out.println("YES");
            }
            else
            {
                System.out.println("NO");
            }
        }
        sc.close();
    }
}
