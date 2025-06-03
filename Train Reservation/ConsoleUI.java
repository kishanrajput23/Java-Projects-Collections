import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

// Responsibility: To handle all console-based user interaction (input and output).
public class ConsoleUI {
    private BufferedReader reader;

    public ConsoleUI() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void displayHeading() {
        System.out.println("#########################################################");
        System.out.println("*********Railway Reservation For Kabul Express***********");
        System.out.println("#########################################################");
    }

    public int displayMenuAndGetChoice() throws IOException {
        System.out.println("\n1. Book ticket");
        System.out.println("2. Cancel ticket");
        System.out.println("3. Search passenger");
        System.out.println("4. Reservation chart");
        System.out.println("5. Display unbooked tickets");
        System.out.println("6. Exit");
        System.out.print("Please enter your choice: ");
        try {
            return Integer.parseInt(reader.readLine());
        } catch (NumberFormatException e) {
            return -1; // Invalid choice marker
        }
    }

    public int getTicketClassChoice() throws IOException {
        System.out.println("Please enter the class of ticket:");
        System.out.println("1. AC\t 2. First\t 3. Sleeper\t");
        System.out.print("Enter class choice: ");
        try {
            return Integer.parseInt(reader.readLine());
        } catch (NumberFormatException e) {
            return -1; // Invalid class
        }
    }

    public int getNumberOfTickets() throws IOException {
        System.out.print("Please enter no. of tickets: ");
        try {
            return Integer.parseInt(reader.readLine());
        } catch (NumberFormatException e) {
            return 0; // Invalid number
        }
    }
    
    public String getPassengerName() throws IOException {
        System.out.print("Please enter your name: ");
        return reader.readLine();
    }

    public int getPassengerAge() throws IOException {
        System.out.print("Please enter your age: ");
        try {
            return Integer.parseInt(reader.readLine());
        } catch (NumberFormatException e) {
            return -1; // Invalid age
        }
    }

    public String getPassengerPhoneNumber() throws IOException {
        System.out.print("Please enter your phone number: ");
        return reader.readLine();
    }

    public void displayBookingSuccess(Passenger passenger, double price) {
        System.out.println("Ticket successfully booked for passenger no: " + passenger.getPassengerNumber());
        System.out.println("Please pay Rs." + price);
    }
    
    public void displayBookingFailureNoAvailability() {
        System.out.println("Sorry, not enough tickets available in the selected class.");
    }

    public int getPassengerNumberForCancelOrSearch(String action) throws IOException {
        System.out.print("Please enter passenger no. to " + action + ": ");
         try {
            return Integer.parseInt(reader.readLine());
        } catch (NumberFormatException e) {
            return -1; // Invalid number
        }
    }

    public void displayCancellationSuccess(double refundAmount) {
        System.out.println("Ticket successfully cancelled.");
        System.out.println("Please collect refund of Rs." + refundAmount);
    }

    public void displayCancellationFailure() {
        System.out.println("Passenger not found. Cancellation failed.");
    }
    
    public void displayPassengerDetails(Optional<Passenger> passengerOpt) {
        if (passengerOpt.isPresent()) {
            Passenger p = passengerOpt.get();
            System.out.println("Detail found:");
            System.out.println("Passenger no. = " + p.getPassengerNumber());
            System.out.println("Name          = " + p.getName());
            System.out.println("Class         = " + getClassString(p.getTicketClass()));
            System.out.println("Phone no.     = " + p.getPhoneNumber());
            System.out.println("Age           = " + p.getAge());
        } else {
            System.out.println("No such passenger.");
        }
    }
    
    private String getClassString(int classCode) {
        switch (classCode) {
            case 1: return "AC";
            case 2: return "First";
            case 3: return "Sleeper";
            default: return "Unknown";
        }
    }

    public void displayReservationChart(List<Passenger> acPassengers, List<Passenger> firstPassengers, List<Passenger> sleeperPassengers) {
        System.out.println("\n--- Reservation Chart ---");
        System.out.println("Passenger list in AC class");
        System.out.println("PNO \t Name \t\t Age \t Phone No.");
        acPassengers.forEach(System.out::println);

        System.out.println("\nPassenger list in First class");
        System.out.println("PNO \t Name \t\t Age \t Phone No.");
        firstPassengers.forEach(System.out::println);
        
        System.out.println("\nPassenger list in Sleeper class");
        System.out.println("PNO \t Name \t\t Age \t Phone No.");
        sleeperPassengers.forEach(System.out::println);
    }
    
    public void displayUnbookedTickets(int ac, int first, int sleeper) {
        System.out.println("\n--- Unbooked Tickets Status ---");
        System.out.println("AC class: " + ac);
        System.out.println("First class: " + first);
        System.out.println("Sleeper class: " + sleeper);
    }

    public void displayExitMessage() {
        System.out.println("\n&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        System.out.println("Project done by: Nikhil Falke (Refactored Version)");
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        System.out.println("Exiting application...");
    }

    public void displayInvalidChoice() {
        System.out.println("Invalid choice. Please try again.");
    }
    
    public void waitForEnter() {
        System.out.println("\nPress Enter to continue...");
        try {
            reader.readLine();
        } catch (IOException e) {
            // Ignore
        }
    }
    
    public void clearScreen() {
        // This is a simple way to simulate screen clearing in console.
        // Might not work perfectly on all terminals.
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}