import java.util.ArrayList;
import java.util.Scanner;

class Equipment {
    private String name;
    private int quantity;

    public Equipment(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void addEquipment(int quantity) {
        this.quantity += quantity;
    }

    public void useEquipment(int quantity) {
        if (this.quantity >= quantity) {
            this.quantity -= quantity;
        } else {
            System.out.println("Insufficient equipment available.");
        }
    }
}

class Trainer {
    private String name;
    private String specialty;

    public Trainer(String name, String specialty) {
        this.name = name;
        this.specialty = specialty;
    }

    public String getName() {
        return name;
    }

    public String getSpecialty() {
        return specialty;
    }
}

class ExercisePlan {
    private String name;
    private String description;

    public ExercisePlan(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}

class Customer {
    private String name;
    private int customerId;
    private ExercisePlan exercisePlan;

    public Customer(String name, int customerId, ExercisePlan exercisePlan) {
        this.name = name;
        this.customerId = customerId;
        this.exercisePlan = exercisePlan;
    }

    public String getName() {
        return name;
    }

    public int getCustomerId() {
        return customerId;
    }

    public ExercisePlan getExercisePlan() {
        return exercisePlan;
    }
}

class Subscription {
    private Customer customer;
    private Trainer trainer;
    private String schedule;

    public Subscription(Customer customer, Trainer trainer, String schedule) {
        this.customer = customer;
        this.trainer = trainer;
        this.schedule = schedule;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public String getSchedule() {
        return schedule;
    }
}

public class GymManagementSystem {
    public static void main(String[] args) {
        ArrayList<Equipment> equipmentList = new ArrayList<>();
        ArrayList<Trainer> trainerList = new ArrayList<>();
        ArrayList<ExercisePlan> exercisePlanList = new ArrayList<>();
        ArrayList<Customer> customerList = new ArrayList<>();
        ArrayList<Subscription> subscriptionList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nGym Management System");
            System.out.println("1. Manage Equipment");
            System.out.println("2. Manage Trainers");
            System.out.println("3. Manage Exercise Plans");
            System.out.println("4. Manage Customers");
            System.out.println("5. Manage Subscriptions");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    // Equipment management
                    System.out.println("1. Add Equipment");
                    System.out.println("2. Use Equipment");
                    System.out.println("3. Display Equipment");
                    int equipmentChoice = scanner.nextInt();
                    scanner.nextLine();
                    switch (equipmentChoice) {
                        case 1:
                            System.out.print("Enter equipment name: ");
                            String equipmentName = scanner.nextLine();
                            System.out.print("Enter equipment quantity: ");
                            int equipmentQuantity = scanner.nextInt();
                            equipmentList.add(new Equipment(equipmentName, equipmentQuantity));
                            System.out.println("Equipment added successfully!");
                            break;
                        case 2:
                            // Implement equipment usage
                            // Implement equipment usage
                            System.out.print("Enter equipment name: ");
                            String useEquipmentName = scanner.nextLine();
                            System.out.print("Enter quantity to use: ");
                            int useEquipmentQuantity = scanner.nextInt();
                            for (Equipment equipment : equipmentList) {
                                if (equipment.getName().equalsIgnoreCase(useEquipmentName)) {
                                    equipment.useEquipment(useEquipmentQuantity);
                                    System.out.println("Equipment used successfully!");
                                    break;
                                }
                            }
                            break;
                        case 3:
                            // Implement equipment display
                            for (Equipment equipment : equipmentList) {
                                System.out.println("Equipment: " + equipment.getName() + ", Quantity: " + equipment.getQuantity());
                            }
                            break;
                    }
                    break;
                case 2:
                    // Trainer management
                    System.out.println("1. Add Trainer");
                    System.out.println("2. Display Trainers");
                    int trainerChoice = scanner.nextInt();
                    scanner.nextLine();
                    switch (trainerChoice) {
                        case 1:
                            System.out.print("Enter trainer name: ");
                            String trainerName = scanner.nextLine();
                            System.out.print("Enter trainer specialty: ");
                            String trainerSpecialty = scanner.nextLine();
                            trainerList.add(new Trainer(trainerName, trainerSpecialty));
                            System.out.println("Trainer added successfully!");
                            break;
                        case 2:
                            // Implement trainer display
                            for (Trainer trainer : trainerList) {
                                System.out.println("Trainer: " + trainer.getName() + ", Specialty: " + trainer.getSpecialty());
                            }
                            break;
                    }
                    break;
                case 3:
                    // Exercise plan management
                    System.out.println("1. Add Exercise Plan");
                    System.out.println("2. Display Exercise Plans");
                    int exercisePlanChoice = scanner.nextInt();
                    scanner.nextLine();
                    switch (exercisePlanChoice) {
                        case 1:
                            System.out.print("Enter exercise plan name: ");
                            String planName = scanner.nextLine();
                            System.out.print("Enter exercise plan description: ");
                            String planDescription = scanner.nextLine();
                            exercisePlanList.add(new ExercisePlan(planName, planDescription));
                            System.out.println("Exercise plan added successfully!");
                            break;
                        case 2:
                            // Implement exercise plan display
                            for (ExercisePlan plan : exercisePlanList) {
                                System.out.println("Exercise Plan: " + plan.getName() + "\nDescription: " + plan.getDescription());
                            }
                            break;
                    }
                    break;
                case 4:
                    // Customer management
                    System.out.println("1. Add Customer");
                    System.out.println("2. Display Customers");
                    int customerChoice = scanner.nextInt();
                    scanner.nextLine();
                    switch (customerChoice) {
                        case 1:
                            System.out.print("Enter customer name: ");
                            String customerName = scanner.nextLine();
                            System.out.print("Enter customer ID: ");
                            int customerID = scanner.nextInt();
                            System.out.println("Available Exercise Plans:");
                            for (ExercisePlan plan : exercisePlanList) {
                                System.out.println(plan.getName());
                            }
                            System.out.print("Select an exercise plan: ");
                            String selectedPlanName = scanner.next();
                            ExercisePlan selectedPlan = null;
                            for (ExercisePlan plan : exercisePlanList) {
                                if (plan.getName().equals(selectedPlanName)) {
                                    selectedPlan = plan;
                                    break;
                                }
                            }
                            if (selectedPlan != null) {
                                customerList.add(new Customer(customerName, customerID, selectedPlan));
                                System.out.println("Customer added successfully!");
                            } else {
                                System.out.println("Invalid exercise plan selection.");
                            }
                            break;
                        case 2:
                            // Implement customer display
                            for (Customer customer : customerList) {
                                System.out.println("Customer: " + customer.getName() + ", ID: " + customer.getCustomerId() + ", Exercise Plan: " + customer.getExercisePlan().getName());
                            }
                            break;
                    }
                    break;
                case 5:
                    // Subscription management
                    System.out.println("1. Subscribe Customer");
                    System.out.println("2. Display Subscriptions");
                    int subscriptionChoice = scanner.nextInt();
                    scanner.nextLine();
                    switch (subscriptionChoice) {
                        case 1:
                            System.out.print("Enter customer ID to subscribe: ");
                            int customerID = scanner.nextInt();
                            System.out.print("Enter trainer name for the subscription: ");
                            String trainerName = scanner.nextLine();
                            System.out.print("Enter schedule for the subscription: ");
                            String schedule = scanner.nextLine();

                            Customer subscribingCustomer = null;
                            Trainer selectedTrainer = null;

                            // Find the subscribing customer and the selected trainer
                            for (Customer customer : customerList) {
                                if (customer.getCustomerId() == customerID) {
                                    subscribingCustomer = customer;
                                    break;
                                }
                            }
                            for (Trainer trainer : trainerList) {
                                if (trainer.getName().equalsIgnoreCase(trainerName)) {
                                    selectedTrainer = trainer;
                                    break;
                                }
                            }

                            if (subscribingCustomer != null && selectedTrainer != null) {
                                subscriptionList.add(new Subscription(subscribingCustomer, selectedTrainer, schedule));
                                System.out.println("Subscription added successfully!");
                            } else {
                                System.out.println("Invalid customer ID or trainer name.");
                            }
                            break;
                        case 2:
                            // Implement subscription display
                             for (Subscription subscription : subscriptionList) {
                                System.out.println("Customer: " + subscription.getCustomer().getName() +
                                        ", Trainer: " + subscription.getTrainer().getName() +
                                        ", Schedule: " + subscription.getSchedule());
                            }
                            break;
                    }
                    break;
                case 6:
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
