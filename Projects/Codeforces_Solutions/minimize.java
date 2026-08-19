import java.util.*;
public class minimize {
    public static void main(String[] args) {
      Scanner sc=new Scanner(System.in);
      int t=sc.nextInt();
      while(t--!=0)
      {
      int a=sc.nextInt();
      int b=sc.nextInt();
      int c=(a+b)/2;
      int d=(c-a)+(b-c);
      System.out.println(d);
      }
      sc.close();
    }
}
