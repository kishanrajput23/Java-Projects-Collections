import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VehicleManager vehicleManager = new VehicleManager();

        while (true) {
            System.out.println("Vehicle Management System");
            System.out.println("1. Add Vehicle");
            System.out.println("2. View Vehicles");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter make: ");
                    String make = scanner.nextLine();
                    System.out.print("Enter model: ");
                    String model = scanner.nextLine();
                    System.out.print("Enter year: ");
                    int year = scanner.nextInt();
                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();

                    Vehicle newVehicle = new Vehicle(make, model, year, price);
                    vehicleManager.addVehicle(newVehicle);
                    System.out.println("Vehicle added successfully!");
                    break;
                case 2:
                    System.out.println("All Vehicles:");
                    for (Vehicle vehicle : vehicleManager.getAllVehicles()) {
                        System.out.println(vehicle);
                    }
                    break;
                case 3:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
