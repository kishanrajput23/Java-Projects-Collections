import java.util.*;
public class Buyashovel {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int k=sc.nextInt();
        int r=sc.nextInt();
        int total=k;
        int i=1;
        while(true)
        {
            if(total%10==0||total%10==r)
             break;
            total+=k;
            i++;
        }
        System.out.println(i);
        sc.close();
    }

}
