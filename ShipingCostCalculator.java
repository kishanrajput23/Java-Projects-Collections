import java.util.Scanner;

public class ShipingCostCalculator {
    public static void main(String[] args)
    {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the weight of your package (kg) : \t ");
        double weight = scanner.nextDouble();

        System.out.println("Select a shipping method:");
        System.out.println("1. Standard Shipping");
        System.out.println("2. Express Shipping");
        int shippingMethod = scanner.nextInt();


        double cost;
        switch (shippingMethod) {
            case 1:
                cost = weight * 5.0; // Standard shipping rate
                break;
            case 2:
                cost = weight * 10.0; // Express shipping rate
                break;
            default:
                System.out.println("Invalid shipping method.");
                return;
        }

        System.out.println("Shipping cost: $" + cost);

        scanner.close();
    }








    }



