
import java.util.*;

public class word {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int ns=0,nb=0;
        for(int i=0;i<s.length();i++)
        {
            if(Character.isUpperCase(s.charAt(i)))
            nb++;
            else
            ns++;
        }
        if(ns>=nb)
        {
            System.out.print(s.toLowerCase());
        }
        else
        {
            System.out.print(s.toUpperCase());
        }
        sc.close();
    }
}
