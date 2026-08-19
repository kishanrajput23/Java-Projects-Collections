import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CodeforcesChecking {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        Set<Character> set=new HashSet<>();
        String s="codeforces";
        for(int i=0;i<s.length();i++)
        {
            set.add(s.charAt(i));
        }
        while (t--!=0)
        {
            char ch=sc.next().charAt(0);
            if(set.contains(ch))
                System.out.println("YES");
            else
                System.out.println("NO");
        }
        sc.close();
    }
}
