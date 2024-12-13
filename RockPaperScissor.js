import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {
    public static void main(String[] args) {
        playGame();
    }

    public static String computerPlay() {
        String[] choices = {"Rock", "Paper", "Scissors"};
        Random random = new Random();
        int randomIndex = random.nextInt(3);
        return choices[randomIndex];
    }

    public static String playRound(String playerSelection, String computerSelection) {
        playerSelection = playerSelection.toLowerCase();
        computerSelection = computerSelection.toLowerCase();

        if (playerSelection.equals(computerSelection)) {
            return "It's a tie!";
        }

        if ((playerSelection.equals("rock") && computerSelection.equals("scissors")) ||
            (playerSelection.equals("scissors") && computerSelection.equals("paper")) ||
            (playerSelection.equals("paper") && computerSelection.equals("rock"))) {
            return "You win! " + playerSelection + " beats " + computerSelection;
        }

        return "You lose! " + computerSelection + " beats " + playerSelection;
    }

    public static void playGame() {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            System.out.print("Rock, Paper, or Scissors? ");
            String playerSelection = scanner.nextLine().trim();
            String computerSelection = computerPlay();
            String roundResult = playRound(playerSelection, computerSelection);
            System.out.println(roundResult);
        }

        scanner.close();
    }
}
