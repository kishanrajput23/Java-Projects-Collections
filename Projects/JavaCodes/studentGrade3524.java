import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class studentGrade3524 {
    public static void main(String[] args) {
        System.out.println("2021503524 - Mugundh J B");
        System.out.println("Date: " + LocalDate.now() + " Time: " + LocalTime.now());
        // Create a Scanner to read user input
        Scanner in = new Scanner(System.in);
        // Prompt the user for the number of subjects
        System.out.print("Enter no of subjects: ");
        int n = in.nextInt();
        // Consume newline character left in buffer
        String buff = in.nextLine();
        // Initialize an array to store marks for each subject
        int[] arr = new int[n];
        // Prompt the user to enter marks for each subject and validate input
        System.out.println("Enter the marks: ");
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            if (arr[i] < 0 || arr[i] > 100) {
                System.out.println("Invalid input! Enter again: ");
                arr[i] = in.nextInt();
            }
        }
        // Determine the grade for each subject based on marks and display it
        for (int i = 0; i < n; i++) {
            if (arr[i] >= 90 && arr[i] <= 100)
                System.out.printf("Grade of subject %d = %s\n", i + 1, "O");
            else if (arr[i] >= 80 && arr[i] <= 89)
                System.out.printf("Grade of subject %d = %s\n", i + 1, "A+");
            else if (arr[i] >= 70 && arr[i] <= 79)
                System.out.printf("Grade of subject %d = %s\n", i + 1, "A");
            else if (arr[i] >= 60 && arr[i] <= 69)
                System.out.printf("Grade of subject %d = %s\n", i + 1, "B+");
            else if (arr[i] >= 50 && arr[i] <= 59)
                System.out.printf("Grade of subject %d = %s\n", i + 1, "B");
            else
                System.out.printf("Grade of subject %d = %s", i + 1, "U");
        }
    }
}
