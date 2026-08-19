import java.util.*;
public class helpfulmaths {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int mat[]=new int[(s.length()/2)+1];
        int x=0;
        for(int i=0;i<s.length();i+=2)
        {
            mat[x++]=(int)s.charAt(i)-48;
        }
        Arrays.sort(mat);
        x=0;
        for(int i=0;i<s.length();i++)
        {
            if(i%2==0)
            {
                System.out.print(mat[x++]);
            }
            else
            {
                System.out.print("+");
            }
            
        }
        sc.close();
}
}
