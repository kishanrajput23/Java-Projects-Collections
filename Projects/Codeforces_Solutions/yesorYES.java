import java.util.*;
public class yesorYES {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        while(n--!=0)
        {
            String s=sc.next().toLowerCase();
            if(s.equals("yes"))
            System.out.println("YES");
            else
            System.out.println("NO");
        }
        sc.close();
    }
}
