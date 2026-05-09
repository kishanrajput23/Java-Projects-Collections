# Movie Ticket Booking System (Java)
  
This project simulates a real-world movie ticket booking process where users can view movies, check seat availability, and book tickets.

---

# Features

- View movie details
- Display available seats
- Book movie tickets
- Booking confirmation
- Seat availability management
- Email validation
- Menu-driven interface
- Admin and Customer roles
- OOP concepts implementation

---

# Technologies Used

- Java
- Object-Oriented Programming (OOP)
- Collections Framework
- Scanner Class
- Console-based UI

---

# Project Structure

```bash
Movie_Ticket_Booking_System.java
```

The project contains the following classes:

| Class Name | Description |
|------------|-------------|
| User | Base class for all users |
| Admin | Handles admin operations |
| Customer | Handles customer actions |
| Movie | Stores movie details |
| Theater | Manages theater and movies |
| Seat | Manages seat booking |
| Show | Handles show and seat availability |
| Booking | Stores booking information |
| BookingService | Handles booking logic |
| Movie_Ticket_Booking_System | Main class |

---

# OOP Concepts Used

## Encapsulation
- Private variables with getters and setters

## Inheritance
- `Admin` and `Customer` inherit from `User`

## Polymorphism
- Method overriding using `performRole()`

## Abstraction
- Booking operations separated using service class

---

# How to Run

## Step 1: Clone Repository

```bash
git clone https://github.com/YOUR_USERNAME/Java-Projects-Collections.git
```

## Step 2: Navigate to Project Folder

```bash
cd Java-Projects-Collections
```

## Step 3: Compile the Program

```bash
javac Movie_Ticket_Booking_System.java
```

## Step 4: Run the Program

```bash
java Movie_Ticket_Booking_System
```

---

# Sample Menu

```bash
===== MOVIE TICKET BOOKING SYSTEM =====

1. View Movie
2. Book Ticket
3. Exit
```

---

# Sample Booking Flow

```bash
Enter your name: Ismail
Enter email: ismail@gmail.com

Available Seats:
A1
A2
A3
A4
A5

Enter seat number: A1

Seat booked successfully
Booking Confirmed!
```

---

# Validations Implemented

- Email validation
- Seat availability checking
- Duplicate booking prevention
- Invalid seat handling
- Invalid duration validation

---

# Future Enhancements

- Database integration
- GUI implementation using Java Swing or JavaFX
- Multiple movies and shows
- Payment gateway simulation
- Ticket cancellation feature
- User authentication system

---

# Author

S-MOHAMMED-ISMAIL

GitHub: https://github.com/S-MOHAMMED-ISMAIL

---

# Contribution

Contributions, issues, and feature requests are welcome.

Feel free to fork the repository and submit a pull request.

---

# License

This project is developed for educational and learning purposes.