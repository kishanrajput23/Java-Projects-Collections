import java.util.Scanner;
import java.util.Random;

public class WaterGunGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Water Gun Game!");
        System.out.print("Enter Player 1's name: ");
        String player1Name = scanner.nextLine();
        System.out.print("Enter Player 2's name: ");
        String player2Name = scanner.nextLine();

        int player1Water = 100;
        int player2Water = 100;
        boolean isPlayer1Turn = true;

        while (player1Water > 0 && player2Water > 0) {
            System.out.println("\n" + player1Name + "'s water: " + player1Water);
            System.out.println(player2Name + "'s water: " + player2Water);

            if (isPlayer1Turn) {
                System.out.print(player1Name + ", choose an action (1: Fill water gun, 2: Shoot): ");
            } else {
                System.out.print(player2Name + ", choose an action (1: Fill water gun, 2: Shoot): ");
            }

            int action = scanner.nextInt();

            if (action == 1) {
                if (isPlayer1Turn) {
                    player1Water = 100;
                    System.out.println(player1Name + " filled their water gun.");
                } else {
                    player2Water = 100;
                    System.out.println(player2Name + " filled their water gun.");
                }
            } else if (action == 2) {
                int shotAmount = random.nextInt(21); // Randomly shoot between 0 and 20
                if (isPlayer1Turn) {
                    player2Water -= shotAmount;
                    System.out.println(player1Name + " shot " + player2Name + " with " + shotAmount + " water!");
                } else {
                    player1Water -= shotAmount;
                    System.out.println(player2Name + " shot " + player1Name + " with " + shotAmount + " water!");
                }
            } else {
                System.out.println("Invalid action. Choose 1 to fill or 2 to shoot.");
            }

            isPlayer1Turn = !isPlayer1Turn;
        }

        if (player1Water <= 0) {
            System.out.println(player1Name + " is out of water. " + player2Name + " wins!");
        } else {
            System.out.println(player2Name + " is out of water. " + player1Name + " wins!");
        }

        scanner.close();
    }
}
