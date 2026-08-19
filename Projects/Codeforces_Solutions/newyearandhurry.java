import java.util.*;
public class newyearandhurry {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int time=sc.nextInt();
        int re=(240-time);
        int i=1;
        int ans=0;
        while(i<=n)
        {
            re=re-(i*5);
            if(re<0)
            {
                break;
            }
            ans++;
            i++;
        }
        System.out.println(ans);
        sc.close();
    }
}