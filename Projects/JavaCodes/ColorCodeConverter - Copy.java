import java.util.Scanner;

public class ColorCodeConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Color Code Converter");
        System.out.println("1. RGB to HEX");
        System.out.println("2. HEX to RGB");
        System.out.print("Enter your choice (1 or 2): ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        if (choice == 1) {
            System.out.print("Enter RGB color (e.g., 255, 0, 0): ");
            String rgb = scanner.nextLine();
            String hex = rgbToHex(rgb);
            System.out.println("HEX color: " + hex);
        } else if (choice == 2) {
            System.out.print("Enter HEX color (e.g., #FF0000): ");
            String hex = scanner.nextLine();
            String rgb = hexToRgb(hex);
            System.out.println("RGB color: " + rgb);
        } else {
            System.out.println("Invalid choice. Please select 1 or 2.");
        }
    }

    public static String rgbToHex(String rgb) {
        String[] values = rgb.split(",");
        if (values.length != 3) {
            return "Invalid RGB format";
        }
        int r = Integer.parseInt(values[0]);
        int g = Integer.parseInt(values[1]);
        int b = Integer.parseInt(values[2]);

        return String.format("#%02X%02X%02X", r, g, b);
    }

    public static String hexToRgb(String hex) {
        if (hex.startsWith("#")) {
            hex = hex.substring(1);
        }

        int intValue = Integer.parseInt(hex, 16);
        int r = (intValue >> 16) & 0xFF;
        int g = (intValue >> 8) & 0xFF;
        int b = intValue & 0xFF;

        return r + ", " + g + ", " + b;
    }
}
