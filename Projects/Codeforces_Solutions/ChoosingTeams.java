import java.util.Arrays;
import java.util.Scanner;

public class ChoosingTeams {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int ans=0,j=0;
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[j]=sc.nextInt();
        }
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i+=3)
        {
            if(i+2<arr.length&&arr[i+2]+k<=5)
            ans++;  
        }
        System.out.println(ans);
    }
}
