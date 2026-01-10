package PasswordEvaluator;

import java.io.IOException;
import java.util.Scanner;

public class TestPasswordEvaluator {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a password to evaluate:");
        String input = scanner.nextLine();

        try {
            String result = PasswordStrengthEvaluator.evaluatePassword(input);
            System.out.println(result);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}


