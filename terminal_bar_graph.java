import java.util.*;
public class terminal_bar_graph
{
    public static void main(String args[])
    {
        System.out.println("\u000C");
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter 10 numbers: ");
        int a[]=new int[10];char b=(char)(9608);char c=(char)(9612);
        int d[]=new int[10];
        int e[]=new int[10];
        for(int i=0;i<10;i++)
        {
            a[i]=sc.nextInt();
            e[i]=a[i];
            d[i]=a[i]%2;
            a[i]=a[i]/2;            
        }
        System.out.println("\u000C");
        for(int i=0;i<10;i++)
        {
            for(int j=0;j<a[i];j++)
            {
                System.out.print(b);
                if(d[i]==1&&j==a[i]-1)
                System.out.print(c);
            }
            System.out.println(e[i]);
        }
    }
}