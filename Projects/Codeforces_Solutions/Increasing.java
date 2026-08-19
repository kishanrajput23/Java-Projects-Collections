import java.util.*;
import java.lang.*;
import java.io.*;

public class Increasing
{
    public static void main (String[] args) throws java.lang.Exception
    { Scanner sc=new Scanner(System.in);
      int t=sc.nextInt();
      while(t--!=0)
      {
          int a=sc.nextInt();
          int arr[]=new int[a];
          for(int i=0;i<a;i++)
          {
            arr[i]=sc.nextInt();
          }
          Arrays.sort(arr);
          boolean found=true;
          for(int i=0;i<a-1;i++)
          {
            if(arr[i]>=arr[i+1])
            {
                found=false;
            }
          }
          if(found)
          System.out.println("Yes");
          else
          System.out.println("No");
      }
      sc.close();
    

    }
}
