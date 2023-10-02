import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Passenger {
    private String name;
    private int age;
    private String passportNumber;

    public Passenger(String name, int age, String passportNumber) {
        this.name = name;
        this.age = age;
        this.passportNumber = passportNumber;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Passport Number: " + passportNumber;
    }
}

class Flight {
    private String flightNumber;
    private String destination;
    private int availableSeats;
    private List<Passenger> passengers;

    public Flight(String flightNumber, String destination, int availableSeats) {
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.availableSeats = availableSeats;
        this.passengers = new ArrayList<>();
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDestination() {
        return destination;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public boolean bookSeat(Passenger passenger) {
        if (availableSeats > 0) {
            passengers.add(passenger);
            availableSeats--;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Flight Number: " + flightNumber + ", Destination: " + destination + ", Available Seats: " + availableSeats;
    }
}

public class AirlineReservationSystem {
    private static List<Flight> flights = new ArrayList<>();

    public static void main(String[] args) {
        initializeFlights();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Airline Reservation System Menu:");
            System.out.println("1. List Available Flights");
            System.out.println("2. Book a Flight");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    listAvailableFlights();
                    break;
                case 2:
                    bookAFlight(scanner);
                    break;
                case 3:
                    System.out.println("Exiting the program. Thank you!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void initializeFlights() {
        flights.add(new Flight("F101", "New York", 100));
        flights.add(new Flight("F102", "Los Angeles", 120));
        flights.add(new Flight("F103", "Chicago", 90));
    }

    private static void listAvailableFlights() {
        System.out.println("Available Flights:");
        for (Flight flight : flights) {
            System.out.println(flight);
        }
    }

    private static void bookAFlight(Scanner scanner) {
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        System.out.print("Enter your passport number: ");
        String passportNumber = scanner.nextLine();
        System.out.print("Enter the flight number you want to book: ");
        String flightNumber = scanner.nextLine();

        Flight selectedFlight = null;
        for (Flight flight : flights) {
            if (flight.getFlightNumber().equalsIgnoreCase(flightNumber)) {
                selectedFlight = flight;
                break;
            }
        }

        if (selectedFlight != null) {
            Passenger passenger = new Passenger(name, age, passportNumber);
            if (selectedFlight.bookSeat(passenger)) {
                System.out.println("Seat booked successfully!");
            } else {
                System.out.println("Sorry, the flight is fully booked.");
            }
        } else {
            System.out.println("Invalid flight number. Please enter a valid flight number.");
        }
    }
}
