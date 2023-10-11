import java.util.Random;

// Thermometer class to represent a thermometer
class Thermometer {
    private double temperature;

    public Thermometer() {
        // Initialize the temperature to a random value between 0 and 100
        Random rand = new Random();
        temperature = rand.nextDouble() * 100;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public void measure() {
        // Simulate measuring the temperature by updating it randomly
        Random rand = new Random();
        temperature += rand.nextDouble() * 2 - 1; // Random change between -1 and 1
    }
}

public class ThermometerApp {
    public static void main(String[] args) {
        Thermometer thermometer = new Thermometer();

        System.out.println("Initial temperature: " + thermometer.getTemperature() + "°C");

        for (int i = 0; i < 5; i++) {
            thermometer.measure();
            System.out.println("Updated temperature: " + thermometer.getTemperature() + "°C");
        }
    }
}
