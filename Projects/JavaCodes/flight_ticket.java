import java.util.Scanner;

public class Flight {
    private String flightNumber;
    private String sourceLocation;
    private String destination;
    private int numberOfTickets;
    private double ticketFare;

    public void inputFlightData() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Flight Number: ");
        flightNumber = scanner.nextLine();
        System.out.print("Enter Source Location: ");
        sourceLocation = scanner.nextLine();
        System.out.print("Enter Destination: ");
        destination = scanner.nextLine();
        System.out.print("Enter Number of Tickets: ");
        numberOfTickets = scanner.nextInt();
        System.out.print("Enter Ticket Fare: ");
        ticketFare = scanner.nextDouble();
    }

    public double calculateTicketAmount() {
        double ticketAmount = numberOfTickets * ticketFare;
        double tax = 0.18 * ticketAmount;
        double discount = 0.05 * ticketAmount;
        return ticketAmount + tax - discount;
    }

    public void printTicketDetails() {
        System.out.println("Flight Number: " + flightNumber);
        System.out.println("Source Location: " + sourceLocation);
        System.out.println("Destination: " + destination);
        System.out.println("Number of Tickets: " + numberOfTickets);
        System.out.println("Ticket Fare: " + ticketFare);
        System.out.println("Total Amount Payable: " + calculateTicketAmount());
    }

    public static void main(String[] args) {
        Flight flight = new Flight();
        flight.inputFlightData();
        flight.printTicketDetails();
    }
}
