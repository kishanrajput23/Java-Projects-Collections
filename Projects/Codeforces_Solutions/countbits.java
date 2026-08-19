import java.util.ArrayList;
import java.util.List;

public class countbits {
    static int[] bits=new int [100010];
static{
    for(int i=0;i<bits.length; i++)
    { 
        int count=0,n=i;
    while(n > 0)
    {if((n&1)== 1)
        count++;
        n=n >> 1;
    }
    bits[i]=count;
    }
}
public static List<Integer> solve(int n) {
        List <Integer> ans = new ArrayList<>();
    for(int i=0;i <= n;i++)
        ans.add(bits[i]);
    return ans;
}
public static void main(String[] args) {
    for(int i=0;i<=10;i++)
    System.out.println(bits[i]);
    System.out.println(solve(11));
}   
}