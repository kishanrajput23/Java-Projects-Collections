import java.util.Arrays;
import java.util.Scanner;

public class CollectingCoins {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t--!=0)
        {
            int arr[]=new int[3];
            for(int i=0;i<3;i++)
            {
                arr[i]=sc.nextInt();
            }
            Arrays.sort(arr);
            int n=sc.nextInt()-(arr[2]-arr[1])-(arr[2]-arr[0]);
            if(n>=0&&n%3==0)
            {
                System.out.println("YES");
            }    
            else
            {
                System.out.println("NO");
            }
        }
        sc.close();
    }
}
