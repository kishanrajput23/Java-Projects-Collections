import java.util.*;
public class TrippiTroppi {
    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       int n=sc.nextInt();
       while(n--!=0)
       {
        String a=sc.next();
        String b=sc.next();
        String c=sc.next();
        String ans=a.charAt(0)+"";
        ans+=b.charAt(0)+"";
        ans+=c.charAt(0)+"";
        System.out.println(ans);
       }
       sc.close();
    }
}
