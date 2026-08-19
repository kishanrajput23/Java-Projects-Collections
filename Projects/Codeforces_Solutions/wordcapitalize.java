
import java.util.*;

public class wordcapitalize {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        /* for(int i=0;i<s.length();i++)
        {
            if(i==0)
                {
                    System.out.print(Character.toUpperCase(s.charAt(i)));
                }
                else
                {
                    System.out.print(s.charAt(i));
                }
        } */
        char ch=Character.toUpperCase(s.charAt(0));
        String n=ch+s.substring(1);
        System.out.println(n);
        sc.close();
    }
}
