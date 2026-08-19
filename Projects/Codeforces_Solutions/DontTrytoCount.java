import java.util.Scanner;

public class DontTrytoCount {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t--!=0)
        {
            int n=sc.nextInt();
            int slen=sc.nextInt();
            String str=sc.next();
            String fix=sc.next();
            int ans=0;
            if(n>slen&&!str.contains(fix))
            {
                str+=str;
                if(str.contains(fix))
                {
                    System.out.println("1");
                }
                else
                {
                    System.out.println("-1");
                }
            }
            else
            {
                while(!str.contains(fix)&&str.length()<=2*fix.length())
                {
                    str+=str;
                    ans++;
                }
                if(str.contains(fix))
                {
                    System.out.println(ans);
                }
                else
                {
                    System.out.println("-1");
                }
            }
        }
        sc.close();
    }
}
