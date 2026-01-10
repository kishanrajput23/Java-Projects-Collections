package PasswordEvaluator;

import java.io.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Random;

/**
 * A utility class for evaluating the strength of passwords
 * and suggesting new secure passwords if needed.
 */
public class PasswordStrengthEvaluator {

    private static final String LETTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    /**
     * Evaluates the strength of a given password based on multiple criteria:
     * - Length between 8 and 30 characters
     * - Contains both uppercase and lowercase letters
     * - Contains special characters (@, &, !)
     * - Is not a common password from a predefined list
     *
     * @param password the password to evaluate
     * @return a string representing the strength level (MAX, MIN, COMMON)
     * @throws IOException if there is a problem reading the common passwords file
     */
    public static String evaluatePassword(String password) throws IOException {

        boolean hasUppercase = password.matches(".*[A-Z].*");
        boolean hasLowercase = password.matches(".*[a-z].*");
        boolean hasSpecialChar = password.contains("@") || password.contains("&") || password.contains("!");
        int length = password.length();

        boolean isCommon = isCommon(password);

        if (!isCommon && length >= 8 && length < 30 && hasUppercase && hasLowercase && hasSpecialChar) {
            return "Password strength level: MAX";
        }

        if (length < 8 || !hasUppercase || !hasLowercase || !hasSpecialChar || length >= 30) {
            suggetsPassword(12);
            return "Password strength level: MIN";
        }

        if (isCommon) {
            return "Password strength level: COMMON" + suggetsPassword(12);
        }

        return "Unable to determine password strength.";
    }


    /**
     * Checks whether a given password appears in a list of the most common passwords,
     * retrieved from a remote public file on GitHub. The comparison is exact, line by line.
     *
     * @param password the password to check
     * @return true if the password is exactly matched in the list, false otherwise
     * @throws RuntimeException if there is an error reading the remote password file
     */
    public static boolean isCommon(String password) {
        String fileUrl = "https://raw.githubusercontent.com/danielmiessler/SecLists/refs/heads/master/Passwords/Common-Credentials/10-million-password-list-top-1000000.txt";

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(fileUrl))
                    .build();

            HttpResponse<InputStream> response = client.send(request, HttpResponse.BodyHandlers.ofInputStream());

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(response.body()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.equals(password)) {
                        return true;
                    }
                }
            }

        } catch (Exception e) {
            throw new RuntimeException("Error reading the common passwords file.", e);
        }

        return false;
    }





    /**
     * Suggests a secure random password of a specified length,
     * containing only uppercase and lowercase letters.
     *
     * If the requested length is less than 8, a password with 8 characters is suggested
     * and a warning message is returned.
     *
     * @param length the desired length of the suggested password
     * @return a suggested password or a warning message if the length is too short
     */
    private static String suggetsPassword(int length) {
        Random random = new Random();
        StringBuilder password = new StringBuilder();
        StringBuilder provisionallyPassword = new StringBuilder();

        if (length >= 8) {
            for (int i = 0; i < length; i++) {
                int index = random.nextInt(LETTERS.length());
                password.append(LETTERS.charAt(index));
            }
            return password.toString();
        } else {
            for (int i = 0; i < 8; i++) {
                int index = random.nextInt(LETTERS.length());
                provisionallyPassword.append(LETTERS.charAt(index));
            }
            return "Length must be between 8 and 30 characters. Suggested password with 8 characters: " + provisionallyPassword.toString();
        }
    }
}