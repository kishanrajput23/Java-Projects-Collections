import java.io.IOException;
import java.util.List;
import java.util.Optional;

// Responsibility: To orchestrate the application flow, coordinating
// between the UI and the service layer. Contains the main method.
public class ReservationApplication {
    private ConsoleUI ui;
    private TicketService ticketService;

    public ReservationApplication() {
        this.ui = new ConsoleUI();
        // Initialize with some capacity
        this.ticketService = new TicketService(75, 125, 175); 
    }

    public void run() {
        int choice;
        try {
            do {
                ui.clearScreen();
                ui.displayHeading();
                choice = ui.displayMenuAndGetChoice();

                switch (choice) {
                    case 1:
                        handleBookTicket();
                        break;
                    case 2:
                        handleCancelTicket();
                        break;
                    case 3:
                        handleSearchPassenger();
                        break;
                    case 4:
                        handleDisplayReservationChart();
                        break;
                    case 5:
                        handleDisplayUnbookedTickets();
                        break;
                    case 6:
                        ui.displayExitMessage();
                        break;
                    default:
                        ui.displayInvalidChoice();
                }
                if (choice != 6) {
                    ui.waitForEnter();
                }
            } while (choice != 6);
        } catch (IOException e) {
            System.err.println("An I/O error occurred: " + e.getMessage());
        }
    }

    private void handleBookTicket() throws IOException {
        int ticketClass = ui.getTicketClassChoice();
        if (ticketClass < 1 || ticketClass > 3) {
            ui.displayInvalidChoice();
            return;
        }
        int numTickets = ui.getNumberOfTickets();
        if (numTickets <= 0) {
            System.out.println("Number of tickets must be positive.");
            return;
        }

        if (ticketService.checkAvailability(ticketClass, numTickets)) {
            String name = ui.getPassengerName();
            int age = ui.getPassengerAge();
            if (age <=0) {
                 System.out.println("Invalid age.");
                 return;
            }
            String phone = ui.getPassengerPhoneNumber();

            Optional<Passenger> bookedPassenger = ticketService.bookTicket(name, phone, age, ticketClass, numTickets);
            if(bookedPassenger.isPresent()){
                double price = ticketService.calculatePrice(ticketClass, numTickets);
                ui.displayBookingSuccess(bookedPassenger.get(), price);
            } else {
                 // This case should ideally not be reached if checkAvailability was true,
                 // but good for defensive programming or more complex scenarios.
                 System.out.println("Booking failed unexpectedly.");
            }
        } else {
            ui.displayBookingFailureNoAvailability();
        }
    }

    private void handleCancelTicket() throws IOException {
        int passengerNum = ui.getPassengerNumberForCancelOrSearch("cancel");
        if(passengerNum == -1){
            System.out.println("Invalid passenger number format.");
            return;
        }
        Optional<Passenger> passengerOpt = ticketService.findPassengerByNumber(passengerNum);
        
        if (passengerOpt.isPresent()) {
            boolean cancelled = ticketService.cancelTicket(passengerNum);
            if (cancelled) {
                double refund = ticketService.calculateRefund(passengerOpt.get().getTicketClass());
                ui.displayCancellationSuccess(refund);
            } else {
                 // Should not happen if passenger was found, but for safety:
                ui.displayCancellationFailure();
            }
        } else {
            ui.displayCancellationFailure();
        }
    }

    private void handleSearchPassenger() throws IOException {
        int passengerNum = ui.getPassengerNumberForCancelOrSearch("search");
         if(passengerNum == -1){
            System.out.println("Invalid passenger number format.");
            return;
        }
        Optional<Passenger> passenger = ticketService.findPassengerByNumber(passengerNum);
        ui.displayPassengerDetails(passenger);
    }

    private void handleDisplayReservationChart() {
        List<Passenger> acPassengers = ticketService.getPassengersByClass(1);
        List<Passenger> firstPassengers = ticketService.getPassengersByClass(2);
        List<Passenger> sleeperPassengers = ticketService.getPassengersByClass(3);
        ui.displayReservationChart(acPassengers, firstPassengers, sleeperPassengers);
    }

    private void handleDisplayUnbookedTickets() {
        ui.displayUnbookedTickets(
            ticketService.getRemainingAcTickets(),
            ticketService.getRemainingFirstClassTickets(),
            ticketService.getRemainingSleeperTickets()
        );
    }

    public static void main(String[] args) {
        ReservationApplication app = new ReservationApplication();
        app.run();
    }
}