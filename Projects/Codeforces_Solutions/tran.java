import java.util.Scanner;

public class tran {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int current=0;
        int maxpass=0;
        while(t--!=0)
        {
            int ex=sc.nextInt();
            int en=sc.nextInt();
            current=current-ex;
            current=current+en;
            maxpass=Math.max(current,maxpass);
        }
        System.out.println(maxpass);
        sc.close();
    }
}
