import java.util.Scanner;

public class QuizApp {
    public static void main(String[] args) {
        // Define some sample questions and answers
        String[] questions = {
            "What is the capital of France?",
            "What is the largest planet in our solar system?",
            "Who wrote Romeo and Juliet?"
        };
        
        String[] answers = {
            "Paris",
            "Jupiter",
            "William Shakespeare"
        };
        
        // Initialize the quiz
        int score = 0;
        Scanner scanner = new Scanner(System.in);
        
        // Iterate through the questions
        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            String userAnswer = scanner.nextLine();
            
            if (userAnswer.equalsIgnoreCase(answers[i])) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer is: " + answers[i] + "\n");
            }
        }
        
        // Display the final score
        System.out.println("Quiz complete! Your score is: " + score + " out of " + questions.length);
        
        // Close the scanner
        scanner.close();
    }
}
