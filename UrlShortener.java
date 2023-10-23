import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class UrlShortener {
    private Map<String, String> urlMap = new HashMap<>();
    private static final String BASE_URL = "http://short.url/";

    public String shortenUrl(String originalUrl) {
        String shortUrl = generateShortUrl(originalUrl);
        urlMap.put(shortUrl, originalUrl);
        return BASE_URL + shortUrl;
    }

    public String expandUrl(String shortUrl) {
        String shortKey = shortUrl.substring(BASE_URL.length());
        return urlMap.get(shortKey);
    }

    private String generateShortUrl(String originalUrl) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(originalUrl.getBytes());

            StringBuilder shortUrl = new StringBuilder();
            Random random = new Random();

            for (int i = 0; i < 6; i++) {
                int index = random.nextInt(digest.length);
                shortUrl.append(String.format("%02x", digest[index]));
            }

            return shortUrl.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        UrlShortener urlShortener = new UrlShortener();

        String longUrl = "https://www.example.com/some/long/url";
        String shortUrl = urlShortener.shortenUrl(longUrl);
        System.out.println("Short URL: " + shortUrl);

        String expandedUrl = urlShortener.expandUrl(shortUrl);
        System.out.println("Expanded URL: " + expandedUrl);
    }
}
