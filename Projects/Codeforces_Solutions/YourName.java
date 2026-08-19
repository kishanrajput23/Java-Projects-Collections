import java.util.*;
public class YourName {
        public static void main (String[] args) throws java.lang.Exception
        { 
            Scanner sc=new Scanner(System.in);
            int t=sc.nextInt();
            while(t--!=0)
            {
                int n=sc.nextInt();
                char ch[]=new char[n];
                ch=sc.next().toCharArray();
                Arrays.sort(ch);
                String a=new String(ch);
                ch=sc.next().toCharArray();
                Arrays.sort(ch);
                String b=new String(ch);
                if(a.equals(b))
                System.out.println("YES");
                else
                System.out.println("NO");
            }
            sc.close();
        }
}
