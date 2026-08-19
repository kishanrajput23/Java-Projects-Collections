import java.util.*;
public class thenewyearmeetingfriends{
    public static void main(String[] args)  {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int c=sc.nextInt();
        System.out.println(Math.min(Math.min(Math.abs(a-b)+Math.abs(a-c),Math.abs(b-a)+Math.abs(b-c)),Math.abs(c-a)+Math.abs(b-c)));
        sc.close();
    }
}