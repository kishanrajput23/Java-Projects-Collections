import java.util.Scanner;

public class HangmanGame {
    private static String[] words = {"java", "programming", "hangman", "computer", "algorithm"};
    private static String selectedWord;
    private static String guessedWord;
    private static int maxAttempts = 6;
    private static int attemptsLeft = maxAttempts;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        selectWord();

        while (true) {
            System.out.println("Word: " + guessedWord);
            System.out.println("Attempts left: " + attemptsLeft);
            System.out.print("Enter a letter or the entire word: ");
            String guess = scanner.nextLine().toLowerCase();

            if (guess.length() == 1) {
                processLetterGuess(guess.charAt(0));
            } else if (guess.length() == selectedWord.length()) {
                processWordGuess(guess);
            } else {
                System.out.println("Invalid input. Please enter a single letter or the entire word.");
            }

            if (guessedWord.equals(selectedWord)) {
                System.out.println("Congratulations! You've guessed the word: " + selectedWord);
                break;
            } else if (attemptsLeft == 0) {
                System.out.println("You've run out of attempts. The word was: " + selectedWord);
                break;
            }
        }
        scanner.close();
    }

    private static void selectWord() {
        selectedWord = words[(int) (Math.random() * words.length)];
        guessedWord = new String(new char[selectedWord.length()]).replace('\0', '_');
    }

    private static void processLetterGuess(char letter) {
        boolean found = false;
        for (int i = 0; i < selectedWord.length(); i++) {
            if (selectedWord.charAt(i) == letter) {
                guessedWord = guessedWord.substring(0, i) + letter + guessedWord.substring(i + 1);
                found = true;
            }
        }
        if (!found) {
            attemptsLeft--;
        }
    }

    private static void processWordGuess(String word) {
        if (word.equals(selectedWord)) {
            guessedWord = selectedWord;
        } else {
            attemptsLeft--;
        }
    }
}
