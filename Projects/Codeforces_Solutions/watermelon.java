import java.util.Scanner;

public class watermelon {
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        if((a)%2==0)
        {
            System.out.println("YES");
        }
        else 
        {
            System.out.println("NO");
        }
        sc.close();
    }
}
