import java.util.Scanner;
public class Brainsphotos {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int cnt=0;
        char ch[][]=new char[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                ch[i][j]=sc.next().charAt(0);
                if(ch[i][j]=='W'||ch[i][j]=='B'||ch[i][j]=='G')
                    cnt++;
            }
        }
        if(cnt==m*n)
        {
            System.out.println("#Black&White");
        }
        else
        {
            System.out.println("#Color");
        }
        sc.close();
    }
}
