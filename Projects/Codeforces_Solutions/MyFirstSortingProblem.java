import java.util.Scanner;

public class MyFirstSortingProblem
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t--!=0)
        {
            int x=sc.nextInt();
            int y=sc.nextInt();
            if(x<y)
            System.out.println(x+" "+y);
            else
            System.out.println(y+" "+x);
        }
        sc.close();
    }
}