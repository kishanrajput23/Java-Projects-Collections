package me.company;
import java.util.*;

public class Intersection_Of_TwoArrays {
    public static void main(String args[])
    {
      Scanner sc=new Scanner(System.in);
      HashSet<Integer>s=new HashSet<Integer>();
      System.out.println("Enter the no. of elements in array a");
      int n1=sc.nextInt();
      System.out.println("Enter the no. of elements in array b");
      int n2=sc.nextInt();
      int a[]=new int[n1];
      int b[]=new int[n2];
      System.out.println("Enter the elements of array a : ");
      for(int i=0; i<n1; i++)
      {
          a[i]=sc.nextInt();
      }
        System.out.println("Enter the elements of array b : ");
        for(int i=0; i<n2; i++)
        {
            b[i]=sc.nextInt();
        }
        for(int i=0; i<n1; i++)
            s.add(a[i]);
        int result=0;
        for(int j=0; j<n2; j++)
        {
            if(s.contains(b[j])) {
                result++;
                s.remove(b[j]);
            }
        }
        System.out.println("Required no. of common elements are : "+result);
    }
}
