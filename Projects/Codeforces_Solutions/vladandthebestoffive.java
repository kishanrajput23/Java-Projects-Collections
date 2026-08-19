import java.util.Scanner;

public class vladandthebestoffive {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t--!=0)
        {
            String s=sc.next();
            int a=0;
            int b=0;
            for(char ch:s.toCharArray())
            {
                if(ch=='A')
                    a++;
                else
                    b++;
            }
            if(a<b)
            {
                System.out.println("B");
            }
            else
            {
                System.out.println("A");
            }
            
        }
        sc.close();
    }
}
