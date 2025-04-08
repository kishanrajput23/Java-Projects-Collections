package packages.fileHandler;

import java.io.*;
import java.util.Scanner;
import packages.system.*;

    // --------------------------------- CSV FILE HANDLER CLASS ---------------------------------

public class CsvFileHandler {
    private static final String OUTPUT_CSV_FILE = "Final_Students.csv";

    // Convert a CSV line to a Student object
    public static Student fromCSV(String csvLine) {
        csvLine = csvLine.replaceAll("\"", "");
        String[] parts = csvLine.split(",");

        return new Student(
                Integer.parseInt(parts[0]),     // ID
                parts[1],                       // Name
                Double.parseDouble(parts[2]),   // GPA
                parts[3],                       // Year
                parts[4]                        // Department
        );
    }

    // Read the student system from a csv file
    public static StudentSystem readCsvFile() {
        StudentSystem students = new StudentSystem();
        Scanner scanner = new Scanner(System.in);
        String INPUT_CSV_FILE = InputValidator.getFilePath(scanner, ".csv");


        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_CSV_FILE))) {
            String line;
            boolean firstLine = true;

            while ((line = reader.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                Student student = fromCSV(line);
                boolean isUnique = true;
                for (Student s : students.getStudentList()) {
                    if (s.ID == student.ID || s.name.equals(student.name)) {
                        isUnique = false;
                        break;
                    }
                }

                if (isUnique) {
                    if (student.year.equals("First") || student.year.equals("Second")) student.department = "General";
                    students.addStudent(student.name, student.ID, student.GPA, student.year, student.department, true);
                }
            }

            System.out.println("\nCSV file read successfully.\n");
        }
        catch (IOException e) {
            System.err.println("\nError reading CSV file: " + e.getMessage());
            System.out.println();
        }
        return students;
    }

    // Write the student system to a csv file
    public static void writeCsvFile(StudentSystem students) {
        try (FileWriter writer = new FileWriter(OUTPUT_CSV_FILE)) {
            if (students.getStudentList().isEmpty()) {
                System.out.println("\nNo students to write to CSV file.\n");
                return;
            }

            students.sortStudentsBy("ID");

            writer.write("\"ID\",\"Name\",\"GPA\",\"Year\",\"Department\"\n");
            for (Student student : students.getStudentList()) {
                writer.write("\"" + student.ID + "\",");
                writer.write("\"" + student.name + "\",");
                writer.write("\"" + student.GPA + "\",");
                writer.write("\"" + student.year + "\",");
                writer.write("\"" + student.department + "\"\n");
            }
            writer.flush();
            System.out.println("\nCSV file written successfully.");
            System.out.println("File Path: " + OUTPUT_CSV_FILE);
        }
        catch (IOException e) {
            System.err.println("Error writing CSV file: " + e.getMessage());
        }
        System.out.println();
    }
}
