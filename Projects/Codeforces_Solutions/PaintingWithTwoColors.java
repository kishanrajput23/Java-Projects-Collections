import java.util.Scanner;

public class PaintingWithTwoColors {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t--!=0)
        {
            int n=sc.nextInt();
            int a=sc.nextInt()-1;
            int b=sc.nextInt()-1;
            int arr[]=new int[n];
            int x=0,y=1;
            for(int i=0;i<a+x;i++)
            {
                arr[i]++;
            }
            for(int j=1;j<y+b;j++)
            {
                arr[j]=2;
            }
            String str="";
            for(int i=0;i<n;i++)
                if(arr[i]!=0)
                str+=arr[i]+"";
            if(n==a&&n==b)
            System.out.println("Yes");
            else
            System.out.println(help(str));
        }

    }
    public static String help(String str)
    {
        for(int i=0;i<str.length()/2;i++)
        {
            if(str.charAt(i)!=str.charAt(str.length()-i-1))
            return "No";
        }
        return "Yes";
   }
}
