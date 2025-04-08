import java.util.*;
import packages.system.*;
import packages.fileHandler.*;

    // ---------------------------------------------- MAIN FUNCTION ----------------------------------------------

public class App {
    public static void main(String[] args) {
        System.out.println("\n\t------------ WELCOME TO STUDENT MANAGEMENT SYSTEM ------------\n");
        Scanner scanner = new Scanner(System.in);
        StudentSystem system = new StudentSystem();

        while (true) {
            System.out.println("Choose an option:");
            System.out.println(" 1. Add Student.");
            System.out.println(" 2. Remove Student.");
            System.out.println(" 3. Update Student.");
            System.out.println(" 4. Search Student by ID.");
            System.out.println(" 5. List and Sort Students.");
            System.out.println(" 6. Filter Students.");
            System.out.println(" 7. Count Total Students.");
            System.out.println(" 8. Calculate Average GPA.");
            System.out.println(" 9. Display Top 5 Students.");
            System.out.println(" 10. Display Failing Students.");
            System.out.println(" 11. Generate Summary.");
            System.out.println(" 0. Exit Application.");

            int choice = InputValidator.inputValidChoice(scanner);
            System.out.println();

            switch (choice) {
                case 1:     // Add Student
                    while (true) {
                        System.out.println("Choose an option to add student:");
                        System.out.println(" 1. Add Student from CSV File.");
                        System.out.println(" 2. Add Student Manually.");
                        System.out.println(" 0. Exit Add Student.");

                        int addChoice = InputValidator.inputValidChoice(scanner);

                        if (addChoice == 0) {       // Exit Add Student
                            System.out.println();
                            break;
                        }

                        switch (addChoice) {
                            case 1:         // Add Student from CSV File
                                system.mergeStudentSystem(CsvFileHandler.readCsvFile());
                                break;

                            case 2:         // Add Student Manually
                                String name = InputValidator.addUniqueName(scanner, system);
                                int id = InputValidator.addUniqueID(scanner, system);
                                double gpa = InputValidator.inputValidGPA(scanner);
                                String year = InputValidator.inputValidYear(scanner);
                                String department = InputValidator.inputValidDepartment(scanner);

                                if (year.equals("First") || year.equals("Second")) department = "General";

                                system.addStudent(name, id, gpa, year, department, false);
                                break;

                            default:        // Invalid choice
                                System.out.println("Invalid choice, please try again.");
                        }
                    }
                    break;

                case 2:             // Remove Student
                    int removeID = InputValidator.inputValidID(scanner);
                    system.removeStudentByID(removeID);
                    break;

                case 3:             // Update Student
                    int updateID = InputValidator.inputValidID(scanner);

                    while (true) {
                        System.out.println("Choose an option to update:");
                        System.out.println(" 1. Student's Name.");
                        System.out.println(" 2. Student's GPA.");
                        System.out.println(" 3. Student's Year.");
                        System.out.println(" 4. Student's Department.");
                        System.out.println(" 0. Exit Update.");

                        int updateChoice = InputValidator.inputValidChoice(scanner);
                        if (updateChoice == 0) {        // Exit Update
                            System.out.println();
                            break;
                        }

                        switch (updateChoice) {
                            case 1:             // Update Student's Name
                                String newName = InputValidator.addUniqueName(scanner, system);
                                system.updateStudentByID(updateID, newName, -1, null, null);
                                break;

                            case 2:             // Update Student's GPA
                                double newGPA = InputValidator.inputValidGPA(scanner);
                                scanner.nextLine();
                                system.updateStudentByID(updateID, null, newGPA, null, null);
                                break;

                            case 3:             // Update Student's Year
                                String newYear = InputValidator.inputValidYear(scanner);
                                scanner.nextLine();
                                system.updateStudentByID(updateID, null, -1, newYear, null);
                                break;

                            case 4:             // Update Student's Department
                                String newDepartment = InputValidator.inputValidDepartment(scanner);
                                scanner.nextLine();
                                system.updateStudentByID(updateID, null, -1, null, newDepartment);
                                break;

                            default:            // Invalid choice
                                System.out.println("Invalid choice, please try again.");
                        }
                    }

                    break;

                case 4:             // Search Student by ID
                    int searchID = InputValidator.inputValidID(scanner);
                    system.searchByID(searchID);
                    break;

                case 5:             // List and Sort Students
                    while (true) {
                        System.out.println("Output all students in:");
                        System.out.println(" 1. The Console.");
                        System.out.println(" 2. A File.");
                        System.out.println(" 0. Exit List and Sort.");

                        int outputChoice = InputValidator.inputValidChoice(scanner);

                        if (outputChoice == 0) {            // Exit List and Sort
                            System.out.println();
                            break;
                        }

                        else if (outputChoice == 1) {       // Output in the Console
                            System.out.print("Enter sorting criteria (GPA, ID, Name, Year): ");
                            String sortBy = scanner.nextLine();

                            while (!sortBy.matches("GPA|ID|Name|Year")) {
                                System.out.println("Invalid input. Please enter a valid sorting criteria.");
                                System.out.print("Enter sorting criteria (GPA, ID, Name, Year): ");
                                sortBy = scanner.nextLine();
                            }

                            system.listAndSortAllStudents(sortBy);
                            break;
                        }

                        else if (outputChoice == 2) {       // Output in a File (CSV)
                            CsvFileHandler.writeCsvFile(system);
                            break;
                        }

                        else System.out.println("Invalid choice, please try again.\n");      // Invalid choice
                    }
                    break;

                case 6:             // Filter Students
                    System.out.print("Choose an option to filter (GPA - Year - Department): ");
                    String filterChoice = scanner.nextLine();

                    while (!filterChoice.matches("GPA|Year|Department")) {
                        System.out.println("Invalid input. Please enter a valid year.");
                        System.out.print("Choose an option to filter (Age - GPA - Year - Department): ");
                        filterChoice = scanner.nextLine();
                    }

                    switch (filterChoice) {
                        case "GPA":
                            double filterGPA = InputValidator.inputValidGPA(scanner);
                            System.out.println();
                            system.filterByGPA(filterGPA);
                            break;

                        case "Year":
                            String filterYear = InputValidator.inputValidYear(scanner);
                            System.out.println();
                            system.filterByYear(filterYear);
                            break;

                        case "Department":
                            String filterDepartment = InputValidator.inputValidDepartment(scanner);
                            System.out.println();
                            system.filterByDepartment(filterDepartment);
                            break;

                        default:
                            System.out.println("Invalid choice, please try again.\n");
                    }
                    break;

                case 7:             // Count Total Students
                    system.countTotalStudents();
                    break;

                case 8:             // Calculate Average GPA
                    system.calculateAverageGPA();
                    break;

                case 9:             // Display Top 5 Students
                    system.displayTop5();
                    break;

                case 10:            // Display Failing Students
                    system.displayFailingStudents();
                    break;

                case 11:            // Generate Summary
                    System.out.println("Choose an option to output generated summary:");
                    System.out.println(" 1. Output the Summary in the Console.");
                    System.out.println(" 2. Output the Summary in the Report File.");
                    System.out.println(" 0. Exit Summary.");

                    int summaryChoice = InputValidator.inputValidChoice(scanner);
                    if (summaryChoice == 0) {           // Exit Summary
                        System.out.println();
                        break;
                    }

                    switch (summaryChoice) {
                        case 1:             // Output the Summary in the Console
                            system.generateSummary();
                            break;

                        case 2:             // Output the Summary in the Report File
                            TxtFileHandler.writeTxtFile(system);
                            break;

                        default:            // Invalid choice
                            System.out.println("Invalid choice, please try again.");
                    }
                    break;

                case 0:             // Exit Application.
                    System.out.println("--- Thank you for using Student Management System Application!");
                    System.out.println("\t--- Exiting system...");
                    scanner.close();
                    return;

                default:            // Invalid choice
                    System.out.println("Invalid choice, please try again.\n");
            }
        }
    }
}