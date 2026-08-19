import java.util.*;
class fibonacci
{
    public static void main(String[] args)
    {
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter the number");
      int x = sc.nextInt();
      int fib_sum = fib(x);
      System.out.println(fib_sum);
      sc.close();  
    }
    public static int fib(int a)
    {
        if(a<=1)
        return a;
        else
        return fib(a-1) + fib(a-2);
    }
}