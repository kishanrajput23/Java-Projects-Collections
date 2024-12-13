import java.util.Random;
import java.util.Scanner;

public class RandomWordGuessingGame {
    public static void main(String[] args) {
        String[] words = {"apple", "banana", "chocolate", "elephant", "giraffe"};
        Random random = new Random();
        String targetWord = words[random.nextInt(words.length)];
        String currentGuess = maskWord(targetWord);
        int numberOfTries = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Random Word Guessing Game!");
        System.out.println("Can you guess the word? Let's get started!");

        while (!currentGuess.equals(targetWord)) {
            System.out.println("Current Guess: " + currentGuess);
            System.out.print("Enter a letter: ");
            String letter = scanner.next().toLowerCase();

            if (letter.length() != 1 || !Character.isLetter(letter.charAt(0))) {
                System.out.println("Please enter a single letter.");
                continue;
            }

            if (targetWord.contains(letter)) {
                currentGuess = updateCurrentGuess(targetWord, currentGuess, letter);
                System.out.println("Good guess!");
            } else {
                System.out.println("Sorry, that letter is not in the word.");
            }

            numberOfTries++;
        }

        System.out.println("Congratulations! You guessed the word '" + targetWord + "' in " + numberOfTries + " tries.");
    }

    // Mask the target word with underscores.
    private static String maskWord(String word) {
        StringBuilder maskedWord = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            maskedWord.append('_');
        }
        return maskedWord.toString();
    }

    // Update the current guess with correctly guessed letters.
    private static String updateCurrentGuess(String target, String currentGuess, String letter) {
        StringBuilder updatedGuess = new StringBuilder(currentGuess);
        for (int i = 0; i < target.length(); i++) {
            if (target.charAt(i) == letter.charAt(0)) {
                updatedGuess.setCharAt(i, letter.charAt(0));
            }
        }
        return updatedGuess.toString();
    }
}
