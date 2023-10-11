import java.util.Scanner;
import java.lang.Math;

public class ScientificCalculator {

    private double firstNumber;
    private double secondNumber;
    private String operation;

    public ScientificCalculator() {
        this.firstNumber = 0.0;
        this.secondNumber = 0.0;
        this.operation = "";
    }

    public void setFirstNumber(double firstNumber) {
        this.firstNumber = firstNumber;
    }

    public void setSecondNumber(double secondNumber) {
        this.secondNumber = secondNumber;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public double calculate() {
        double result = 0.0;

        switch (this.operation) {
            case "+":
                result = this.firstNumber + this.secondNumber;
                break;
            case "-":
                result = this.firstNumber - this.secondNumber;
                break;
            case "*":
                result = this.firstNumber * this.secondNumber;
                break;
            case "/":
                result = this.firstNumber / this.secondNumber;
                break;
            case "^":
                result = Math.pow(this.firstNumber, this.secondNumber);
                break;
            case "sqrt":
                result = Math.sqrt(this.firstNumber);
                break;
            case "sin":
                result = Math.sin(this.firstNumber);
                break;
            case "cos":
                result = Math.cos(this.firstNumber);
                break;
            case "tan":
                result = Math.tan(this.firstNumber);
                break;
            default:
                throw new IllegalArgumentException("Invalid operation");
        }

        return result;
    }

    public static void main(String[] args) {
        ScientificCalculator calculator = new ScientificCalculator();

        // Get the user input
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the scientific calculator!");

        while (true) {
            System.out.println("Enter the first number: ");
            calculator.setFirstNumber(scanner.nextDouble());

            System.out.println("Enter the second number: ");
            calculator.setSecondNumber(scanner.nextDouble());

            System.out.println("Enter the operation (+, -, *, /, ^, sqrt, sin, cos, tan): ");
            calculator.setOperation(scanner.next());

            // Calculate the result
            double result = calculator.calculate();

            // Display the result
            System.out.println("The result is: " + result);

            System.out.println("Do you want to continue? (y/n)");
            String answer = scanner.next();

            if (answer.equalsIgnoreCase("n")) {
                break;
            }
        }

        scanner.close();
    }
}
