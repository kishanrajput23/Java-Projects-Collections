import java.util.Scanner;
public class BachgoldProblem
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        if(n%2==0)
        {
            int ans=n/2;
            System.out.println(ans);
            while(ans-->0) 
            {
                System.out.print(2+" ");
            }
        }
        else
        {
            int ans=(n/2);
            System.out.println(ans);
            while(ans-->1)
            {
                System.out.print("2 ");
            }
            System.out.print("3");
        }
        sc.close();
    }
}