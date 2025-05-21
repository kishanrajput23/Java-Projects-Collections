import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class GameConsoleUI {
    private PatienceGame game;
    private Scanner scanner;

    public GameConsoleUI(PatienceGame game) {
        this.game = game;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        // Initial setup of cards in lanes might require some cards to be face up
        initializeLaneCards(); 

        while (true) {
            displayGameState();
            if (game.isGameOver()) {
                System.out.println("Congratulations! You won the game!");
                System.out.println("Final Score: " + game.getScore());
                break;
            }

            System.out.print("Enter a command (Q, D, or move e.g., P1, 12, 1S, 123): ");
            String command = scanner.nextLine().toUpperCase().trim();

            if (command.equals("Q")) {
                System.out.println("Game Over. Final Score: " + game.getScore());
                break;
            } else if (command.equals("D")) {
                if (!game.drawCard()) {
                    System.out.println("Draw pile is empty or cannot draw.");
                }
            } else if (command.length() == 2) {
                if (!game.moveCard(command)) {
                    System.out.println("Invalid move. Please check rules or piles.");
                }
            } else if (command.length() == 3 && Character.isDigit(command.charAt(2))) {
                 // Assuming the third char is a number for multiple cards
                if (!game.moveMultipleCards(command)) {
                    System.out.println("Invalid multiple card move. Please check rules or piles.");
                }
            } else {
                System.out.println("Invalid command format. Please try again.");
            }
        }
        scanner.close();
    }

    private void initializeLaneCards() {
        // Classic Solitaire: 1 card in 1st lane, 2 in 2nd, ..., 7 in 7th
        // The last card in each lane is face up.
        // This logic should be part of PatienceGame.initializeGame() or a new method there.
        // For now, let's assume PatienceGame.initializeGame deals cards face down
        // and we flip the top one of each lane here, or PatienceGame does it.

        // If PatienceGame.initializeGame doesn't set up lanes, it should be done here by drawing.
        // For simplicity, this example assumes lanes are populated by PatienceGame constructor.
        // We just need to ensure top cards are face up.
        for (int i = 0; i < game.getNumLanes(); i++) {
            Stack<Card> lane = game.getLanes().get(i);
            // Deal cards to lanes according to Solitaire rules
            // For i-th lane (0-indexed), deal i+1 cards
            for (int j = 0; j <= i; j++) {
                if (!game.getDrawPile().isEmpty()) {
                    Card card = game.getDrawPile().pop();
                    if (j == i) { // Last card is face up
                        card.setFaceUp(true);
                    }
                    lane.push(card);
                }
            }
        }
    }


    private void displayGameState() {
        System.out.println("\n-----------------------------------");
        System.out.println("Score: " + game.getScore() + " | Moves: " + game.getMoves());
        System.out.println("-----------------------------------");

        // Draw Pile and Uncovered Pile
        String drawPileStr = game.getDrawPile().isEmpty() ? "[   ]" : "[XXX]";
        String uncoveredPileStr = game.getUncoveredPile().isEmpty() ? "[   ]" : game.getUncoveredPile().peek().toString();
        System.out.println("Draw (D): " + drawPileStr + "   Uncovered (P): " + uncoveredPileStr + " (" + game.getUncoveredPile().size() + ")");
        System.out.println("-----------------------------------");

        // Suit Piles
        System.out.print("Suit Piles: ");
        for (int i = 0; i < game.getNumSuits(); i++) {
            Stack<Card> pile = game.getSuitPiles().get(i);
            char suitLabel = Card.SUIT_LABELS[i].charAt(0);
            String topCard = pile.isEmpty() ? "[ ]" : pile.peek().toString();
            System.out.print(suitLabel + ": " + topCard + "  ");
        }
        System.out.println("\n-----------------------------------");

        // Lanes
        System.out.println("Lanes (1-7):");
        int maxLaneSize = 0;
        for (Stack<Card> lane : game.getLanes()) {
            if (lane.size() > maxLaneSize) {
                maxLaneSize = lane.size();
            }
        }

        for (int i = 0; i < game.getNumLanes(); i++) {
            System.out.printf("%d: ", i + 1);
            Stack<Card> lane = game.getLanes().get(i);
            if (lane.isEmpty()) {
                System.out.print("[   ]");
            } else {
                // Display all cards, faceUp status will be handled by Card.toString()
                for (Card card : lane) {
                     System.out.print(card.toString() + " ");
                }
            }
            System.out.println();
        }
         System.out.println("-----------------------------------");
    }
}