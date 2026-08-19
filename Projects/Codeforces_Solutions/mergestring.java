import java.util.*;
public class mergestring{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String f=sc.nextLine();
        String s=sc.nextLine();
        int l1=f.length();
        int l2=s.length();
        String merge="";
        for(int i=0,j=0;i<l1||j<l2;i++,j++)
        {   if(i<l1)
           {
            char f1=f.charAt(i);
            merge+=f1;
           }
           if(j<l2) 
           {
            char s1=s.charAt(j);
            merge+=s1;   
           }    
        }
        System.out.println(merge);
        sc.close();
    }
}