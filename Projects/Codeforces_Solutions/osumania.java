import java.util.*;
public class osumania {
    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       int t=sc.nextInt();
       while(t--!=0) 
       { int a=sc.nextInt();
        int arr[]=new int[a];
        for (int i=0;i<a;i++)
        { String s=sc.nextLine();
           arr[i]=s.indexOf("#");
        }
        for(int i=arr.length-1;i>=0;i--)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        sc.close();
  }
    }
}
