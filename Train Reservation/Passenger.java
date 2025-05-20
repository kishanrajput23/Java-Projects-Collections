// Responsibility: To hold data for a single passenger.

public class Passenger {
    private int passengerNumber;
    private String name;
    private String phoneNumber;
    private int age;
    private int ticketClass; // 1: AC, 2: First, 3: Sleeper

    public Passenger(int passengerNumber, String name, String phoneNumber, int age, int ticketClass) {
        this.passengerNumber = passengerNumber;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.ticketClass = ticketClass;
    }

    // Getters
    public int getPassengerNumber() {
        return passengerNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public int getTicketClass() {
        return ticketClass;
    }

    // Setters (if mutable instances are desired, otherwise make it immutable)
    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setTicketClass(int ticketClass) {
        this.ticketClass = ticketClass;
    }

    @Override
    public String toString() {
        return passengerNumber + "\t" + name + "\t\t" + age + "\t" + phoneNumber;
    }
}