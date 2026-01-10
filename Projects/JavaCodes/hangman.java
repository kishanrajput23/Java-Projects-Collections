import java.util.Scanner;
import java.util.Random;

public class HangmanGame {
    public static void main(String[] args) {
        String[] words = { "java", "programming", "hangman", "computer", "algorithm", "developer" };
        Random random = new Random();
        String wordToGuess = words[random.nextInt(words.length)];

        int maxAttempts = 6;
        int attemptsLeft = maxAttempts;
        boolean[] guessedLetters = new boolean[wordToGuess.length()];

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Hangman!");
        char[] displayWord = new char[wordToGuess.length()];
        for (int i = 0; i < wordToGuess.length(); i++) {
            displayWord[i] = '_';
        }

        while (attemptsLeft > 0) {
            System.out.println("Word to guess: " + new String(displayWord));
            System.out.println("Attempts left: " + attemptsLeft);
            System.out.print("Guess a letter: ");
            char guess = scanner.next().charAt(0);

            boolean found = false;
            for (int i = 0; i < wordToGuess.length(); i++) {
                if (wordToGuess.charAt(i) == guess) {
                    displayWord[i] = guess;
                    guessedLetters[i] = true;
                    found = true;
                }
            }

            if (!found) {
                System.out.println("Incorrect guess.");
                attemptsLeft--;
            }

            boolean isComplete = true;
            for (boolean guessed : guessedLetters) {
                if (!guessed) {
                    isComplete = false;
                    break;
                }
            }

            if (isComplete) {
                System.out.println("Congratulations! You've guessed the word: " + wordToGuess);
                break;
            }
        }

        if (attemptsLeft == 0) {
            System.out.println("Out of attempts. The word was: " + wordToGuess);
        }

        scanner.close();
    }
}
