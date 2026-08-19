import java.util.Scanner;

public class FairDivision {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t--!=0)
        {
            int n=sc.nextInt();
            int arr[]=new int[n];
            int tcnt=0,ocnt=0;
            for(int i=0;i<n;i++)
            {
                arr[i]=sc.nextInt();
                if(arr[i]==1)
                    ocnt++;
                else
                    tcnt++;
            }
            if((ocnt+2*tcnt)%2!=0)
            {
                System.out.println("NO");
            }
            else if(ocnt==0&&tcnt%2!=0)
            {
                System.out.println("NO");
            }
            else
            {
                System.out.println("YES");
            }
        }
        sc.close();
    }
}
