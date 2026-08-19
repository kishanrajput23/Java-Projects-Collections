import java.util.*;

public class antonandletters {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s = sc.nextLine();
        Set<Character> set=new HashSet<>();
        if(s.length()==2)
        {
            System.out.println(0);
        }
        else{
            for(int i=1;i<s.length();i+=3)
            {
                set.add(s.charAt(i));
            }
            System.out.println(set.size());
        }
        sc.close();
    }
}