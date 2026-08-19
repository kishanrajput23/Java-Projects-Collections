import java.util.Scanner;

public class Borze {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='.')
            {
                System.out.print(0);  
            }
            else if(s.charAt(i)=='-')
            {
                if(i+1<s.length()&&s.charAt(i+1)=='.')
                {
                    System.out.print(1);
                }
                else if(i+1<s.length()&&s.charAt(i+1)=='-')
                {
                    System.out.print(2);
                }
                i++;
            }
        }
        sc.close();
    }
}
