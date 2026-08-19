import java.util.Scanner;

public class BoringApartments {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t--!=0)
        {
            int n=sc.nextInt();
            String s=n+"";
            int ans=0;
            int latn=n%10;
            ans+=(latn-1)*10;
            ans+=s.length()*(s.length()+1)/2;
            System.out.println(ans);
        }
        sc.close();
    }
}
