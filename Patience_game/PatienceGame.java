import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class PatienceGame {

  private static final int NUM_LANES = 7;
  private static final int NUM_SUITS = 4;
  private static final int NUM_CARDS_PER_SUIT = 13;

  private Stack<Card> drawPile = new Stack<>();
  private List<Stack<Card>> lanes = new ArrayList<>(NUM_LANES);
  private List<Stack<Card>> suitPiles = new ArrayList<>(NUM_SUITS);
  private Stack<Card> uncoveredPile = new Stack<>();
  private int score = 0;
  private int moves = 0;

  public PatienceGame() {
    initializeGame();
  }

  // Add this method to the PatienceGame class
  private void moveUncoveredCardToSuit(char suitLabel) {
    int suitIndex = getLabelIndex(suitLabel);
    if (suitIndex >= NUM_LANES && suitIndex < NUM_LANES + NUM_SUITS) {
      if (uncoveredPile.isEmpty()) {
        System.out.println("Uncovered pile is empty.");
      } else {
        Card card = uncoveredPile.peek();
        if (suitPiles.get(suitIndex - NUM_LANES).isEmpty()) {
          if (card.getValue() == 1) {
            suitPiles.get(suitIndex - NUM_LANES).push(uncoveredPile.pop());
            calculateScore(card, 'P', suitLabel);
            moves++;
          } else {
            System.out.println("Invalid move. Only Aces can start a new pile.");
          }
        } else {
          Card topCard = suitPiles.get(suitIndex - NUM_LANES).peek();
          if (
            topCard.isOneValueHigher(card) &&
            topCard.getSuit() == card.getSuit()
          ) {
            suitPiles.get(suitIndex - NUM_LANES).push(uncoveredPile.pop());
            calculateScore(card, 'P', suitLabel);
            moves++;
          } else {
            System.out.println("Invalid move. Check the destination pile.");
          }
        }
      }
    } else {
      System.out.println("Invalid command. Cannot move to a lane.");
    }
  }

  private void initializeGame() {
    // Create and shuffle a deck of cards
    List<Card> deck = new ArrayList<>();
    for (int suit = 0; suit < NUM_SUITS; suit++) {
      for (int value = 1; value <= NUM_CARDS_PER_SUIT; value++) {
        deck.add(new Card(suit, value));
      }
    }
    Collections.shuffle(deck);

    // Initialize the draw pile with the shuffled deck
    drawPile.addAll(deck);

    // Initialize lanes and suit piles
    for (int i = 0; i < NUM_LANES; i++) {
      lanes.add(new Stack<>());
    }
    for (int i = 0; i < NUM_SUITS; i++) {
      suitPiles.add(new Stack<>());
    }
  }

  public void playGame() {
    Scanner scanner = new Scanner(System.in);
    while (true) {
      displayGameState();
      System.out.print("Enter a command (Q, D, or move): ");
      String command = scanner.nextLine().toUpperCase();

      if (command.equals("Q")) {
        System.out.println("Game Over. Final Score: " + score);
        break;
      } else if (command.equals("D")) {
        drawCard();
      } else if (command.length() == 2) {
        moveCard(command);
      } else if (command.length() == 3) {
        moveMultipleCards(command);
      } else {
        System.out.println("Invalid command. Please try again.");
      }

      if (isGameOver()) {
        System.out.println("Congratulations! You won the game!");
        break;
      }
    }
    scanner.close();
  }

  private void displayGameState() {

    String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        String[] suits = {"H", "D", "S", "C"};

        for (String suit : suits) {
            for (String rank : ranks) {
                String card = rank + suit;
                System.out.print(card + " ");
            }
            System.out.println(); // Start a new line for the next suit
        }
        
    System.out.println("Score: " + score);
    System.out.println("Moves: " + moves);
    System.out.println("Draw Pile: " + drawPile.size() + " cards");
    System.out.println("Uncovered Pile: " + uncoveredPile.size() + " cards");
    for (int i = 0; i < NUM_LANES; i++) {
      System.out.println(
        "Lane " + (i + 1) + ": " + lanes.get(i).size() + " cards"
      );
    }
    for (int i = 0; i < NUM_SUITS; i++) {
      System.out.println(
        "Suit " +
        Card.SUIT_LABELS[i] +
        ": " +
        suitPiles.get(i).size() +
        " cards"
      );
    }
  }

  private void drawCard() {
    if (!drawPile.isEmpty()) {
      Card card = drawPile.pop();
      uncoveredPile.push(card);
      moves++;
    } else {
      System.out.println("Draw pile is empty. Cannot draw a card.");
    }
  }

  private void moveCard(String command) {
    char fromLabel = command.charAt(0);
    char toLabel = command.charAt(1);
    int fromIndex = getLabelIndex(fromLabel);
    int toIndex = getLabelIndex(toLabel);

    if (fromIndex != -1 && toIndex != -1) {
      if (fromLabel == 'P') {
        moveUncoveredCardToSuit(toLabel);
      } else if (fromLabel >= '1' && fromLabel <= '7') {
        Card card = lanes.get(fromIndex).peek();
        if (canMoveCard(card, toIndex)) {
          lanes.get(toIndex).push(lanes.get(fromIndex).pop());
          calculateScore(card, fromLabel, toLabel);
          moves++;
        } else {
          System.out.println("Invalid move. Check the destination pile.");
        }
      }
    } else {
      System.out.println("Invalid labels.");
    }
  }

  private void moveMultipleCards(String command) {
    char fromLabel = command.charAt(0);
    char toLabel = command.charAt(1);
    int number = Character.getNumericValue(command.charAt(2));
    int fromIndex = getLabelIndex(fromLabel);
    int toIndex = getLabelIndex(toLabel);

    if (fromIndex != -1 && toIndex != -1) {
      if (lanes.get(fromIndex).size() >= number) {
        List<Card> cardsToMove = new ArrayList<>();
        for (int i = 0; i < number; i++) {
          cardsToMove.add(
            lanes.get(fromIndex).get(lanes.get(fromIndex).size() - 1 - i)
          );
        }
        if (canMoveCards(cardsToMove, toIndex)) {
          for (Card card : cardsToMove) {
            lanes.get(toIndex).push(lanes.get(fromIndex).pop());
            calculateScore(card, fromLabel, toLabel);
          }
          moves++;
        } else {
          System.out.println("Invalid move. Check the destination pile.");
        }
      } else {
        System.out.println("Not enough cards in the source lane.");
      }
    } else {
      System.out.println("Invalid labels.");
    }
  }

  private int getLabelIndex(char label) {
    if (label == 'P') {
      return NUM_LANES;
    } else if (label >= '1' && label <= '7') {
      return Character.getNumericValue(label) - 1;
    } else if (label >= 'D' && label <= 'S') {
      return NUM_LANES + label - 'D';
    }
    return -1;
  }

  private boolean canMoveCard(Card card, int toIndex) {
    if (lanes.get(toIndex).isEmpty()) {
      return card.getValue() == 13; // Only Kings can start a new pile
    } else {
      Card topCard = lanes.get(toIndex).peek();
      return topCard.isOneValueHigher(card) && topCard.isOppositeColor(card);
    }
  }

  private boolean canMoveCards(List<Card> cards, int toIndex) {
    if (lanes.get(toIndex).isEmpty()) {
      return cards.get(0).getValue() == 13; // Only Kings can start a new pile
    } else {
      Card topCard = lanes.get(toIndex).peek();
      return (
        topCard.isOneValueHigher(cards.get(cards.size() - 1)) &&
        topCard.isOppositeColor(cards.get(cards.size() - 1))
      );
    }
  }

  private void calculateScore(Card card, char fromLabel, char toLabel) {
    if (fromLabel == 'P' && (toLabel >= 'D' && toLabel <= 'S')) {
      score += 10; // From uncovered pile to suit
    } else if (
      fromLabel >= '1' && fromLabel <= '7' && (toLabel >= 'D' && toLabel <= 'S')
    ) {
      score += 20; // From lane to suit
    } else if (
      (fromLabel >= '1' && fromLabel <= '7') &&
      (toLabel >= '1' && toLabel <= '7')
    ) {
      score += 5; // Between lanes
    }
  }

  private boolean isGameOver() {
    for (Stack<Card> suitPile : suitPiles) {
      if (suitPile.size() < NUM_CARDS_PER_SUIT) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    PatienceGame game = new PatienceGame();
    game.playGame();
  }
}

class Card {
    public static final String[] SUIT_LABELS = {"D", "H", "C", "S"};
    private int suit;
    private int value;

    public Card(int suit, int value) {
        this.suit = suit;
        this.value = value;
    }

    public int getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

    public char getLabel() {
        return SUIT_LABELS[suit].charAt(0);
    }

    public boolean isOneValueHigher(Card other) {
        return this.value - other.value == 1;
    }

public boolean isOppositeColor(Card other) {
    return (this.suit < 2 && other.suit >= 2) || (this.suit >= 2 && other.suit < 2);
}

}