import java.util.Scanner;

public class VasyatheHipster{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int r=sc.nextInt();
        int b=sc.nextInt();
        System.out.println(Math.min(r,b)+" "+(Math.max(r,b)-Math.min(r,b))/2);
        sc.close();
    }
}