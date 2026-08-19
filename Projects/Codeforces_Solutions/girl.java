
import java.util.*;

public class girl {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Set<Character>s=new HashSet<>();
        String str=sc.next();
        for(int i=0;i<str.length();i++)
        {
            s.add(str.charAt(i));
        }
        if(s.size()%2==0)
        {
            System.out.println("CHAT WITH HER!");
        }
        else
        {
            System.out.println("IGNORE HIM!");
        }
        sc.close();
    }
}
