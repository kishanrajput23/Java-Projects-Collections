import java.util.Scanner;

public class HolidayOfEquality {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        int max=0;
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
            if(max<arr[i])
                max=arr[i];
        }
        int ans=0;
        for(int el:arr)
        {
            ans+=max-el;
        }
        System.out.println(ans);
    }
}
