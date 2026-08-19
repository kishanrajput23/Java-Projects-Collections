
import java.util.Scanner;

public class matrix{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a[][]=new int[5][5];
        int r=0,c=0;
        for(int i=0;i<5;i++)
        {
            for(int j=0;j<5;j++)
            {
                a[i][j]=sc.nextInt();
                if(a[i][j]==1)
                {
                    r=i;
                    c=j;
                }
            }
        }
        System.out.println((int)(Math.abs(2-r)+Math.abs(2-c)));
        sc.close();
    }
}