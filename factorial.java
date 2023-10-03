import java.util.Scanner;

public class factorial {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
     System.out.print("Input a number: ");
     int n = in.nextInt(); 
     in.close();
     int fact = 1;
     
     while(n>0){
        fact= fact*n;
        n--;
     }
     System.err.println("factorial of your number is = " + fact );
    }
    
    
}
