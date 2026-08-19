import java.util.Scanner;

public class PoliceRecruits {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int po=0,crime=0;
        int ans=0;
        for(int i=0;i<n;i++)
        {
            int a=sc.nextInt();
            
            if(a>=0)
            po+=a;
            else if(po!=0&&a==-1)
            {
                crime++;
                po--;
            }
            else
            ans++;
        }
        System.out.println(ans);
    }
}
