import java.util.Scanner;
public class DesignTutorialLearnfromMath {
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a=n/2;
        int b=n-a;
        while(a!=0)
        {
            if(isprime(a)||isprime(b))
            {
                a--;
                b++;
            }
            else
            {
                break;
            }  
        }
        System.out.println(a+" "+b);
        sc.close();
    }
     static boolean  isprime(int a)
    {
        for(int i=2;i<a;i++)
        {
            if(a%i==0)
            return false;
        }
        return true;
    }
}
