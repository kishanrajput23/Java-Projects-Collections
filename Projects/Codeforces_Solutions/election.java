import java.util.*;
public class election{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int T=sc.nextInt();
        int A=sc.nextInt();
        int max=Math.max(T,A);
        int min=Math.min(T,A);
        if(max>min+(N-T-A))
        {
            System.out.println("YES");
        }
        else
        {
        System.out.println("NO");
        }
        sc.close();
    }

}