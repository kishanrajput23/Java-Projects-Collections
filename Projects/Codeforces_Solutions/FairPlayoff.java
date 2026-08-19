import java.util.*;

public class FairPlayoff {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t--!=0)
        {
            int a=sc.nextInt(),b=sc.nextInt(),c=sc.nextInt(),d=sc.nextInt();
            int arr[]=new int[4];
            arr[0]=a;
            arr[1]=b;
            arr[2]=c;
            arr[3]=d;
            Arrays.sort(arr);
            if(a==arr[3]&&b==arr[2]||a==arr[2]&&b==arr[3]||c==arr[3]&&d==arr[2]||c==arr[2]&&d==arr[3])
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
