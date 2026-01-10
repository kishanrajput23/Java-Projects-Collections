import java.util.Random;
import java.util.Scanner;

public class RiddleQuest {
    public static void main(String[] args) {
        Random random = new Random();
        int secretNumber = random.nextInt(100) + 1; // Random number between 1 and 100
        int attempts = 10; // Number of attempts allowed

        System.out.println("Welcome to the Unknown Hard Game!");
        System.out.println("You have to guess a number between 1 and 100 in " + attempts + " attempts.");

        Scanner scanner = new Scanner(System.in);
        int guess;
        boolean hasGuessedCorrectly = false;

        for (int i = 1; i <= attempts; i++) {
            System.out.print("Attempt " + i + ": Enter your guess: ");
            guess = scanner.nextInt();

            if (guess == secretNumber) {
                hasGuessedCorrectly = true;
                System.out.println("Congratulations! You've guessed the number.");
                break;
            } else if (guess < secretNumber) {
                System.out.println("The number is higher.");
            } else {
                System.out.println("The number is lower.");
            }
        }

        if (!hasGuessedCorrectly) {
            System.out.println("Sorry, you've run out of attempts. The secret number was " + secretNumber + ".");
        }

        scanner.close();
    }
}
