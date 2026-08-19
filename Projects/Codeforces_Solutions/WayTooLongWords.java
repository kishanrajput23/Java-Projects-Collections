import java.util.Scanner;
public class WayTooLongWords {
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int t=sc.nextInt();
    sc.nextLine();
    while (t--!=0)
    {
        String s=sc.next();
        if(s.length()<=4)
        {
            System.out.println(s);
        }
        else{
            int l=s.length()-2;
            System.out.print(s.charAt(0));
            System.out.print(l);
            System.out.print(s.charAt(s.length()-1));
            System.out.println();
        }
    }
    sc.close();
}
}
