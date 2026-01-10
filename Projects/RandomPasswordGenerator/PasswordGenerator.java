import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public class PasswordGenerator {
    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL = "!@#$%^&*()-_=+[]{}|;:'\",.<>?";

    public static String generatePassword(int length, boolean useUpper, boolean useLower, boolean useDigits, boolean useSpecial) {
        if (length <= 0) {
            throw new IllegalArgumentException("Password length must be greater than 0");
        }

        StringBuilder characters = new StringBuilder();
        if (useUpper) characters.append(UPPER);
        if (useLower) characters.append(LOWER);
        if (useDigits) characters.append(DIGITS);
        if (useSpecial) characters.append(SPECIAL);

        if (characters.length() == 0) {
            throw new IllegalArgumentException("At least one character type (upper, lower, digits, special) must be selected");
        }

        Random random;
        try {
            random = SecureRandom.getInstanceStrong(); // Strong cryptographic random number generator
        } catch (NoSuchAlgorithmException e) {
            random = new SecureRandom();
        }

        StringBuilder password = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            password.append(characters.charAt(randomIndex));
        }

        return password.toString();
    }

    public static void main(String[] args) {
        int length = 12; // Change the desired password length
        boolean useUpper = true;
        boolean useLower = true;
        boolean useDigits = true;
        boolean useSpecial = true;

        String password = generatePassword(length, useUpper, useLower, useDigits, useSpecial);
        System.out.println("Generated Password: " + password);
    }
}
