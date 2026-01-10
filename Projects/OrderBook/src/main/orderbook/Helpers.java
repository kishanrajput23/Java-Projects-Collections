import java.io.*;
import java.nio.file.*;

public class Helpers {

    public static void printFileContents(String filePath) {
        try {
            String content = Files.readString(Paths.get(filePath));
            System.out.println(content);
        } catch (IOException e) {
            System.err.println("Unable to open " + filePath);
        }
    }

    public static void printFill(OrderFill fill, int quantity, long startTime, long endTime) {
        double averagePrice = fill.unitsTransacted > 0 ? fill.totalValue / fill.unitsTransacted : 0.0;
        long timeTaken = endTime - startTime;
        System.out.println("Filled "+fill.unitsTransacted+"/"+quantity+" units @ $"+averagePrice+" avg. price in "+timeTaken+" ns");
    }
}
