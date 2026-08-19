import java.util.Scanner;

public class georgeandaccommoidation {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int count=0;
        while(n--!=0)
        {
            int p=sc.nextInt();
            int q=sc.nextInt();
            if(p+2<=q)
            count++;
        }
        System.out.println(count);
        sc.close();
    }
}
