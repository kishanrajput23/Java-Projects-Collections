import java.util.Scanner;

public class soildersandbanans {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int k=sc.nextInt();
        int n=sc.nextInt();
        int w=sc.nextInt();
        System.out.println(Math.max(k*(w*(w+1)/2)-n,0));
        sc.close();
    }
}
