import java.util.*;
public class leapyear{
  public static void main(String args[])
  {
   Scanner sc=new Scanner(System.in);
   int n=sc.nextInt();
   if(n%4==0||n%400==0)
   System.out.println("366");
   else
   System.out.println("365");
   sc.close();

  }
}

