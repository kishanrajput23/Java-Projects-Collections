import java.util.*;
public class sakurakowater {
    public static void main(String[] args) throws java.lang.Exception
     {
        
    Scanner sc=new Scanner(System.in);
    int t=sc.nextInt();
    while(t!=0)
    { t--;
      int n=sc.nextInt();
       int arr[][]=new int[n][n];
       int total=0;
       for(int i=0;i<n;i++)
       {
        for (int j = 0; j < n; j++) {
           arr[i][j]=sc.nextInt();
           if(arr[i][j]<0)
            {
            total=total+arr[i][j];
           } 
        }
       }
       System.out.println((int)Math.abs(total));
    }
    sc.close();
}
}