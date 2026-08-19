import java.util.*;
public class IWannaBetheGuy {
    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       int n=sc.nextInt();
       boolean flag=false;
       boolean ans[]=new boolean[n];
       Arrays.fill(ans,true);
       int p=sc.nextInt();
       for(int i=0;i<p;i++)
       ans[sc.nextInt()-1]=false;
       int q=sc.nextInt();
       for(int i=0;i<q;i++)
       ans[sc.nextInt()-1]=false;
       for(int i=0;i<n;i++)
       {
        if(ans[i])
        {
            flag=true;
            break;
        }
       }
       if(flag)
       {
        System.out.println("Oh, my keyboard!");
       }
       else
       {
        System.out.println( "I become the guy.");
       }
       sc.close(); 
    }
}