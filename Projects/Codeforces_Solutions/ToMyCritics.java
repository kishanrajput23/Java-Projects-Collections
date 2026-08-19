import java.util.*;

public class ToMyCritics {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t--!=0)
        {
            int a[]=new int[3];
            for(int i=0;i<3;i++)
            {
                a[i]=sc.nextInt();
            }
            Arrays.sort(a);
            if(a[2]+a[1]>=10)
            System.out.println("Yes");
            else
            System.out.println("No");
        }
        sc.close();
    }
}
