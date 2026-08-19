import java.util.Scanner;

public class WordonthePaper {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t--!=0)
        {
            for(int i=0;i<8;i++)
            {
                String s=sc.next();
                for(char ch:s.toCharArray())
                {
                    if(ch!='.')
                    {
                        System.out.print(ch);
                    }
                }
            }
            System.out.println("");
        }
        sc.close();
    } 
}
