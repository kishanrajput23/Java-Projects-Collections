
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class subarray {
    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       String s=sc.next();
       int n=sc.nextInt();
       List<String>li=new ArrayList<>();
       for(int i=0;i<n-3;i++)
       {
        li.add(s.substring(i,i+3));
       }
       Collections.sort(li);
       System.out.println(li.get(0));
       System.out.println(li.get(li.size()-1));
sc.close();
    }
}

