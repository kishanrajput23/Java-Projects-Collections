import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class dateTime3524 {
    public static void main(String[] args) {
        System.out.println("2021503524 - Mugundh J B \n");
        LocalDateTime current = LocalDateTime.now(); //"LocalDateTime" is the class
        //"now()" is a method, represent the current date and time
        DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeformat = DateTimeFormatter.ofPattern("HH:mm:ss");
        // ofPattern() is used to format the date in a particular pattern
        String formattedDate = current.format(dateformat);
        System.out.print("Date: " + formattedDate);
        String formattedTime = current.format(timeformat);
        System.out.println(" Time: " + formattedTime);
    }
}