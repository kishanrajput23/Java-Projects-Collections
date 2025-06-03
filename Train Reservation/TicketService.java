import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

// Responsibility: To handle business logic related to ticket reservations,
// cancellations, and availability.
public class TicketService {
    private List<Passenger> passengers;
    private int nextPassengerNumber;
    private int maxAcTickets;
    private int maxFirstClassTickets;
    private int maxSleeperTickets;

    private int bookedAcTickets;
    private int bookedFirstClassTickets;
    private int bookedSleeperTickets;


    public TicketService(int initialMaxAc, int initialMaxFirst, int initialMaxSleeper) {
        this.passengers = new ArrayList<>();
        this.nextPassengerNumber = 1;
        this.maxAcTickets = initialMaxAc;
        this.maxFirstClassTickets = initialMaxFirst;
        this.maxSleeperTickets = initialMaxSleeper;
        this.bookedAcTickets = 0;
        this.bookedFirstClassTickets = 0;
        this.bookedSleeperTickets = 0;
    }

    // Check if tickets are available for a given class and quantity
    public boolean checkAvailability(int ticketClass, int numberOfTickets) {
        if (ticketClass == 1) {
            return (maxAcTickets - bookedAcTickets) >= numberOfTickets;
        } else if (ticketClass == 2) {
            return (maxFirstClassTickets - bookedFirstClassTickets) >= numberOfTickets;
        } else if (ticketClass == 3) {
            return (maxSleeperTickets - bookedSleeperTickets) >= numberOfTickets;
        }
        return false;
    }

    // Book tickets for a passenger
    public Optional<Passenger> bookTicket(String name, String phone, int age, int ticketClass, int numberOfTickets) {
        if (!checkAvailability(ticketClass, numberOfTickets)) {
            return Optional.empty(); // Not enough tickets
        }

        // For simplicity, this example books one passenger record even if numberOfTickets > 1.
        // A more complex system might create multiple Passenger objects or a group booking.
        // Here, we assume numberOfTickets implies a single passenger booking that reduces availability by 'numberOfTickets'.
        
        Passenger newPassenger = new Passenger(nextPassengerNumber++, name, phone, age, ticketClass);
        passengers.add(newPassenger);

        if (ticketClass == 1) {
            bookedAcTickets += numberOfTickets;
        } else if (ticketClass == 2) {
            bookedFirstClassTickets += numberOfTickets;
        } else if (ticketClass == 3) {
            bookedSleeperTickets += numberOfTickets;
        }
        return Optional.of(newPassenger);
    }
    
    // Calculate price for booking
    public double calculatePrice(int ticketClass, int numberOfTickets) {
        if (ticketClass == 1) return numberOfTickets * 1500.0;
        if (ticketClass == 2) return numberOfTickets * 1200.0;
        if (ticketClass == 3) return numberOfTickets * 1000.0;
        return 0.0;
    }

    // Cancel a ticket by passenger number
    public boolean cancelTicket(int passengerNumber) {
        Optional<Passenger> passengerToCancel = findPassengerByNumber(passengerNumber);
        if (passengerToCancel.isPresent()) {
            Passenger p = passengerToCancel.get();
            passengers.remove(p);
            // Assuming one ticket per passenger for simplicity in this cancellation logic
            if (p.getTicketClass() == 1) {
                bookedAcTickets--; 
            } else if (p.getTicketClass() == 2) {
                bookedFirstClassTickets--;
            } else if (p.getTicketClass() == 3) {
                bookedSleeperTickets--;
            }
            return true;
        }
        return false;
    }
    
    // Calculate refund for cancellation
    public double calculateRefund(int ticketClass) {
        if (ticketClass == 1) return 1800.0; // Example fixed refund
        if (ticketClass == 2) return 1500.0;
        if (ticketClass == 3) return 1000.0;
        return 0.0;
    }

    // Find a passenger by their number
    public Optional<Passenger> findPassengerByNumber(int passengerNumber) {
        return passengers.stream()
                         .filter(p -> p.getPassengerNumber() == passengerNumber)
                         .findFirst();
    }

    // Get a list of all passengers for a specific class
    public List<Passenger> getPassengersByClass(int ticketClass) {
        return passengers.stream()
                         .filter(p -> p.getTicketClass() == ticketClass)
                         .collect(Collectors.toList());
    }
    
    // Get all passengers
    public List<Passenger> getAllPassengers() {
        return new ArrayList<>(passengers); // Return a copy
    }

    // Get remaining AC tickets
    public int getRemainingAcTickets() {
        return maxAcTickets - bookedAcTickets;
    }

    // Get remaining First Class tickets
    public int getRemainingFirstClassTickets() {
        return maxFirstClassTickets - bookedFirstClassTickets;
    }

    // Get remaining Sleeper tickets
    public int getRemainingSleeperTickets() {
        return maxSleeperTickets - bookedSleeperTickets;
    }
}