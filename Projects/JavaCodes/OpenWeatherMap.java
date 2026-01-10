import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherApp {

    public static void main(String[] args) {
        String apiKey = "YOUR_API_KEY"; // Replace with your OpenWeatherMap API key
        String city = "New York"; // Replace with the desired city

        try {
            String apiUrl = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey;
            URL url = new URL(apiUrl);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // Parse and display the weather information
            String weatherData = response.toString();
            System.out.println("Weather Data:");
            System.out.println(weatherData);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
