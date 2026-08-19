import java.util.*;
public class ballandbagquery {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        Map<Integer,Integer>mp=new HashMap<>();
        while(t--!=0)
        {
            int a=sc.nextInt();
            int x=0;
            switch(a) {
                case 1:  x=sc.nextInt();
                        mp.put(x,mp.getOrDefault(x,0)+1);
                        break;
                case 2:  x=sc.nextInt();
                        mp.put(x,mp.get(x)-1);
                        if(mp.get(x)==0)
                        mp.remove(x);
                        break;
                case 3:  System.out.println(mp.size());
                        break;
            }
        }
        sc.close();
}
}
