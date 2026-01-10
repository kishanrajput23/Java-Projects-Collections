import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.Key;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Scanner;

public class FileEncryptionDecryptionTool {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the file path: ");
        String filePath = scanner.nextLine();

        System.out.print("Enter the encryption key (16 characters): ");
        String encryptionKey = scanner.nextLine();

        try {
            byte[] key = encryptionKey.getBytes();
            key = Arrays.copyOf(key, 16); // Ensure the key is exactly 16 bytes

            SecretKey secretKey = new SecretKeySpec(key, "AES");
            Cipher cipher = Cipher.getInstance("AES");
            
            // Encrypt the file
            byte[] fileData = Files.readAllBytes(Paths.get(filePath));
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encryptedData = cipher.doFinal(fileData);
            
            Path encryptedFilePath = Paths.get(filePath + ".enc");
            Files.write(encryptedFilePath, encryptedData, StandardOpenOption.CREATE);

            System.out.println("File encrypted successfully to: " + encryptedFilePath);

            // Decrypt the file
            System.out.print("Do you want to decrypt the file (Y/N)? ");
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("Y")) {
                cipher.init(Cipher.DECRYPT_MODE, secretKey);
                byte[] decryptedData = cipher.doFinal(encryptedData);
                Path decryptedFilePath = Paths.get(filePath + ".dec");
                Files.write(decryptedFilePath, decryptedData, StandardOpenOption.CREATE);

                System.out.println("File decrypted successfully to: " + decryptedFilePath);
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
