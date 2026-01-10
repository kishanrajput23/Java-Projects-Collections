package packages.system;
import java.util.Scanner;

    // ---------------------------------------------- INPUT VALIDATION FUNCTIONS ----------------------------------------------

public class InputValidator {

    // Get the file path from the user
    public static String getFilePath(Scanner scanner, String extension) {
        String filePath;
        while (true) {
            System.out.print("Enter the path of the CSV file to read: ");
            filePath = scanner.nextLine().trim();
            if (filePath.endsWith(extension)) break;
            System.out.println("Invalid input. Please enter a valid CSV file path.");
        }
        return filePath;
    }

    // Validate the input name
    public static String inputValidName(Scanner scanner) {
        String name;
        while (true) {
            System.out.print("Enter Student's Name: ");
            name = scanner.nextLine().trim();
            if (name.matches("[A-Za-z ]+") && !name.isEmpty()) break;
            System.out.println("Invalid input. Please enter a valid name (letters and spaces only).");
        }
        return name;
    }

    // Validate the input ID
    public static int inputValidID(Scanner scanner) {
        System.out.print("Enter Student's ID: ");
        String ID = scanner.nextLine();

        while (!ID.matches("\\d+") || Integer.parseInt(ID) < 0) {
            System.out.println("Invalid input. Please enter a valid integer ID.");
            System.out.print("Enter ID: ");
            ID = scanner.nextLine();
        }

        return Integer.parseInt(ID);
    }

    // Check if the name is unique
    public static String addUniqueName(Scanner scanner, StudentSystem system) {
        String newName = inputValidName(scanner);
        while (true) {
            boolean isUnique = true;
            for (Student student : system.getStudentList()) {
                if (student.name.equals(newName)) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) break;
            System.out.println("Name already exists. Please enter a unique name.");
            newName = inputValidName(scanner);
        }
        return newName;
    }

    // Check if the ID is unique
    public static int addUniqueID(Scanner scanner, StudentSystem system) {
        int newID = inputValidID(scanner);
        while (true) {
            boolean isUnique = true;
            for (Student student : system.getStudentList()) {
                if (student.ID == newID) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) break;
            System.out.println("ID already exists. Please enter a unique ID.");
            newID = inputValidID(scanner);
        }
        return newID;
    }

    // Validate the input GPA
    public static double inputValidGPA(Scanner scanner) {
        System.out.print("Enter Student's GPA (0.0 - 4.0): ");
        String GPA = scanner.nextLine();

        while (!GPA.matches("\\d+(\\.\\d+)?") || Double.parseDouble(GPA) < 0 || Double.parseDouble(GPA) > 4) {
            System.out.println("Invalid input. Please enter a valid GPA.");
            System.out.print("Enter Student's GPA (0.0 - 4.0): ");
            GPA = scanner.nextLine();
        }

        return Double.parseDouble(GPA);
    }

    // Validate the input year
    public static String inputValidYear(Scanner scanner) {
        System.out.print("Enter Student's Year (First, Second, Third, Fourth): ");

        String year = scanner.nextLine();
        while (!year.matches("First|Second|Third|Fourth")) {
            System.out.println("Invalid input. Please enter a valid year.");
            System.out.print("Enter Student's Year (First, Second, Third, Fourth): ");
            year = scanner.nextLine();
        }

        return year;
    }

    // Validate the input department
    public static String inputValidDepartment(Scanner scanner) {
        System.out.print("Enter Student's Department (CS - IS - AI - IT - DS - General): ");

        String department = scanner.nextLine();
        while (!department.matches("CS|IS|AI|IT|DS|General")) {
            System.out.println("Invalid input. Please enter a valid year.");
            System.out.print("Enter Student's Department (CS - IS - AI - IT - DS - General): ");
            department = scanner.nextLine();
        }

        return department;
    }

    // Validate the choice input
    public static int inputValidChoice(Scanner scanner) {
        System.out.print("Enter your choice: ");
        String choice = scanner.nextLine();

        while (!choice.matches("\\d+") || Integer.parseInt(choice) < 0) {
            System.out.println("Invalid input. Please enter a valid number.");
            System.out.print("Enter your choice: ");
            choice = scanner.nextLine();
        }

        return Integer.parseInt(choice);
    }
}
