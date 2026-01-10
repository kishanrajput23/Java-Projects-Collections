
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class GuessNumberGame {

  private static final int MIN_NUMBER = 1;
  private static final int MAX_NUMBER = 1000;

  public static void main(String[] args) {
    GuessNumberGame game = new GuessNumberGame();
    game.startGame();
  }

  public void startGame() {
    boolean isUserGuessCorrect = false;
    int numberOfGuesses = 0;
    // computer thinks a number
    int computerNumber = getNumberByComputer();

    // Program continues till user guesses the number correctly
    while (!isUserGuessCorrect) {
      int userNumber = getUserGuessedNumber();
      if (userNumber > computerNumber) {
        System.out.println("Sorry, the number you guessed is too high");
      } else if (userNumber < computerNumber) {
        System.out.println("Sorry, the number you guessed is too low");
      } else if (userNumber == computerNumber) {
        System.out.println("Congratulations! Your guess is correct!");
        isUserGuessCorrect = true;
      }
      numberOfGuesses++;
    }
    System.out.println("You found the number in " + numberOfGuesses + " guesses");
  }

  public int getNumberByComputer() {
    return ThreadLocalRandom.current().nextInt(MIN_NUMBER, MAX_NUMBER + 1);
  }

  public int getUserGuessedNumber() {
    Scanner sn = new Scanner(System.in);
    System.out.println("Please guess the number: ");
    return sn.nextInt();
  }
}
