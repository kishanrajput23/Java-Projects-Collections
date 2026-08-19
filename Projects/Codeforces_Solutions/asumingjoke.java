import java.util.*;

public class asumingjoke{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String f=sc.next();
        String s=sc.next();
        String t=sc.next();
        sc.close();
    String com=f+s;
    char ch1[]=com.toCharArray();
    char ch2[]=t.toCharArray();
    Arrays.sort(ch1);
    Arrays.sort(ch2);
    if(ch1.length!=ch2.length)
    {
        System.out.println("NO");
    }
    else
    {
        
        for(int i=0;i<ch1.length;i++)
        {
            if(ch1[i]!=ch2[i])
            {
                System.out.println("NO");
                return ;
            }
        }
        System.out.println("YES");
    }
}
}