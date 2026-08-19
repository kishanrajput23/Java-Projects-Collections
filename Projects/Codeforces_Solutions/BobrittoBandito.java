import java.util.*;
public class BobrittoBandito {
    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       int n=sc.nextInt();
       while(n--!=0)
       {
        int a=sc.nextInt();
        int b=sc.nextInt();
        int c=sc.nextInt();
        int d=sc.nextInt();
        int l=-c;
        a=d;
        d=a;
        int x=Math.min(l,b);
        int y=b-x;
        int ans=-x;
        int nas=y;
        System.out.println(ans+" "+nas);
       }
       sc.close();
    }
}
