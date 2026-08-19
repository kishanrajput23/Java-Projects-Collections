
import java.util.*;

public class InSearchofanEasyProblem
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        boolean flag=false;
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
            if(arr[i]==1)
            flag=true;
        }
        if(flag)
        {
            System.out.println("HARD");
        }
        else
        {
            System.out.println("EASY");
        }
        sc.close();
    }
}