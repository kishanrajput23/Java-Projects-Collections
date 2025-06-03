// Orchestrates the application flow

public class MainApp {
    public static void main(String[] args) {
        UserInputHandler inputHandler = new UserInputHandler();
        CalorieCalculator calculationService = new CalorieCalculator();
        ResultDisplay resultDisplay = new ResultDisplay();

        // 1. Get user data
        UserData userData = inputHandler.gatherUserData();

        // 2. Perform calculations
        double bmr = calculationService.calculateBMR(userData);
        double dailyCalorieNeeds = calculationService.calculateDailyCalorieNeeds(bmr, userData.getActivityLevel());

        // 3. Display results
        resultDisplay.displayResults(bmr, dailyCalorieNeeds);

        // Clean up resources
        inputHandler.closeScanner();
    }
}