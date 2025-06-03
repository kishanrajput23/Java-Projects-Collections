// Responsible for displaying the calculation results

public class ResultDisplay {
    public void displayResults(double bmr, double calorieNeeds) {
        System.out.printf("Your Basal Metabolic Rate (BMR) is: %.0f calories per day.\n", bmr);
        System.out.printf("Your estimated daily calorie needs are: %.0f calories per day.\n", calorieNeeds);
    }
}