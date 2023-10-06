import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int lowerBound = 1;  // Set the lower bound of the random number range
        int upperBound = 100;  // Set the upper bound of the random number range
        int secretNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
        
        int maxAttempts = 10; // Set the maximum number of attempts
        
        System.out.println("Welcome to Guess the Number Game!");
        System.out.println("I've selected a number between " + lowerBound + " and " + upperBound + ". Try to guess it!");
        
        for (int attempts = 1; attempts <= maxAttempts; attempts++) {
            System.out.print("Attempt #" + attempts + ": Enter your guess: ");
            int playerGuess = scanner.nextInt();
            
            if (playerGuess < lowerBound || playerGuess > upperBound) {
                System.out.println("Please enter a number between " + lowerBound + " and " + upperBound + ".");
                continue;
            }
            
            if (playerGuess < secretNumber) {
                System.out.println("Too low! Try again.");
            } else if (playerGuess > secretNumber) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Congratulations! You've guessed the number " + secretNumber + " correctly in " + attempts + " attempts.");
                break;
            }
            
            if (attempts == maxAttempts) {
                System.out.println("Sorry, you've run out of attempts. The secret number was " + secretNumber + ".");
            }
        }
        
        scanner.close();
    }
}
