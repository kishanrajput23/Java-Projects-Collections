import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class headsTails3524 {
    public static void main(String[] args) {
        System.out.println("2021503524 - Mugundh J B");
        System.out.println("Date: " + LocalDate.now() + " Time: " + LocalTime.now());

        // Create a random number generator
        Random rand = new Random();

        // Generate a random number (0 or 1)
        int num = rand.nextInt(2);

        // Create a Scanner to read user input
        Scanner in = new Scanner(System.in);

        // Prompt the user for their choice
        System.out.print("Enter your choice (h / H / t / T): ");
        char choice = in.next().charAt(0);

        // Validate user's choice
        while (choice != 'h' && choice != 'H' && choice != 't' && choice != 'T') {
            System.out.printf("Invalid choice. Enter your choice (h / H / t / T): ");
            choice = in.next().charAt(0);
        }

        // Display the random value generated
        System.out.printf("Random value = %d\n", num);

        // Check if the user won or lost based on their choice and the random value
        if (((choice == 'h' || choice == 'H') && num == 1) || ((choice == 't' || choice == 'T') && num == 0))
            System.out.print("You won!");
        else
            System.out.print("You lose!");

    }
}
