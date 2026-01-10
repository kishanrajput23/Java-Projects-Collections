import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
// No Scanner needed here
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

  // Getters for UI to display game state
  public Stack<Card> getDrawPile() { return drawPile; }
  public List<Stack<Card>> getLanes() { return lanes; }
  public List<Stack<Card>> getSuitPiles() { return suitPiles; }
  public Stack<Card> getUncoveredPile() { return uncoveredPile; }
  public int getScore() { return score; }
  public int getMoves() { return moves; }
  public int getNumLanes() { return NUM_LANES; }
  public int getNumSuits() { return NUM_SUITS; }
  public int getNumCardsPerSuit() { return NUM_CARDS_PER_SUIT; }


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

  // Modified to return a status or boolean, instead of printing
  public boolean moveUncoveredCardToSuit(char suitLabel) {
    int suitIndex = getLabelIndex(suitLabel);
    if (suitIndex >= NUM_LANES && suitIndex < NUM_LANES + NUM_SUITS) {
      if (uncoveredPile.isEmpty()) {
        // System.out.println("Uncovered pile is empty."); // Handled by UI
        return false;
      } else {
        Card card = uncoveredPile.peek();
        if (suitPiles.get(suitIndex - NUM_LANES).isEmpty()) {
          if (card.getValue() == 1) { // Ace
            suitPiles.get(suitIndex - NUM_LANES).push(uncoveredPile.pop());
            calculateScore(card, 'P', suitLabel);
            moves++;
            return true;
          } else {
            // System.out.println("Invalid move. Only Aces can start a new pile."); // Handled by UI
            return false;
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
            return true;
          } else {
            // System.out.println("Invalid move. Check the destination pile."); // Handled by UI
            return false;
          }
        }
      }
    } else {
      // System.out.println("Invalid command. Cannot move to a lane."); // Handled by UI
      return false;
    }
  }


  // playGame() method is removed. UI will handle the game loop.

  // displayGameState() method is removed. UI will handle displaying.

  public boolean drawCard() {
    if (!drawPile.isEmpty()) {
      Card card = drawPile.pop();
      uncoveredPile.push(card);
      moves++;
      return true;
    } else {
      // System.out.println("Draw pile is empty. Cannot draw a card."); // Handled by UI
      return false;
    }
  }

  public boolean moveCard(String command) {
    if (command == null || command.length() != 2) return false; // Basic validation
    char fromLabel = command.charAt(0);
    char toLabel = command.charAt(1);
    int fromIndex = getLabelIndex(fromLabel);
    int toIndex = getLabelIndex(toLabel);

    if (fromIndex != -1 && toIndex != -1) {
      if (fromLabel == 'P') { // Moving from Uncovered Pile
        // Special handling if moving from Uncovered Pile ('P') to a Lane ('1'-'7')
        if (toLabel >= '1' && toLabel <= '7') {
            if (uncoveredPile.isEmpty()) return false;
            Card cardToMove = uncoveredPile.peek();
            if (canMoveCardToLane(cardToMove, toIndex)) {
                lanes.get(toIndex).push(uncoveredPile.pop());
                // calculateScore(cardToMove, fromLabel, toLabel); // Score for P to Lane?
                moves++;
                return true;
            }
            return false;
        } else { // Moving from Uncovered Pile ('P') to Suit Pile ('D', 'H', 'C', 'S')
            return moveUncoveredCardToSuit(toLabel);
        }
      } else if (fromLabel >= '1' && fromLabel <= '7') { // Moving from a Lane
        if (lanes.get(fromIndex).isEmpty()) return false;
        Card card = lanes.get(fromIndex).peek();

        // Moving from Lane to Suit Pile
        if (toLabel >= 'D' && toLabel <= 'S') {
            int suitPileIndex = getLabelIndex(toLabel) - NUM_LANES;
            if (suitPiles.get(suitPileIndex).isEmpty()) {
                if (card.getValue() == 1) { // Ace
                    suitPiles.get(suitPileIndex).push(lanes.get(fromIndex).pop());
                    calculateScore(card, fromLabel, toLabel);
                    moves++;
                    return true;
                }
                return false;
            } else {
                Card topSuitCard = suitPiles.get(suitPileIndex).peek();
                if (topSuitCard.isOneValueHigher(card) && topSuitCard.getSuit() == card.getSuit()) {
                    suitPiles.get(suitPileIndex).push(lanes.get(fromIndex).pop());
                    calculateScore(card, fromLabel, toLabel);
                    moves++;
                    return true;
                }
                return false;
            }
        }
        // Moving from Lane to Lane
        else if (toLabel >= '1' && toLabel <= '7') {
            if (canMoveCardToLane(card, toIndex)) {
                lanes.get(toIndex).push(lanes.get(fromIndex).pop());
                // Uncover card below if any
                if (!lanes.get(fromIndex).isEmpty() && !lanes.get(fromIndex).peek().isFaceUp()) {
                    lanes.get(fromIndex).peek().setFaceUp(true); // Assuming Card has faceUp property
                }
                calculateScore(card, fromLabel, toLabel);
                moves++;
                return true;
            }
            return false;
        }
      }
    }
    // System.out.println("Invalid labels or move logic."); // Handled by UI
    return false;
  }

  // Renamed from canMoveCard for clarity, as it's specifically for lane-to-lane or P-to-lane
  private boolean canMoveCardToLane(Card card, int toLaneIndex) {
    if (lanes.get(toLaneIndex).isEmpty()) {
      return card.getValue() == 13; // Only Kings can start a new empty lane pile
    } else {
      Card topCard = lanes.get(toLaneIndex).peek();
      // Card must be face up to be moved onto
      if (!topCard.isFaceUp()) return false; // Assuming Card has isFaceUp
      return topCard.isOneValueHigher(card) && topCard.isOppositeColor(card);
    }
  }


  public boolean moveMultipleCards(String command) {
    if (command == null || command.length() != 3) return false; // Basic validation
    char fromLabel = command.charAt(0);
    char toLabel = command.charAt(1);
    int number;
    try {
        number = Character.getNumericValue(command.charAt(2));
    } catch (NumberFormatException e) {
        return false; // Invalid number
    }
    if (number <=0) return false;


    int fromIndex = getLabelIndex(fromLabel);
    int toIndex = getLabelIndex(toLabel);

    // Can only move multiple cards between lanes
    if (fromIndex != -1 && toIndex != -1 && (fromLabel >= '1' && fromLabel <= '7') && (toLabel >= '1' && toLabel <= '7')) {
      if (lanes.get(fromIndex).size() >= number) {
        // Check if the cards to be moved form a valid sequence and if the bottom card can be moved
        Stack<Card> cardsToMoveStack = new Stack<>();
        for (int i = 0; i < number; i++) {
            // Ensure cards are face up and form a descending, alternating color sequence
            Card currentCard = lanes.get(fromIndex).get(lanes.get(fromIndex).size() - number + i);
            if (!currentCard.isFaceUp()) return false; // Assuming Card has isFaceUp
            if (i > 0) {
                Card previousCard = cardsToMoveStack.peek();
                if (!(previousCard.isOneValueHigher(currentCard) && previousCard.isOppositeColor(currentCard))) {
                    return false; // Not a valid sequence to move
                }
            }
            cardsToMoveStack.push(currentCard);
        }

        Card bottomCardToMove = cardsToMoveStack.firstElement(); // The first card that will land on the new pile

        if (canMoveCardToLane(bottomCardToMove, toIndex)) {
          // Temporarily remove cards from source to move them
          List<Card> tempHolding = new ArrayList<>();
          for(int i=0; i<number; i++) {
              tempHolding.add(lanes.get(fromIndex).pop());
          }
          Collections.reverse(tempHolding); // Ensure correct order for pushing

          for (Card card : tempHolding) {
            lanes.get(toIndex).push(card);
            // Score for each card moved? Or once for the move? Let's assume once for the move.
          }
          // Uncover card below if any
          if (!lanes.get(fromIndex).isEmpty() && !lanes.get(fromIndex).peek().isFaceUp()) {
              lanes.get(fromIndex).peek().setFaceUp(true); // Assuming Card has faceUp property
          }
          calculateScore(bottomCardToMove, fromLabel, toLabel); // Score based on the primary card moved
          moves++;
          return true;
        } else {
          // System.out.println("Invalid move. Check the destination pile."); // Handled by UI
          return false;
        }
      } else {
        // System.out.println("Not enough cards in the source lane."); // Handled by UI
        return false;
      }
    } else {
      // System.out.println("Invalid labels or multiple cards can only be moved between lanes."); // Handled by UI
      return false;
    }
  }


  // This method's name was fine, but its usage within moveMultipleCards needs care.
  // It validates if a *list* of cards (presumably already validated as a sequence)
  // can be placed on a target. The current moveMultipleCards validates sequence internally.
  // For simplicity, the canMoveCards(List<Card> cards, int toIndex) can be kept if
  // moveMultipleCards is refactored to extract the list first.
  // However, the provided moveMultipleCards refactor above does validation differently.
  // Let's keep the single card validation `canMoveCardToLane` as the primary one for lanes.


  // Utility method, still relevant for internal logic
  public int getLabelIndex(char label) {
    if (label == 'P') {
      return NUM_LANES; // Represents the uncovered pile for indexing logic
    } else if (label >= '1' && label <= '7') {
      return Character.getNumericValue(label) - 1; // Lane index 0-6
    } else if (label >= 'D' && label <= 'S') { // Suit piles
      // Find index in Card.SUIT_LABELS and add offset
      for (int i = 0; i < Card.SUIT_LABELS.length; i++) {
          if (Card.SUIT_LABELS[i].charAt(0) == label) {
              return NUM_LANES + i; // Suit pile index (e.g., D=7, H=8, C=9, S=10 if NUM_LANES=7)
          }
      }
    }
    return -1; // Invalid label
  }


  private void calculateScore(Card card, char fromLabel, char toLabel) {
    // Logic remains the same, called internally
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

  public boolean isGameOver() {
    // Check if all suit piles are full
    for (Stack<Card> suitPile : suitPiles) {
      if (suitPile.size() < NUM_CARDS_PER_SUIT) {
        return false;
      }
    }
    // Additionally, for a true win, all lanes should ideally be empty or contain only face-down cards,
    // and draw/uncovered piles should be empty.
    // The original logic only checks suit piles, which signifies a win state.
    return true;
  }

  // main() method is removed from here.
}

// Card class remains largely the same, but we might add faceUp status for tableau piles
class Card {
    public static final String[] SUIT_LABELS = {"D", "H", "C", "S"}; // Diamonds, Hearts, Clubs, Spades
    // To match common Solitaire: D, H are red; C, S are black
    // D=0, H=1 (Red)
    // C=2, S=3 (Black)
    private int suit; // 0:D, 1:H, 2:C, 3:S
    private int value; // 1(Ace) to 13(King)
    private boolean faceUp = false; // Solitaire cards in lanes can be face down

    public Card(int suit, int value) {
        this.suit = suit;
        this.value = value;
    }
    public Card(int suit, int value, boolean faceUp) {
        this.suit = suit;
        this.value = value;
        this.faceUp = faceUp;
    }


    public int getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

    public boolean isFaceUp() { return faceUp; }
    public void setFaceUp(boolean faceUp) { this.faceUp = faceUp; }

    // Returns suit character e.g. 'D', 'H', 'C', 'S'
    public char getSuitLabel() {
        return SUIT_LABELS[suit].charAt(0);
    }

    // Returns rank string e.g. "A", "2", ..., "K"
    public String getValueLabel() {
        if (value >= 2 && value <= 10) return String.valueOf(value);
        switch (value) {
            case 1: return "A";
            case 11: return "J";
            case 12: return "Q";
            case 13: return "K";
            default: return "?";
        }
    }

    @Override
    public String toString() {
        if (!faceUp) return "[XX]"; // Or some other representation for face-down
        return getValueLabel() + getSuitLabel();
    }

    public boolean isOneValueHigher(Card otherCardToPlaceBelow) {
        // 'this' card is the one on the pile, 'otherCardToPlaceBelow' is the one being moved.
        // So, this.value should be one higher than otherCardToPlaceBelow.value
        // e.g. this=King(13), other=Queen(12) -> 13 - 12 == 1. (Incorrect logic for Solitaire lane)
        // For Solitaire lanes: the card on the pile (this) must be one HIGHER than the card being placed on it (otherCardToPlaceBelow)
        // No, other way: if moving card 'C2' onto 'C1', C1.value must be C2.value + 1
        // Correct: if 'otherCardToPlaceBelow' (e.g. 5H) is placed on 'this' card (e.g. 6S),
        // then this.value (6) must be otherCardToPlaceBelow.value (5) + 1.
        return this.value == otherCardToPlaceBelow.value + 1;
    }

    public boolean isOppositeColor(Card other) {
        // D=0, H=1 (Red)
        // C=2, S=3 (Black)
        boolean thisIsRed = this.suit < 2;
        boolean otherIsRed = other.getSuit() < 2;
        return thisIsRed != otherIsRed;
    }
}