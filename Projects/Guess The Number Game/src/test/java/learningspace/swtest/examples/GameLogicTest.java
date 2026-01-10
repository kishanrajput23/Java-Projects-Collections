import learningspace.swtest.examples.GameLogic;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameLogicTest {

    @Test
    void testCorrectGuess() {
        GameLogic logic = new GameLogic();
        assertEquals("Correct!", logic.checkGuess(7, 7));
    }

    @Test
    void testTooLow() {
        GameLogic logic = new GameLogic();
        assertEquals("Too low!", logic.checkGuess(5, 7));
    }

    @Test
    void testTooHigh() {
        GameLogic logic = new GameLogic();
        assertEquals("Too high!", logic.checkGuess(9, 7));
    }
}
