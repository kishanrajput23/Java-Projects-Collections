import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class WebsiteStatusChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the website URL to check: ");
        String urlToCheck = scanner.nextLine();

        try {
            int statusCode = checkWebsiteStatus(urlToCheck);

            if (statusCode >= 200 && statusCode < 400) {
                System.out.println("Website is alive (HTTP Status Code: " + statusCode + ")");
            } else {
                System.out.println("Website is down (HTTP Status Code: " + statusCode + ")");
            }
        } catch (IOException e) {
            System.err.println("Error checking website status: " + e.getMessage());
        }
    }

    public static int checkWebsiteStatus(String url) throws IOException {
        URL websiteURL = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) websiteURL.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();
        int statusCode = connection.getResponseCode();
        connection.disconnect();

        return statusCode;
    }
}
