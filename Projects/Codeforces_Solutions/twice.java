import java.util.Arrays;
import java.util.Scanner;

public class twice {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t--!=0)
        {
            int a=sc.nextInt();
            int count=0;
            int fre[]=new int[a+1];
            Arrays.fill(fre,0);
            for(int i=0;i<a;i++)
            {
                int val=sc.nextInt();
                if(fre[val]==0)
                {
                    fre[val]=1;
                }
                else
                {
                    fre[val]=fre[val]+1;
                }
            }
            for(int i=0;i<fre.length;i++)
            {
                if(fre[i]>=2)
                {
                    count++;
                }
            }
            System.out.println(count);
        }   
        sc.close(); 
    } 
}
