import java.util.Scanner;

public class ShortSubstrings {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t--!=0)
        {
           char s[]=sc.next().toCharArray();
           String ans="";
           ans+=s[0]+""+s[1]+"";
           for(int i=2;i<s.length;i+=2)
           {
              if(i+1<s.length&&ans.charAt(ans.length()-1)==s[i])
              {
                ans+=s[i+1];
              }
           }
           System.out.println(ans);
        }
        sc.close();
    }
}
