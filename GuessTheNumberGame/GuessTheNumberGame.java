import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        boolean playAgain = true;

        while (playAgain) {
            int lowerBound = 1;  // Set the lower bound of the random number range
            int upperBound = 100;  // Set the upper bound of the random number range
            int maxAttempts = 10; // Set the maximum number of attempts

            // Difficulty selection
            System.out.println("Select difficulty: [1] Easy [2] Medium [3] Hard");
            int difficulty = scanner.nextInt();
            if (difficulty == 1) {
                upperBound = 50;
                maxAttempts = 10;
            } else if (difficulty == 2) {
                upperBound = 100;
                maxAttempts = 7;
            } else if (difficulty == 3) {
                upperBound = 200;
                maxAttempts = 5;
            } else {
                System.out.println("Invalid choice. Defaulting to Medium.");
            }

            int secretNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;

            System.out.println("Welcome to Guess the Number Game!");
            System.out.println("I've selected a number between " + lowerBound + " and " + upperBound + ". Try to guess it!");

            for (int attempts = 1; attempts <= maxAttempts; attempts++) {
                System.out.print("Attempt #" + attempts + ": Enter your guess: ");
                int playerGuess;
                try {
                    playerGuess = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next(); // clear invalid input
                    attempts--;
                    continue;
                }

                if (playerGuess < lowerBound || playerGuess > upperBound) {
                    System.out.println("Please enter a number between " + lowerBound + " and " + upperBound + ".");
                    attempts--;
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

                // Hint after 3 failed attempts
                if (attempts == 3) {
                    if (secretNumber % 2 == 0) {
                        System.out.println("Hint: The number is even.");
                    } else {
                        System.out.println("Hint: The number is odd.");
                    }
                }

                if (attempts == maxAttempts) {
                    System.out.println("Sorry, you've run out of attempts. The secret number was " + secretNumber + ".");
                }
            }

            // Replay option
            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next().toLowerCase();
            playAgain = response.equals("yes") || response.equals("y");
        }

        scanner.close();
        System.out.println("Thanks for playing!");
    }
}
