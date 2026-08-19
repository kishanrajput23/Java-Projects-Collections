import java.util.*;

public class Isyourhorseshoeontheotherhoof {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Set<Integer>s=new HashSet<>();
        for(int i=0;i<4;i++)
        s.add(sc.nextInt());
        System.out.println(4-s.size());
        sc.close();
    }
}
