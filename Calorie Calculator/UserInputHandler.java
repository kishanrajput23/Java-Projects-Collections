import java.util.Scanner;

// Handles user input and basic format validation
public class UserInputHandler {
    private Scanner scanner;

    public UserInputHandler() {
        this.scanner = new Scanner(System.in);
    }

    public UserData gatherUserData() {
        System.out.println("Calorie Calculator");

        String gender = getValidGenderInput();
        int age = getValidIntInput("Enter your age (in years): ");
        double weight = getValidDoubleInput("Enter your weight (in kilograms): ");
        double height = getValidDoubleInput("Enter your height (in centimeters): ");
        String activityLevel = getValidActivityLevelInput();
        
        return new UserData(gender, age, weight, height, activityLevel);
    }

    private String getValidGenderInput() {
        String gender;
        while (true) {
            System.out.print("Enter your gender (M/F): ");
            gender = scanner.nextLine().trim().toUpperCase();
            if (gender.equals("M") || gender.equals("F")) {
                break;
            }
            System.out.println("Invalid gender input. Please enter 'M' or 'F'.");
        }
        return gender;
    }

    private int getValidIntInput(String prompt) {
        int value;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                value = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                if (value > 0) { // Basic validation for age
                    break;
                } else {
                    System.out.println("Invalid input. Please enter a positive integer.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine(); // Clear invalid input
            }
        }
        return value;
    }

    private double getValidDoubleInput(String prompt) {
        double value;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                value = scanner.nextDouble();
                scanner.nextLine(); // Consume newline
                if (value > 0) { // Basic validation for weight/height
                     break;
                } else {
                    System.out.println("Invalid input. Please enter a positive number.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Clear invalid input
            }
        }
        return value;
    }

    private String getValidActivityLevelInput() {
        String activityLevel;
        while (true) {
            System.out.print("Enter your activity level (sedentary/moderate/active): ");
            activityLevel = scanner.nextLine().trim().toLowerCase();
            if (activityLevel.equals("sedentary") || activityLevel.equals("moderate") || activityLevel.equals("active")) {
                break;
            }
            System.out.println("Invalid activity level input. Please choose 'sedentary', 'moderate', or 'active'.");
        }
        return activityLevel;
    }

    public void closeScanner() {
        scanner.close();
    }
}