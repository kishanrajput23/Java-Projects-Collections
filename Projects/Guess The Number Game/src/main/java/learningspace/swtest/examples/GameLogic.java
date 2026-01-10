package learningspace.swtest.examples;

public class GameLogic {
    public String checkGuess(int guess, int correctNumber) {
        if (guess == correctNumber) {
            return "Correct!";
        } else if (guess < correctNumber) {
            return "Too low!";
        } else {
            return "Too high!";
        }
    }
}
