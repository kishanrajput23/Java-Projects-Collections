
import java.util.Random;
import java.util.Scanner;

public class DetectiveJill {

    public static void main() {
        // DECLARATION + INITIALIZATION
        int answerSet, solution, murder, weapon, location;
        Theory answer;
        AssistantJack jack;
        Scanner keyboard = new Scanner(System.in);
        Random random = new Random();

        // INPUT
        System.out.print("Which theory would like you like to test? (1, 2, 3[random]): ");
        answerSet = keyboard.nextInt();
        keyboard.close();

        // PROCESSING
        jack = new AssistantJack(answerSet);
//START OUR WEAPON LOCATION AND MURDER AT 1
      int weapont = 1, locationt = 1, murdert = 1, total1 = 0;
//CHECK IF 1,1,1 IS CORRECT
      solution = jack.checkAnswer(weapont, locationt, murdert);
//IF NOT CONTINUE WITH WHILE LOOP
      while(solution != 0){
        //SWITCH BASED OF WHAT JACK SAYS IS WRONG
        switch(solution){
          case 1:
            //IF WEAPON IS WRONG
            weapont++;
            break;
          case 2:
            //IF LOCATION IS WRONG
            locationt++;
            break;
          case 3:
            //IF MURDER IS WRONG
            murdert++;
            break;
        }
      //CHECK SOLUTION AND IF WRONG, LOOP CONTINUES
      solution = jack.checkAnswer(weapont, locationt, murdert);
      }

  answer = new Theory(weapont, locationt, murdert);
        

        // OUTPUT
        System.out.println("Total Checks = " + jack.getTimesAsked() + ", Solution " + answer);

        if (jack.getTimesAsked() > 20) {
            System.out.println("FAILED!! You're a horrible Detective...¯\\_(ツ)_/¯");
        } else {
            System.out.println("WOW! You might as well be called Batman");
          
        }

    }

}