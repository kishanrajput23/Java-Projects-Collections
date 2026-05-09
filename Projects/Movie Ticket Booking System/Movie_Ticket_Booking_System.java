import java.util.*;

class User {
    private int userId;
    private String name;
    private String email;

    public User(int userId, String name, String email) {
        this.userId = userId;
        this.name = name;

        if (isValidEmail(email)) {
            this.email = email;
        } else {
            this.email = "default@gmail.com";
            System.out.println("Wrong email entered, Try again!");
        }
    }

    private boolean isValidEmail(String email) {
        return (email != null && email.contains("@"));
    }

    public void displayUserDetails() {
        System.out.println("USER ID: " + userId);
        System.out.println("USER NAME: " + name);
        System.out.println("USER EMAIL: " + email);
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        if (isValidEmail(email)) {
            this.email = email;
        } else {
            System.out.println("Invalid Email");
        }
    }

    public void performRole() {
        System.out.println("user role");
    }
}

class Admin extends User {
    public Admin(int userId, String name, String email) {
        super(userId, name, email);
    }

    public void addMovie() {
        System.out.println("Movie added successfully!");
    }

    @Override
    public void performRole() {
        System.out.println("Admin managing system");
    }
}

class Movie {
    private String movieId;
    private String title;
    private int duration;
    private String language;

    public Movie(String movieId, String title, int duration, String language) {
        this.movieId = movieId;
        this.title = title;

        if (duration > 0) {
            this.duration = duration;
        } else {
            this.duration = 0;
            System.out.println("Invalid duration time");
        }

        this.language = language;
    }

    public String getMovieId() {
        return movieId;
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }

    public String getLanguage() {
        return language;
    }

    public void setTitle(String title) {
        if (title != null && !title.isEmpty()) {
            this.title = title;
        }
    }

    public void setDuration(int duration) {
        if (duration > 0) {
            this.duration = duration;
        } else {
            System.out.println("Invalid duration time");
        }
    }

    public void setLanguage(String language) {
        if (language != null && !language.isEmpty()) {
            this.language = language;
        }
    }

    public void displayMovieDetails() {
        System.out.println("MOVIE ID: " + movieId);
        System.out.println("MOVIE TITLE: " + title);
        System.out.println("MOVIE DURATION: " + duration);
        System.out.println("MOVIE LANGUAGE: " + language);
    }
}

class Theater {
    private String theaterId;
    private String name;
    private String location;
    private List<Movie> movies;

    public Theater(String theaterId, String name, String location) {
        this.theaterId = theaterId;
        this.name = name;
        this.location = location;
        this.movies = new ArrayList<>();
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public void displayAllMovies() {
        for (Movie movie : movies) {
            movie.displayMovieDetails();
            System.out.println("------------------");
        }
    }
}

class Customer extends User {
    public Customer(int userId, String name, String email) {
        super(userId, name, email);
    }

    public void bookTicket() {
        System.out.println("Ticket booked successfully!");
    }

    @Override
    public void performRole() {
        System.out.println("Customer booking tickets");
    }
}

class Seat {
    private String seatNumber;
    private boolean isBooked;

    public Seat(String seatNumber) {
        this.seatNumber = seatNumber;
        this.isBooked = false;
    }

    public void bookSeat() {
        if (isBooked) {
            System.out.println("Seat already booked");
        } else {
            isBooked = true;
            System.out.println("Seat booked successfully");
        }
    }

    public boolean isBooked() {
        return isBooked;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void displaySeatStatus() {
        System.out.println("Seat : " + seatNumber + " | Booked : " + isBooked);
    }
}

class Show {
    private String showId;
    private Movie movie;
    private Theater theater;
    private List<Seat> seats;

    public Show(String showId, Movie movie, Theater theater) {
        this.showId = showId;
        this.movie = movie;
        this.theater = theater;
        this.seats = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            this.seats.add(new Seat("A" + i));
        }
    }

    public void displayAvailableSeats() {
        for (Seat seat : seats) {
            if (!seat.isBooked()) {
                System.out.println(seat.getSeatNumber());
            }
        }
    }

    public void bookSeat(String seatNumber) {
        for (Seat seat : seats) {
            if (seat.getSeatNumber().equals(seatNumber)) {
                seat.bookSeat();
                return;
            }
        }
        System.out.println("Seat not found");
    }

    public Seat getSeat(String seatNumber) {
        for (Seat seat : seats) {
            if (seat.getSeatNumber().equals(seatNumber)) {
                return seat;
            }
        }
        return null;
    }
}

class Booking {
    private String bookingId;
    private User user;
    private Show show;
    private Seat seat;

    public Booking(String bookingId, User user, Show show, Seat seat) {
        this.bookingId = bookingId;
        this.user = user;
        this.show = show;
        this.seat = seat;
    }

    public void confirmBooking() {
        if (seat.isBooked()) {
            System.out.println("Booking Confirmed!");
            System.out.println("Booking ID: " + bookingId);
            System.out.println("User: " + user.getName());
            System.out.println("Seat: " + seat.getSeatNumber());
        } else {
            System.out.println("Seat not booked yet. Cannot confirm.");
        }
    }
}

class BookingService {

    public Booking createBooking(User user, Show show, String seatNumber) {
        Seat seat = show.getSeat(seatNumber);

        if (seat == null) {
            System.out.println("Invalid seat");
            return null;
        }

        if (seat.isBooked()) {
            System.out.println("Seat already booked!");
            return null;
        }

        seat.bookSeat();

        Booking booking = new Booking("B1", user, show, seat);
        return booking;
    }
}

public class Movie_Ticket_Booking_System {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Admin admin = new Admin(1, "Admin", "admin@gmail.com");
        admin.addMovie();

        Theater t1 = new Theater("T1", "PVR", "Chennai");
        Movie m1 = new Movie("M1", "Leo", 150, "Tamil");
        t1.addMovie(m1);

        Show show1 = new Show("S1", m1, t1);

        BookingService bookingService = new BookingService();

        while (true) {
            System.out.println("\n===== MOVIE TICKET BOOKING SYSTEM =====");
            System.out.println("1. View Movie");
            System.out.println("2. Book Ticket");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("\nMovie Details:");
                    m1.displayMovieDetails();

                    System.out.println("\nAvailable Seats:");
                    show1.displayAvailableSeats();
                    break;

                case 2:
                    System.out.print("Enter your name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter email: ");
                    String email = sc.nextLine();

                    User customer = new Customer(2, name, email);

                    System.out.println("\nAvailable Seats:");
                    show1.displayAvailableSeats();

                    System.out.print("Enter seat number (A1-A5): ");
                    String seatNo = sc.nextLine();

                    Booking booking = bookingService.createBooking(customer, show1, seatNo);

                    if (booking != null) {
                        booking.confirmBooking();
                    }
                    break;

                case 3:
                    System.out.println("Thank you for using the system!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}