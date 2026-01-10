import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;
public class Verbalize3524{
    // Arrays to store the verbal representations of units and tens
    private static final String[] units = {
            "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };
    private static final String[] tens = {
            "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };
    public static void main(String[] args) {
        System.out.println("2021503524 - Mugundh J B");
        System.out.println("Date: " + LocalDate.now() + " Time: " + LocalTime.now());
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number between 1 and 9999: ");
        int number = scanner.nextInt();
        // Check for invalid input
        while (number < 1 || number > 9999) {
            System.out.print("Invalid input. Please enter a number between 1 and 9999: ");
            number = scanner.nextInt();
        }
        // Convert the number to its verbal representation
        String verbalized = convertToWords(number);
        System.out.printf("Verbalized form:\n" + verbalized);
    }
    // Convert a number to its verbal representation
    public static String convertToWords(int number) {
        if (number < 20) {
            return units[number]; // Directly use the units array
        } else if (number < 100) {
            return tens[number / 10] + " " + units[number % 10]; // Combine tens and units
        } else if (number < 1000) {
            return units[number / 100] + " Hundred and " + convertToWords(number % 100); // Handling hundreds by recursion
        } else {
            return units[number / 1000] + " Thousand and " + convertToWords(number % 1000); // Handling thousands by recursion
        }
    }
}
