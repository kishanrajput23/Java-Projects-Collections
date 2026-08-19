import java.util.Scanner;

public class MishkandGame {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int a=0,b=0;
        int ma=0,mb=0;
        while (t--!=0)
        {
           a=sc.nextInt();
           b=sc.nextInt();
           if(a<b)
           mb++;
           else if(a>b)
           ma++;
        }
        if(ma==mb)
        System.out.println("Friendship is magic!^^");
        else if(ma>mb)
        System.out.println("Mishka");
        else
        System.out.println("Chris");
        sc.close();
    }
}
