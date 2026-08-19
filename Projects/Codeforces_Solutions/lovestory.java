import java.util.Scanner;

public class lovestory {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        String s="codeforces";
        while(t--!=0)
        {
            String str=sc.next();
            int ans=0;
            for(int i=0;i<10;i++)
            {
                if(s.charAt(i)!=str.charAt(i))
                ans++;
            }
            System.out.println(ans);
        }
        sc.close();
    }
}
