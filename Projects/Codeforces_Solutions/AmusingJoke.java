import java.util.*;

public class AmusingJoke {
public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    String n1=sc.next();
    String n2=sc.next();
    String n3=sc.next();
    Map<Character,Integer>mp=new HashMap<>();
    for(int i=0;i<n1.length();i++)
    {
        mp.put(n1.charAt(i),mp.getOrDefault(n1.charAt(i), 0)+1);
    }
    for(int i=0;i<n2.length();i++)
    {
        mp.put(n2.charAt(i),mp.getOrDefault(n2.charAt(i), 0)+1);
    }
    for(int i=0;i<n3.length();i++)
    {
        if(mp.get(n3.charAt(i))>1)
        {
            mp.put(n3.charAt(i),mp.get(n3.charAt(i))-1);
        }
        else if(mp.get(n3.charAt(i))==0)
        {
            mp.remove(n3.charAt(i));
        }
    }
    if(mp.size()==0)
    System.out.println("YES");
    else
    System.out.println("NO");
    sc.close();
} 
}
