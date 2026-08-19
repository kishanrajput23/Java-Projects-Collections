import java.util.Scanner;
public class Colourblindness
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t--!=0)
        {
            int n=sc.nextInt();
            String a=sc.next();
            String b=sc.next();
            boolean found=false;
            for(int i=0;i<n;i++)
            {
                if(a.charAt(i)!=b.charAt(i)&&!((a.charAt(i)=='B'&&b.charAt(i)=='G')||(b.charAt(i)=='B'&&a.charAt(i)=='G')))
                {
                        found=true;
                        break;
                }
                /* else
                {
                    if((a.charAt(i)=='B'&&b.charAt(i)=='G')||(b.charAt(i)=='B'&&a.charAt(i)=='G'))
                    {
                        continue;
                    }
                    else
                    {
                        found=true;
                        break;
                    }
                } */
            }
            if(found)
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