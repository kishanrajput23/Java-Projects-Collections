import static org.junit.Assert.*;
import java.io.*;
import org.junit.Test;

public class FibonacciOutputTest {

    @Test
    public void testConsoleOutputFibonacci() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        Fibonacci_series.main(new String[]{});

        System.setOut(originalOut);

        String expectedOutput = "0 1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597 2584 4181";
        String actualOutput = outContent.toString().trim();

        assertEquals(expectedOutput, actualOutput);
    }
}
