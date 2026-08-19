import java.util.*;
import java.util.Scanner;

public class CircleofAppleTrees {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t--!=0)
        {
            int n=sc.nextInt();
            Map<Integer,Integer>mp=new HashMap<>();
            while(n--!=0)
            {
                int a=sc.nextInt();
                mp.put(a,mp.getOrDefault(a,0)+1);
            }
            System.out.println(mp.size());
        }
    }
}
