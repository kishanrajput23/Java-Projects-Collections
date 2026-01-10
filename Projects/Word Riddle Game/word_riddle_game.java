import java.util.Scanner;

public class WordRiddleGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Define a list of riddles and their answers
        String[] riddles = {
            "I am taken from a mine, and shut up in a wooden case, from which I am never released, and yet I am used by almost every person. What am I?",
            "I speak without a mouth and hear without ears. I have no body, but I come alive with the wind. What am I?",
            // Add more riddles here
        };
        String[] answers = {
            "Pencil",
            "Echo",
            // Add more answers here
        };

        // Game loop
        for (int i = 0; i < riddles.length; i++) {
            System.out.println("Riddle " + (i + 1) + ": " + riddles[i]);
            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine();

            if (userAnswer.equalsIgnoreCase(answers[i])) {
                System.out.println("Correct! You solved the riddle.");
            } else {
                System.out.println("Incorrect. The answer is: " + answers[i]);
            }

            // Ask if the player wants to play another riddle
            System.out.print("Do you want to play another riddle? (yes/no): ");
            String playAgain = scanner.nextLine().toLowerCase();
            if (!playAgain.equals("yes")) {
                break; // Exit the game if the user doesn't want to play again
            }
        }

        System.out.println("Thanks for playing!");
        scanner.close();
    }
}
