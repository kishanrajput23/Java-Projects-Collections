import java.util.Scanner;

public class LoadingAnimation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the loading percentage (0-100): ");
        int percentage = scanner.nextInt();
        scanner.close();
        
        if (percentage < 0 || percentage > 100) {
            System.out.println("Invalid input. Percentage must be between 0 and 100.");
            return;
        }
        
        int width = 50; // Width of the loading bar
        int progress = (int) (width * (percentage / 100.0)); // Calculate the progress

        System.out.print("Loading: [");
        for (int i = 0; i < width; i++) {
            if (i < progress) {
                System.out.print("=");
            } else {
                System.out.print(" ");
            }
        }
        System.out.println("] " + percentage + "% Complete");
    }
}

