import java.util.Scanner;

public class MonocarpsString {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t--!=0)
        {
            int n=sc.nextInt();
            String s=sc.next();
            boolean found=true;
            char last=s.char()
            for(int i=-1;i<n;i++)
            {
                if(help(s.substring(i+1)))
                {
                    found=false;
                    System.out.println(i+1);
                    break;
                }
                else
                {
                    
                }
                
            }
        }
    }
    public static boolean help(String s)
    {
        int n=s.length();
        int freq[]=new int[2];
        for(int i=0;i<n;i++)
        {
            freq[s.charAt(i)-'a']++;
        }
        if(freq[0]==freq[1])
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
