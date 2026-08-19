import java.util.*;

public class KosukeSakurako
{
    public static void main (String[] args) throws java.lang.Exception
    { Scanner sc=new Scanner(System.in);
      int t=sc.nextInt();
      while(t--!=0)
      {
          int a=sc.nextInt();
          if(a%2==0)
          {
            System.out.println("Sakurako");
          }
          else
          {
            System.out.println("Kosuke");
          }
         
      }
    
      sc.close();
    }
}
