
import java.util.Scanner;

public class xbit {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int ans=0;
        while(n--!=0)
        {
            String s=scanner.next();
            if(s.charAt(0)=='+'||s.charAt(2)=='+')
                ans+=1;
            else
                ans-=1;
        }
        System.out.println(ans);
        scanner.close();
    }
}
