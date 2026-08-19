import java.util.Scanner;
public class CandiesandTwoSisters {
    public static void main(String[] args) {
     Scanner sc=new Scanner(System.in);   
     int n=sc.nextInt();
     while(n--!=0)
     {
        int a=sc.nextInt();
        int ans=0;
        ans=(a-1)/2;
        System.out.println(ans);
    }
    sc.close();
    }
}
