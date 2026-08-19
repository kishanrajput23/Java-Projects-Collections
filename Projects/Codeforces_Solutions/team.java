import java.util.*;

public class team{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int count=0;
        while(t--!=0)
        {
            int sum=0,i=0;
            while(i<3)
            {
                sum+=sc.nextInt();
                i++;
            }
            if(sum>=2)
            {
                count++;
            }
        }
        System.out.println(count);
        sc.close();
    }
}