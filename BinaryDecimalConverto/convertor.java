import java.util.Scanner;

public class BinaryDecimalConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Binary to Decimal and Decimal to Binary Converter");
        System.out.print("Enter 1 to convert Binary to Decimal or 2 to convert Decimal to Binary: ");
        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.print("Enter a binary number: ");
            String binaryInput = scanner.next();
            int decimalResult = binaryToDecimal(binaryInput);
            System.out.println("Decimal result: " + decimalResult);
        } else if (choice == 2) {
            System.out.print("Enter a decimal number: ");
            int decimalInput = scanner.nextInt();
            String binaryResult = decimalToBinary(decimalInput);
            System.out.println("Binary result: " + binaryResult);
        } else {
            System.out.println("Invalid choice. Please enter 1 for Binary to Decimal or 2 for Decimal to Binary.");
        }
    }

    public static int binaryToDecimal(String binary) {
        return Integer.parseInt(binary, 2);
    }

    public static String decimalToBinary(int decimal) {
        return Integer.toBinaryString(decimal);
    }
}
