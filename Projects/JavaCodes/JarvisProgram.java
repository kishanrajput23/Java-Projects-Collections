import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;
public class JarvisProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command;
        System.out.println("Welcome to Jarvis Program!");
        do {
            System.out.print("Enter a command: ");
            command = scanner.nextLine();
            switch (command.toLowerCase()) {
                case "hello":
                    System.out.println("Hello! How can I assist you?");
                    break;
                case "time":
                    LocalTime time = LocalTime.now();
                    System.out.println("The current time is: " + time);
                    break;
                case "date":
                    LocalDate date = LocalDate.now();
                    System.out.println("Today's date is: " + date);
                    break;
                case "weather":
                    String weather = getWeather();
                    System.out.println("The weather today is: " + weather);
                    break;
                case "reminder":
                    String reminder = setReminder();
                    System.out.println("Reminder set: " + reminder);
                    break;
                case "quote":
                    String quote = getRandomQuote();
                    System.out.println("Here's a quote for you: " + quote);
                    break;
                case "news":
                    String news = getLatestNews();
                    System.out.println("Here's the latest news: " + news);
                    break;
                case "joke":
                    String joke = getJoke();
                    System.out.println("Here's a joke for you: " + joke);
                    break;
                case "exit":
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Sorry, I don't understand that command.");
                    break;
            }
        } while (!command.equalsIgnoreCase("exit"));
        scanner.close();
    }
    private static String getWeather() {
        return "Sunny";
    }
    private static String setReminder() {
        return "Meeting at 5 PM";
    }
    private static String getRandomQuote() {
        return "Coder's Never Quit..";
    }
    private static String getLatestNews() {
        return "No news available.";
    }
    private static String getJoke() {
        return "Why do programmers prefer dark mode? Because light attracts bugs!";
    }
}
