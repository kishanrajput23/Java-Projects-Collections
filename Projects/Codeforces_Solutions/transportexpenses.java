import java.util.Scanner;

public class transportexpenses {
    public static void main(String[] args) {
         Scanner sc=new Scanner(System.in);
       int n=sc.nextInt();
       int amt=sc.nextInt();
       int arr[]=new int[n];
       
       for (int idx = 0; idx < arr.length; idx++) 
       {
            arr[idx]=sc.nextInt();
       }
    int count=0;
    for(int i=0;i<n;i++)
    {   int sum=0;
        for(int j=0;j<n;j++)
        {
            sum+=Math.min(arr[i],arr[j]);
        }
        if(sum<=amt)
        {
            count=Math.max(count,arr[i]);
        }
    }
    sc.close();
    }
}
