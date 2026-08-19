import java.util.*;
public class VanyaandCubes {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int ans=0;
        int cnt=0;
        for(int i=1;i<=n;i++)
        {
            ans+=(i*(i+1))/2;
            if(ans>n)
            {
               break;
            }
            cnt++;
        }
        System.out.println(cnt);
        sc.close();
    }
}
