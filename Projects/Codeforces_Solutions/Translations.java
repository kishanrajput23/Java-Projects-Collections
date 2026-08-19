import java.util.Scanner;

public class Translations {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String f=sc.next();
        String s=sc.next();
        String n="";
        for(int i=f.length()-1;i>=0;i--)
            n+=f.charAt(i);
        if(s.compareTo(n)==0)
        System.out.println("YES");
        else
        System.out.println("NO");
        sc.close();
    }
}
