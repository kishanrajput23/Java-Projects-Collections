import java.util.Scanner;

public class VelocityCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Velocity Calculator");
        System.out.print("Enter initial position (meters): ");
        double initialPosition = scanner.nextDouble();

        System.out.print("Enter final position (meters): ");
        double finalPosition = scanner.nextDouble();

        System.out.print("Enter time taken (seconds): ");
        double time = scanner.nextDouble();

        // Calculate velocity using the formula: velocity = (final position - initial position) / time
        double velocity = (finalPosition - initialPosition) / time;

        System.out.println("The velocity is " + velocity + " meters per second.");

        scanner.close();
    }
}
