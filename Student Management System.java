import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private int rollNumber;
    private double grade;

    public Student(String name, int rollNumber, double grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}

public class StudentManagementSystem {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline character

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudentRecords();
                    break;
                case 3:
                    editStudentInformation();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\nStudent Management System");
        System.out.println("1. Add a new student");
        System.out.println("2. View student records");
        System.out.println("3. Edit student information");
        System.out.println("4. Delete student record");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter roll number: ");
        int rollNumber = scanner.nextInt();
        System.out.print("Enter grade: ");
        double grade = scanner.nextDouble();

        Student student = new Student(name, rollNumber, grade);
        students.add(student);
        System.out.println("Student added to the records!");
    }

    private static void viewStudentRecords() {
        System.out.println("\nStudent Records:");
        for (Student student : students) {
            System.out.println("Name: " + student.getName() + ", Roll Number: " + student.getRollNumber() + ", Grade: " + student.getGrade());
        }
    }

    private static void editStudentInformation() {
        System.out.print("Enter the roll number of the student you want to edit: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine();  // Consume newline character

        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                System.out.print("Enter the new grade for " + student.getName() + ": ");
                double newGrade = scanner.nextDouble();
                student.setGrade(newGrade);
                System.out.println("Student information updated!");
                return;
            }
        }
        System.out.println("Student with roll number " + rollNumber + " not found in the records.");
    }

    private static void deleteStudent() {
        System.out.print("Enter the roll number of the student you want to delete: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine();  // Consume newline character

        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                students.remove(student);
                System.out.println("Student record deleted: " + student.getName());
                return;
            }
        }
        System.out.println("Student with roll number " + rollNumber + " not found in the records.");
    }
}
