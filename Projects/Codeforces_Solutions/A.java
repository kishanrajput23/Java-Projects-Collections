import java.util.Scanner;
public class A{
    
    public static void main(String args[])
    {
      Scanner sc=new Scanner(System.in);
      int t=sc.nextInt();
      while(t--!=0)
      {
          int a1=sc.nextInt();
          int a2=sc.nextInt();
          int a4=sc.nextInt();
          int a5=sc.nextInt();
          // int max=0;
          int maxFib = 0; 
          for (int a3 = -100; a3 <= 100; a3++)
          { 
            int fibCount = 0; 
            if (a3 == a1 + a2) 
            { 
              fibCount += 1;
            } 
            if (a4 == a2 + a3) 
            { 
              fibCount += 1; 
            } 
            if (a5 == a3 + a4) 
            { fibCount += 1; 
            } 
            maxFib = Math.max(maxFib, fibCount);
          }
          System.err.println(maxFib);
          
      }
      sc.close();
    }
}