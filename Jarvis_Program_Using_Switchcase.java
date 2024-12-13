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
        // Code to fetch the current weather from an API or any other source
        // Implement your own logic or use external libraries
        return "Sunny";
    }

    private static String setReminder() {
        // Code to set a reminder, you can use libraries like java.util.Timer or external libraries
        // Implement your own logic based on the requirements
        return "Meeting at 5 PM";
    }

    private static String getRandomQuote() {
        // Code to fetch a random quote from an API or a predefined list
        // Implement your own logic or use external libraries
        return "Coder's Never Quit..";
    }

    private static String getLatestNews() {
        // Code to fetch the latest news from an API or any other source
        // Implement your own logic or use external libraries
        return "Latest News:- Mercedes drivers can soon turn to ChatGPT for Voice Control...";
    }

    private static String getJoke() {
        // Code to fetch a random joke from an API or a predefined list
        // Implement your own logic or use external libraries
        return "What's the best thing about Switzerland?........I don't know but the flag is a big Plus...";
    }
}
