import java.util.Scanner;

public class DislikeofThrees {
    static int ans[]=new int[1010];
    static{
        int num=1;
        for(int i=0;i<ans.length;i++)
        {
            while(num%3==0||num%10==3)
            {
                num++;
            }
            ans[i]=num;
            num++;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t--!=0)
        {
            int a=sc.nextInt();
            System.out.println(ans[a-1]);
        }
    }
}
