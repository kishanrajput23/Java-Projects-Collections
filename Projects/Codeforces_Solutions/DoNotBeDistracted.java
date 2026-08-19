import java.util.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DoNotBeDistracted {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t--!=0)
        {
            int n=sc.nextInt();
            char ch[]=sc.next().toCharArray();
            List<Character>s=new ArrayList<>();
            int j=0;
            for(int i=0;i<n;i++)
            {
                s.add(ch[i]);
                j=i;
                if(ch[i]==ch[j])
                {
                    while(i<n&&j<n&&ch[i]==ch[j])
                    {
                        j++;
                    }
                    i=j-1;
                }
                
            }
            boolean found=false;
            for(int i=0;i<s.size();i++)
            {
                if(s.contains(s.get(i))&&s.indexOf(s.get(i))!=i&&s.indexOf(s.get(i))!=-1)
                {
                    found=true;
                    break;
                }
            
            }
            if(found)
            System.out.println("NO");
            else
            System.out.println("YES");

            
        }
        sc.close();
    }
}
