import java.util.*;
class gcd
{
    public static void main(String[] args)
    {
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter the two numbers");
      int a = sc.nextInt();   
      int b = sc.nextInt();
      int gcd = gcd(a,b);
      System.out.println("GCD is "+gcd);
      sc.close();   
    }
    public static int gcd(int a, int b)
    {
        if(a==b)
        return a;
        else if(a>b)
        return gcd(a-b,b);
        else
        return gcd(a,b-a);
    }
}