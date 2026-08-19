import java.util.Scanner;

public class AtillasFavoriteProblem{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t--!=0)
        {
            int n=sc.nextInt();
            String str=sc.next();
            int ans=0;
            for(char ch:str.toCharArray())
            {
                ans=Math.max(ans,ch-'a');
            }
            System.out.println(ans+1);
        }
        sc.close();
    }
}