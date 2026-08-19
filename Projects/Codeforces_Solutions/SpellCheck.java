import java.util.Arrays;
import java.util.Scanner;

public class SpellCheck {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t--!=0)
        {
            int n=sc.nextInt();
            String s=sc.next();
            char ch[]=s.toCharArray();
            Arrays.sort(ch);
            s=new String(ch);
            String name="Timur";
            ch=name.toCharArray();
            Arrays.sort(ch);
            name=new String(ch);
            if(s.equals(new String(name)))
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
