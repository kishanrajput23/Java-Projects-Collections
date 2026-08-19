import java.util.*;
public class sum{
        public static void main(String[] args) {
         Scanner sc=new Scanner(System.in);
         int t=sc.nextInt();
         while(t--!=0) 
         { int a=sc.nextInt();
           int b=sc.nextInt();
           int c=sc.nextInt();
           if(a==b+c||c==a+b||b==a+c)
           System.out.print("YES");
           else
           System.out.print("NO");
          System.out.println();
         }
         sc.close();
        }
    }
    