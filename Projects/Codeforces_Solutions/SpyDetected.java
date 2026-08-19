import java.util.Scanner;

public class SpyDetected {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t--!=0)
        {
            int n=sc.nextInt();
            int arr[]=new int[n];
            for(int i=0;i<n;i++)
            {
                arr[i]=sc.nextInt();
            }
            int first=0,second = 0;
            for(int i=1;i<n;i++)
            {
                if(arr[first]!=arr[i])
                {
                    second=i;
                    break;
                }
            }
            int countf=0,counts=0;
            for(int i=0;i<n;i++)
            {
                if(arr[i]==arr[first])
                    countf++;
                else    
                    counts++;
            }
            if(countf==1)
            System.out.println(first+1);
            else
            System.out.println(second+1);
        }

        sc.close();
    }
}
