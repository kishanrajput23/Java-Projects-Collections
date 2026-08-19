import java.util.Scanner;


public class PetyaandStrings {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String f=sc.next();
        String s=sc.next();
        int ans=f.compareToIgnoreCase(s);
        if(ans==0){
            System.out.println("0");
        }else if(ans<0){
            System.out.println("-1");
        }
        else{
            System.out.println("1");
        }
        sc.close();
    }
}
