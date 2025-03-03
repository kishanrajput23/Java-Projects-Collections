import java.util.Scanner;

public class CalorieCalculator {
    
    // Constants for BMR formula coefficients and activity multipliers
    private static final double MALE_BMR_CONSTANT = 88.362;
    private static final double FEMALE_BMR_CONSTANT = 447.593;
    private static final double MALE_WEIGHT_COEFFICIENT = 13.397;
    private static final double FEMALE_WEIGHT_COEFFICIENT = 9.247;
    private static final double MALE_HEIGHT_COEFFICIENT = 4.799;
    private static final double FEMALE_HEIGHT_COEFFICIENT = 3.098;
    private static final double MALE_AGE_COEFFICIENT = 5.677;
    private static final double FEMALE_AGE_COEFFICIENT = 4.330;

    private static final double SEDENTARY_MULTIPLIER = 1.2;
    private static final double MODERATE_MULTIPLIER = 1.55;
    private static final double ACTIVE_MULTIPLIER = 1.725;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for information
        System.out.println("Calorie Calculator");
        
        System.out.print("Enter your gender (M/F): ");
        String gender = scanner.nextLine().trim().toUpperCase();

        if (!gender.equals("M") && !gender.equals("F")) {
            System.out.println("Invalid gender input. Please enter 'M' or 'F'.");
            return;
        }

        System.out.print("Enter your age (in years): ");
        int age = getValidIntInput(scanner);
        
        System.out.print("Enter your weight (in kilograms): ");
        double weight = getValidDoubleInput(scanner);
        
        System.out.print("Enter your height (in centimeters): ");
        double height = getValidDoubleInput(scanner);

        System.out.print("Enter your activity level (sedentary/moderate/active): ");
        String activityLevel = scanner.nextLine().trim().toLowerCase();

        if (!isValidActivityLevel(activityLevel)) {
            System.out.println("Invalid activity level input. Please choose 'sedentary', 'moderate', or 'active'.");
            return;
        }

        // Calculate BMR
        double bmr = calculateBMR(gender, age, weight, height);

        // Calculate daily calorie needs based on activity level
        double calorieNeeds = calculateCalorieNeeds(bmr, activityLevel);

        // Display the results
        System.out.printf("Your Basal Metabolic Rate (BMR) is: %.0f calories per day.\n", bmr);
        System.out.printf("Your estimated daily calorie needs are: %.0f calories per day.\n", calorieNeeds);

        scanner.close();
    }

    // Method to get a valid integer input from the user
    private static int getValidIntInput(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid integer.");
            scanner.next();  // Clear invalid input
        }
        return scanner.nextInt();
    }

    // Method to get a valid double input from the user
    private static double getValidDoubleInput(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.next();  // Clear invalid input
        }
        return scanner.nextDouble();
    }

    // Method to check if the activity level is valid
    private static boolean isValidActivityLevel(String activityLevel) {
        return activityLevel.equals("sedentary") || activityLevel.equals("moderate") || activityLevel.equals("active");
    }

    // Method to calculate BMR
    private static double calculateBMR(String gender, int age, double weight, double height) {
        double bmr;
        if (gender.equals("M")) {
            bmr = MALE_BMR_CONSTANT + (MALE_WEIGHT_COEFFICIENT * weight) + (MALE_HEIGHT_COEFFICIENT * height) - (MALE_AGE_COEFFICIENT * age);
        } else {
            bmr = FEMALE_BMR_CONSTANT + (FEMALE_WEIGHT_COEFFICIENT * weight) + (FEMALE_HEIGHT_COEFFICIENT * height) - (FEMALE_AGE_COEFFICIENT * age);
        }
        return bmr;
    }

    // Method to calculate calorie needs based on activity level
    private static double calculateCalorieNeeds(double bmr, String activityLevel) {
        double calorieNeeds;
        switch (activityLevel) {
            case "sedentary":
                calorieNeeds = bmr * SEDENTARY_MULTIPLIER;
                break;
            case "moderate":
                calorieNeeds = bmr * MODERATE_MULTIPLIER;
                break;
            case "active":
                calorieNeeds = bmr * ACTIVE_MULTIPLIER;
                break;
            default:
                throw new IllegalArgumentException("Invalid activity level");
        }
        return calorieNeeds;
    }
}
