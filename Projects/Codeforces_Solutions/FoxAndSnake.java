import java.util.*;
public class FoxAndSnake {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        String s1="";
        String s2="";
        String s3="#";
        for(int i=0;i<b;i++)
        s1+="#";
        for(int i=0;i<b-1;i++)
        s2+=".";
        s3+=s2;
        s2+="#";
        int j=0;
        for(int i=0;i<a;i++)
        if(i%2==0)
        System.out.println(s1);
        else 
        {
            if(j%2==0)
                System.out.println(s2);
            else
                System.out.println(s3);
            j++;
        }
        sc.close();
    }
}
