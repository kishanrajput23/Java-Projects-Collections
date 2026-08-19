import java.util.Scanner;

public class UltraFastMathematician {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String a=sc.next();
        String b=sc.next();
        for(int i=0;i<a.length();i++)
        {
            if(a.charAt(i)=='0'&&b.charAt(i)=='0'||a.charAt(i)=='1'&&b.charAt(i)=='1')
            System.out.print("0");
            else
            System.out.print("1");
        }
        sc.close();
    }
}
