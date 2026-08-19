import java.util.Scanner;



public class ShortSort {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        while(n--!=0)
        {
            String s=sc.next();
            if(s.charAt(0)=='a'||s.charAt(1)=='b'||s.charAt(2)=='c')
            System.out.println("Yes");
            else
            System.out.println("No");
        }
        sc.close();
    }
}
