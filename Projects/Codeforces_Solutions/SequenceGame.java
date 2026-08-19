import java.util.*;

public class SequenceGame {
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
            List<Integer>ans=new ArrayList<>();
            ans.add(arr[0]);
            for(int i=1;i<n;i++)
            {
                if(arr[i]>=arr[i-1])
                    ans.add(arr[i]);
                else
                {
                    ans.add(arr[i]);
                    ans.add(arr[i]);
                }
            }
            System.out.println(ans.size());
            for(int i:ans)
            {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}
