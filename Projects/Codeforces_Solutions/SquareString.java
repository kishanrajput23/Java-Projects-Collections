import java.util.Scanner;

public class SquareString {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        while(n--!=0)
        {
            String s=sc.next();
            if(s.length()%2==0)
            {
                String sub1=s.substring(0, s.length()/2);
                String sub2=s.substring((s.length()/2));
                if(sub1.equals(sub2))
                System.out.println("YES");
                else
                System.out.println("NO");
            }
            else
            System.out.println("NO");
        }
        sc.close();
    }
}
