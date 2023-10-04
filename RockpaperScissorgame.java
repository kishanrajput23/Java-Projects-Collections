import java.util.Random;
import java.util.Scanner;

public class Rockpapergame {
    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        Random rc = new Random();

        System.out.println("enter  0 for rock, 1 for Paper  and 2 for scissor");
        int user = sc.nextInt();

        int computer = rc.nextInt(3);

        if (user == computer ) {
            System.out.println("draw");
        } else if ( user==0 && computer==1 || user ==1 && computer==2 || user==2 && computer==0){
            System.out.println("you lost");
        } else {
            System.out.println("you win ");
        }
    System.out.println("computer chose : " +computer);
        if (computer==0){
            System.out.println("computer chose rock");
        }else if  (computer==1 ) {
            System.out.println("computer chose paper");


        }else {
            System.out.println("computer chose rock");
        }


    }
}
