import java.util.*;
public class AntonandDanik{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String s=sc.next();
        int countA=0;
        for(int i=0;i<n;i++)
        {
            if(s.charAt(i)=='A')
            {
                countA++;
            }
        
        }
        if(countA==n-countA)
        System.out.println("Friendship");
        else if(countA<n-countA)
        System.out.println("Danik");
        else
        System.out.println("Anton");
        sc.close();
    }
}
