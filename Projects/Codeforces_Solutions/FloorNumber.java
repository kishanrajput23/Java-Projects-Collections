import java.util.Scanner;

public class FloorNumber {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t--!=0)
		{
		    int n=sc.nextInt();
            int x=sc.nextInt();
            if(n<=2)
                System.out.println(1);
            else
            {
                System.out.println(1+(int)Math.ceil((n-2)/(double)x));
            }
		}
        sc.close();
    }
}
