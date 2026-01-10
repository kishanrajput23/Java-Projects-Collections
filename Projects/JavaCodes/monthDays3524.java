import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class monthDays3524 {
    public static void main(String[] args) {
        System.out.println("2021503524 - Mugundh J B");
        System.out.println("Date: " + LocalDate.now() + " Time: " + LocalTime.now());
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the year: ");
        int year = scanner.nextInt(); // Getting the year as input

        while (year < 1000 || year > 9999) { // Checking if the entered year is valid
            System.out.printf("Invalid input for the year!\nEnter the year again: ");
            year = scanner.nextInt(); // Getting input again if input is invalid
        }
        System.out.print("Enter the month (1 to 12): ");
            int month = scanner.nextInt(); // Getting the month as input

            int daysInMonth = 0; // Variable to store no of days in that month
            switch(month){
                case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                    daysInMonth = 31;
                    break;
                case 4: case 6: case 9: case 11:
                    daysInMonth = 30;
                    break;
                case 2:
                    if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                        daysInMonth = 29; // Leap year
                    } else {
                        daysInMonth = 28; // Non-leap year
                    }
                    break;
                default:
                    System.out.println("Invalid month!");
                    return;
            }
            System.out.printf("Number of days in %d th month: %d", month,  daysInMonth);
    }
}
