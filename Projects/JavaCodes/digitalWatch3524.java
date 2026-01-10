import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;
public class digitalWatch3524 {
    public static void main(String[] args) {
        System.out.println("2021503524 - Mugundh J B");
        System.out.println("Date: " + LocalDate.now() + " Time: " + LocalTime.now());
        Scanner scanner = new Scanner(System.in);
        // Prompt the user for input
        System.out.print("Input day (Mon, Tue, Wed, Thu, Fri, Sat, Sun): ");
        String day = scanner.nextLine();
        System.out.print("Input hour (24-hour): ");
        int hour = scanner.nextInt();
        System.out.print("Input minute: ");
        int minute = scanner.nextInt();
        System.out.print("Input second: ");
        int second = scanner.nextInt();
        // Validating day input
        if (!isValidDay(day)) {
            System.out.println("Invalid day input!");
        } else if (hour < 0 || hour > 23 || minute < 0 || minute > 59 || second < 0 || second > 59) {
            System.out.println("Invalid time input!");
        } else {
            // Advancing time by one second
            second++;
            if (second == 60) {
                second = 0;
                minute++;
                if (minute == 60) {
                    minute = 0;
                    hour++;
                    if (hour == 24) {
                        hour = 0;
                        day = getNextDay(day);
                    }
                }
            }
            // Displaying the new time
            System.out.println("New time: " + day + " " + hour + " " + minute + " " + second);
        }
    }
    // Checking if the given day is valid
    public static boolean isValidDay(String day) {
        return day.equals("Mon") || day.equals("Tue") || day.equals("Wed") ||
                day.equals("Thu") || day.equals("Fri") || day.equals("Sat") || day.equals("Sun");
    }
    // Getting the next day
    public static String getNextDay(String day) {
        if (day.equals("Sun")) return "Mon";
        if (day.equals("Mon")) return "Tue";
        if (day.equals("Tue")) return "Wed";
        if (day.equals("Wed")) return "Thu";
        if (day.equals("Thu")) return "Fri";
        if (day.equals("Fri")) return "Sat";
        if (day.equals("Sat")) return "Sun";
        return "";
    }
}
