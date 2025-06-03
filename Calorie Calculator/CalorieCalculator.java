// Handles the business logic for calorie calculations

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

    public double calculateBMR(UserData userData) {
        double bmr;
        if (userData.getGender().equals("M")) {
            bmr = MALE_BMR_CONSTANT + 
                  (MALE_WEIGHT_COEFFICIENT * userData.getWeight()) + 
                  (MALE_HEIGHT_COEFFICIENT * userData.getHeight()) - 
                  (MALE_AGE_COEFFICIENT * userData.getAge());
        } else { // Assumes "F" as gender has been validated by input handler
            bmr = FEMALE_BMR_CONSTANT + 
                  (FEMALE_WEIGHT_COEFFICIENT * userData.getWeight()) + 
                  (FEMALE_HEIGHT_COEFFICIENT * userData.getHeight()) - 
                  (FEMALE_AGE_COEFFICIENT * userData.getAge());
        }
        return bmr;
    }

    public double calculateDailyCalorieNeeds(double bmr, String activityLevel) {
        // Domain validation for activityLevel could be here if not handled before
        // For this example, assuming activityLevel is already validated
        double calorieNeeds;
        switch (activityLevel.toLowerCase()) {
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
                // This case should ideally not be reached if input is validated properly
                throw new IllegalArgumentException("Invalid activity level: " + activityLevel);
        }
        return calorieNeeds;
    }
}
