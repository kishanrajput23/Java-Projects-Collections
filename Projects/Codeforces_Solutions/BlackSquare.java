import java.util.Scanner;
public class BlackSquare {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a[]=new int[4];
        for(int i=0;i<4;i++)
        a[i]=sc.nextInt();
        String s=sc.next();
        int ans=0;
        for(int i=0;i<s.length();i++)
        {
            ans+=a[s.charAt(i)-'0'-1];
        }
        System.out.println(ans);
        sc.close();
    }
}
