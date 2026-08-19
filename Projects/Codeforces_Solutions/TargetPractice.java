import java.io.IOException;
import java.util.Scanner;

public class TargetPractice {
    public static void main(String[] args)throws IOException {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        sc.nextLine();
        while(t--!=0)
        {
            int ans=0;
            char ch[][]=new char[10][10];
            for(int i=0;i<10;i++)
            {
                /* for(int j=0;j<10;j++)
                { */
                    ch[i]=sc.nextLine().toCharArray();
                /* } */
            }
            for(int i=0;i<10;i++)
            {
                for(int j=0;j<10;j++)
                {
                    if(ch[i][j]=='X')
                    {
                        if(i==0||j==0||i==9||j==9)
                        ans++;
                        else if(i==1||j==1||i==8||j==8)
                        ans+=2;
                        else if(i==2||j==2||i==7||j==7)
                        ans+=3;
                        else if(i==3||j==3||i==6||j==6)
                        ans+=4;
                        else if(i==4||j==4||i==5||j==5)
                        ans+=5;
                    }
                }
            }
            System.out.println(ans);
        }
        sc.close();
    }
}
