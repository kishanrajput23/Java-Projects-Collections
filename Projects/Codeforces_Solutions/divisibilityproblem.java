import java.util.Scanner;

public class divisibilityproblem {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t--!=0)
        {
          int a=sc.nextInt();
          int b=sc.nextInt();
          if(a%b!=0)
          {
          System.out.println((a/b+1)*b-a);
          }
          else
          {
            System.out.println(0);
          }
        }
        sc.close();   
     }

}
