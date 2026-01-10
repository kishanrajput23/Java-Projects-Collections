import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Patient {
    private int id;
    private String name;
    private int age;

    public Patient(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

class Doctor {
    private int id;
    private String name;
    private String specialization;

    public Doctor(int id, String name, String specialization) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }
}

class Appointment {
    private int id;
    private Patient patient;
    private Doctor doctor;
    private String date;

    public Appointment(int id, Patient patient, Doctor doctor, String date) {
        this.id = id;
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public String getDate() {
        return date;
    }
}

public class HospitalManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Patient> patients = new ArrayList<>();
        List<Doctor> doctors = new ArrayList<>();
        List<Appointment> appointments = new ArrayList<>();
        int patientIdCounter = 1;
        int doctorIdCounter = 1;
        int appointmentIdCounter = 1;

        while (true) {
            System.out.println("Hospital Management System Menu:");
            System.out.println("1. Add Patient");
            System.out.println("2. Add Doctor");
            System.out.println("3. Schedule Appointment");
            System.out.println("4. View Appointments");
            System.out.println("5. Exit");
            System.out.print("Select an option (1/2/3/4/5): ");

            int option = scanner.nextInt();
            
            switch (option) {
                case 1:
                    scanner.nextLine();
                    System.out.print("Enter patient name: ");
                    String patientName = scanner.nextLine();
                    System.out.print("Enter patient age: ");
                    int patientAge = scanner.nextInt();
                    patients.add(new Patient(patientIdCounter, patientName, patientAge));
                    patientIdCounter++;
                    System.out.println("Patient added successfully.");
                    break;
                case 2:
                    scanner.nextLine();
                    System.out.print("Enter doctor name: ");
                    String doctorName = scanner.nextLine();
                    System.out.print("Enter doctor specialization: ");
                    String doctorSpecialization = scanner.nextLine();
                    doctors.add(new Doctor(doctorIdCounter, doctorName, doctorSpecialization));
                    doctorIdCounter++;
                    System.out.println("Doctor added successfully.");
                    break;
                case 3:
                    System.out.print("Enter patient ID: ");
                    int patientId = scanner.nextInt();
                    System.out.print("Enter doctor ID: ");
                    int doctorId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter appointment date: ");
                    String appointmentDate = scanner.nextLine();
                    
                    Patient patient = findPatientById(patients, patientId);
                    Doctor doctor = findDoctorById(doctors, doctorId);
                    
                    if (patient != null && doctor != null) {
                        appointments.add(new Appointment(appointmentIdCounter, patient, doctor, appointmentDate));
                        appointmentIdCounter++;
                        System.out.println("Appointment scheduled successfully.");
                    } else {
                        System.out.println("Patient or doctor not found.");
                    }
                    break;
                case 4:
                    System.out.println("Appointments:");
                    for (Appointment appointment : appointments) {
                        System.out.println("Appointment ID: " + appointment.getId());
                        System.out.println("Patient: " + appointment.getPatient().getName());
                        System.out.println("Doctor: " + appointment.getDoctor().getName() + " (" + appointment.getDoctor().getSpecialization() + ")");
                        System.out.println("Date: " + appointment.getDate());
                        System.out.println();
                    }
                    break;
                case 5:
                    System.out.println("Exiting the Hospital Management System.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please select 1, 2, 3, 4, or 5.");
            }
        }
    }

    private static Patient findPatientById(List<Patient> patients, int id) {
        for (Patient patient : patients) {
            if (patient.getId() == id) {
                return patient;
            }
        }
        return null;
    }

    private static Doctor findDoctorById(List<Doctor> doctors, int id) {
        for (Doctor doctor : doctors) {
            if (doctor.getId() == id) {
                return doctor;
            }
        }
        return null;
    }
}
