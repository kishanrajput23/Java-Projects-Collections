import java.util.Scanner;

public class homework {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t--!=0)
        {
            int a=sc.nextInt();
            StringBuilder ini=new StringBuilder(sc.next());
            int n=sc.nextInt();
            String s=sc.next();
            String op=sc.next();
            for(int i=0;i<n;i++)
            {
                if(op.charAt(i)=='D')
                {
                    ini.append(s.charAt(i));
                }
                else
                {
                    ini=new StringBuilder(s.charAt(i)+ini.toString());
                }
            }
            System.out.println(ini.toString());
        }
        sc.close();
    }
}
