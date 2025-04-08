package packages.fileHandler;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import packages.system.*;

    // --------------------------------- TXT FILE HANDLER CLASS ---------------------------------

public class TxtFileHandler {
    private static final String OUTPUT_TXT_FILE = "Final_Report.txt";

    // Write the student system to a txt file
    public static void writeTxtFile(StudentSystem students) {
        try (FileWriter writer = new FileWriter(OUTPUT_TXT_FILE)) {
            if (students.getStudentList().isEmpty()) {
                System.out.println("\nNo students to write to txt file.\n");
                return;
            }

            writer.write("------------------------------ CLASS PERFORMANCE ------------------------------\n");
            students.sortStudentsBy("GPA");
            ArrayList<Student> studentList = students.getStudentList();

            // ------------------------ Total Number of Students and Average GPA ------------------------

            writer.write("\nThe Total number of students: " + studentList.size());
            writer.write("\n\n");

            // ------------------------ Average GPA ------------------------

            double sum = 0;
            for (Student student : studentList) {
                sum += student.GPA;
            }
            writer.write("The Average GPA: " + String.format("%.2f" ,sum / studentList.size()));
            writer.write("\n\n");

            // ------------------------ Year-wise Student Count and Success Rate ------------------------

            int totalFirst = 0, totalSecond = 0, totalThird = 0, totalFourth = 0;
            int successfulFirst = 0, successfulSecond = 0, successfulThird = 0, successfulFourth = 0;
            for (Student student : studentList) {
                switch (student.year) {
                    case "First" -> {
                        totalFirst++;
                        if (student.GPA >= 2.0) successfulFirst++;
                    }
                    case "Second" -> {
                        totalSecond++;
                        if (student.GPA >= 2.0) successfulSecond++;
                    }
                    case "Third" -> {
                        totalThird++;
                        if (student.GPA >= 2.0) successfulThird++;
                    }
                    case "Fourth" -> {
                        totalFourth++;
                        if (student.GPA >= 2.0) successfulFourth++;
                    }
                }
            }

            writer.write("Year-wise Student Count:");
            writer.write("\n - First Year: " + totalFirst + ", With Success rate of " + String.format("%.3f" ,successfulFirst * 100.0 / totalFirst) + "%");
            writer.write("\n - Second Year: " + totalSecond + ", With Success rate of " + String.format("%.3f" ,successfulSecond * 100.0 / totalSecond) + "%");
            writer.write("\n - Third Year: " + totalThird + ", With Success rate of " + String.format("%.3f" ,successfulThird * 100.0 / totalThird) + "%");
            writer.write("\n - Fourth Year: " + totalFourth + ", With Success rate of " + String.format("%.3f" ,successfulFourth * 100.0 / totalFourth) + "%");
            writer.write("\n\n");

            // ------------------------ Top 5 Performing Students and Failing Students ------------------------

            writer.write("------------------------------ TOP 5 PERFORMING STUDENTS ------------------------------\n\n");
            int numberOfYears = 0;
            String [] years = {"First", "Second", "Third", "Fourth"};

            while (numberOfYears < 4) {         // Loop through all years to find the top 5 students.
                writer.write(years[numberOfYears] + " Year:\n");
                writer.write(String.format(" %-23s  |  %-8s  |  %-4s  |  %-6s  |  %-5s%n",
                        "Name", "ID", "GPA", "Year", "Department"));
                writer.write("-------------------------------------------------------------------------\n");

                int count = 1;
                for (Student student : studentList) {
                    if (student.year.equals(years[numberOfYears]) && count <= 5 && student.GPA >= 2.0) {
                        writer.write(" " + (count++) + ". ");
                        writer.write(String.format("%-20s  |  %-8s  |  %-4.2f  |  %-6s  |  %-5s%n",
                                student.name, student.ID, student.GPA, student.year, student.department));
                    }
                }
                numberOfYears++;
                writer.write("\n");
            }

            // ------------------------ Failing Students ------------------------

            writer.write("-------------------- FAILING STUDENTS (who have GPA less than 2.0) --------------------\n\n");
            numberOfYears = 0;

            while (numberOfYears < 4) {     // Loop through all years to find failing students.
                writer.write(years[numberOfYears] + " Year:\n");
                writer.write(String.format(" %-20s  |  %-8s  |  %-4s  |  %-6s  |  %-5s%n",
                        "Name", "ID", "GPA", "Year", "Department"));
                writer.write("----------------------------------------------------------------------\n");

                boolean isFailing = false;
                for (Student student : studentList) {
                    if (student.year.equals(years[numberOfYears]) && student.GPA < 2.0) {
                        isFailing = true;
                        writer.write(String.format(" %-20s  |  %-8s  |  %-4.2f  |  %-6s  |  %-5s%n",
                                student.name, student.ID, student.GPA, student.year, student.department));
                    }
                }

                if (!isFailing) writer.write(" No failing students found!\n");      // If no failing students found in that year
                else writer.write("\n");
                numberOfYears++;
            }

            writer.flush();
            System.out.println("\nTxt file written successfully.");
            System.out.println("File Path: " + OUTPUT_TXT_FILE);
        }

        catch (IOException e) {
            System.err.println("Error writing Txt file: " + e.getMessage());
        }
        System.out.println();
    }
}
