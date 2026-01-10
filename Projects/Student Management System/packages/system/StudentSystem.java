package packages.system;
import java.util.ArrayList;
import java.util.Comparator;

    // ---------------------------------------------- STUDENT SYSTEM CLASS ----------------------------------------------

public class StudentSystem {
    private final ArrayList<Student> studentList;

    public StudentSystem() {this.studentList = new ArrayList<>();}
    public ArrayList<Student> getStudentList() {return studentList;}

    // Method to merge another StudentSystem into this one
    public void mergeStudentSystem(StudentSystem otherSystem) {
        int nonUniqueID = 0, nonUniqueName = 0, oldSize = this.studentList.size();
        for (Student student : otherSystem.getStudentList()) {
            boolean isFound = false;
            for (Student student1 : this.studentList) {
                if (student1.ID == student.ID) {
                    nonUniqueID++;
                    isFound = true;
                    break;
                }
                if (student1.name.equals(student.name)) {
                    nonUniqueName++;
                    isFound = true;
                    break;
                }
            }
            if (!isFound) this.studentList.add(student);
        }

        if (nonUniqueID > 0) System.out.println(nonUniqueID + " students with non-unique ID(s) were not added to the system.");
        if (nonUniqueName > 0) System.out.println(nonUniqueName + " students with non-unique name(s) were not added to the system.");

        if (oldSize == 0) System.out.println("Student system Added successfully!");
        else if (this.studentList.size() > oldSize) System.out.println("Student system merged successfully!");
        else System.out.println("No new students were added to the system.");
        System.out.println();
    }

    // Sort Students by GPA, ID, Name, Department, or Year
    public void sortStudentsBy(String sortBy) {
        switch (sortBy) {
            case "GPA" ->
                    this.studentList.sort((firstStudent, secondStudent) -> Double.compare(secondStudent.GPA, firstStudent.GPA));
            case "ID" ->
                    this.studentList.sort(Comparator.comparingInt(firstStudent -> firstStudent.ID));
            case "Name" ->
                    this.studentList.sort(Comparator.comparing(firstStudent -> firstStudent.name));
            case "Department" ->
                    this.studentList.sort(Comparator.comparing(firstStudent -> firstStudent.department));
            case "Year" ->
                    this.studentList.sort(Comparator.comparingInt(student -> switch (student.year) {
                        case "First" -> 1;
                        case "Second" -> 2;
                        case "Third" -> 3;
                        case "Fourth" -> 4;
                        default -> 0;
                    }));
        }
    }

    // Add Student to the System by Providing Information or by CSV File
    public void addStudent(String newName, int newID, double newGPA, String newYear, String newDepartment, boolean byCSV) {
        Student newStudent = new Student();
        newStudent.name = newName;
        newStudent.ID = newID;
        newStudent.GPA = newGPA;
        newStudent.year = newYear;
        newStudent.department = newDepartment;
        this.studentList.add(newStudent);
        if (!byCSV) System.out.println("Student added successfully!\n");
    }

    // Remove Student by ID
    public void removeStudentByID(int ID) {
        for (int i = 0; i < this.studentList.size(); i++) {
            if (this.studentList.get(i).ID == ID) {
                this.studentList.remove(i);
                System.out.println("Student removed successfully!\n");
                return;
            }
        }
        System.out.println("Student not found!\n");
    }

    // Update Student Information Using ID
    public void updateStudentByID(int ID, String newName, double newGPA, String newYear, String newDepartment) {
        for (Student student : this.studentList) {
            if (student.ID == ID) {
                if (newName != null) student.name = newName;
                if (newGPA != -1) student.GPA = newGPA;
                if (newYear != null) student.year = newYear;
                if (newDepartment != null) student.department = newDepartment;
                System.out.println("Student updated successfully!\n");
                return;
            }
        }

        System.out.println("Student not found!\n");
    }

    // Search Student Using ID
    public void searchByID(int ID) {
        for (Student student : this.studentList) {
            if (student.ID == ID) {
                System.out.println("Student found!");
                System.out.printf("%-20s  |  %-8s  |  %-4s  |  %-6s  |  %-5s%n",
                        "Name", "ID", "GPA", "Year", "Dept");
                System.out.println("------------------------------------------------------------------");
                System.out.printf("%-20s  |  %-8s  |  %-4.2f  |  %-6s  |  %-5s%n",
                        student.name, student.ID, student.GPA, student.year, student.department);
                System.out.println();
                return;
            }
        }
        System.out.println("Student not found!\n");
    }

    // List and Sort All Students by GPA, ID, Name, Year, or Department
    public void listAndSortAllStudents(String sortBy) {
        if (this.studentList.isEmpty()) {
            System.out.println("No students found!\n");
            return;
        }

        switch (sortBy) {
            case "GPA" -> sortStudentsBy("GPA");
            case "ID" -> sortStudentsBy("ID");
            case "Name" -> sortStudentsBy("Name");
            case "Year" -> sortStudentsBy("Year");
            case "Department" -> sortStudentsBy("Department");
        }

        System.out.println("\nList of Students:");
        System.out.printf("%-20s  |  %-8s  |  %-4s  |  %-6s  |  %-5s%n",
                "Name", "ID", "GPA", "Year", "Department");
        System.out.println("---------------------------------------------------------------------");

        for (Student student : this.studentList) {
            System.out.printf("%-20s  |  %-8s  |  %-4.2f  |  %-6s  |  %-5s%n",
                    student.name, student.ID, student.GPA, student.year, student.department);
        }
        System.out.println();
    }

    // Filter Students by GPA
    public void filterByGPA(double GPA) {
        System.out.println("Students with GPA of " + GPA + ":");
        System.out.printf("%-20s  |  %-8s  |  %-4s  |  %-6s  |  %-5s%n",
                "Name", "ID", "GPA", "Year", "Dept");
        System.out.println("------------------------------------------------------------------");

        boolean isFound = false;
        for (Student student : this.studentList) {
            if (student.GPA == GPA) {
                isFound = true;
                System.out.printf("%-20s  |  %-8s  |  %-4.2f  |  %-6s  |  %-5s%n",
                        student.name, student.ID, student.GPA, student.year, student.department);
            }
        }

        if (!isFound) System.out.println("No students found with GPA of " + GPA + "!\n");
        else System.out.println();
    }

    // Filter Students by Year
    public void filterByYear(String year) {
        System.out.println("Students in " + year + " year:");
        System.out.printf("%-20s  |  %-8s  |  %-4s  |  %-6s  |  %-5s%n",
                "Name", "ID", "GPA", "Year", "Dept");
        System.out.println("------------------------------------------------------------------");

        boolean isFound = false;
        for (Student student : this.studentList) {
            if (student.year.equals(year)) {
                isFound = true;
                System.out.printf("%-20s  |  %-8s  |  %-4.2f  |  %-6s  |  %-5s%n",
                        student.name, student.ID, student.GPA, student.year, student.department);
            }
        }

        if (!isFound) System.out.println("No students found in " + year + " year!\n");
        else System.out.println();
    }

    // Filter Students by Department
    public void filterByDepartment(String department) {
        System.out.println("Students in " + department + " department:");
        System.out.printf("%-20s  |  %-8s  |  %-4s  |  %-6s  |  %-5s%n",
                "Name", "ID", "GPA", "Year", "Dept");
        System.out.println("------------------------------------------------------------------");

        boolean isFound = false;
        for (Student student : this.studentList) {
            if (student.department.equals(department)) {
                isFound = true;
                System.out.printf("%-20s  |  %-8s  |  %-4.2f  |  %-6s  |  %-5s%n",
                        student.name, student.ID, student.GPA, student.year, student.department);
            }
        }

        if (!isFound) System.out.println("No students found in " + department + " department!\n");
        else System.out.println();
    }

    // Count the Total Number of Students
    public void countTotalStudents() {
        System.out.println("The Total number of students: " + this.studentList.size());
        System.out.println();
    }

    // Calculate Average GPA
    public void calculateAverageGPA() {
        double sum = 0;
        for (Student student : this.studentList) {
            sum += student.GPA;
        }
        System.out.println("The Average GPA: " + String.format("%.2f" ,sum / this.studentList.size()));
        System.out.println();
    }

    // Display Top 5 Performing Students
    public void displayTop5() {
        sortStudentsBy("GPA");
        System.out.println("------------------------------ TOP 5 PERFORMING STUDENTS ------------------------------\n");
        int numberOfYears = 0;
        String [] years = {"First", "Second", "Third", "Fourth"};
        while (numberOfYears < 4) {     // Loop through all years to find the top 5 students.
            System.out.println(years[numberOfYears] + " Year:");
            int count = 1;
            boolean isFound = false;
            System.out.printf(" %-23s  |  %-8s  |  %-4s  |  %-6s  |  %-5s%n",
                    "Name", "ID", "GPA", "Year", "Department");
            System.out.println("-------------------------------------------------------------------------");
            for (Student student : this.studentList) {
                if (student.year.equals(years[numberOfYears]) && count <= 5 && student.GPA >= 2.0) {
                    isFound = true;
                    System.out.print(" " + (count++) + ". ");
                    System.out.printf("%-20s  |  %-8s  |  %-4.2f  |  %-6s  |  %-5s%n",
                            student.name, student.ID, student.GPA, student.year, student.department);
                }
            }
            numberOfYears++;
            if (!isFound) System.out.println(" No students found!\n");    // If there is no successful student in that year.
            else System.out.println();
        }
    }

    // Display Failing Students (GPA less than 2.0)
    public void displayFailingStudents() {
        System.out.println("-------------------- FAILING STUDENTS (who have GPA less than 2.0) --------------------\n");
        int numberOfYears = 0;
        String [] years = {"First", "Second", "Third", "Fourth"};
        while (numberOfYears < 4) {     // Loop through all years to find failing students.

            System.out.println(years[numberOfYears] + " Year:");
            System.out.printf(" %-20s  |  %-8s  |  %-4s  |  %-6s  |  %-5s%n",
                    "Name", "ID", "GPA", "Year", "Department");
            System.out.println("----------------------------------------------------------------------");

            boolean isFailing = false;
            for (Student student : this.studentList) {
                if (student.year.equals(years[numberOfYears]) && student.GPA < 2.0) {
                    isFailing = true;
                    System.out.printf(" %-20s  |  %-8s  |  %-4.2f  |  %-6s  |  %-5s%n",
                            student.name, student.ID, student.GPA, student.year, student.department);
                }
            }

            numberOfYears++;
            if (!isFailing) System.out.println(" No failing students found!\n");    // If no failing students found in that year
            else System.out.println();
        }
        System.out.println();
    }

    // Count Students by Year and Calculate Success Rate (GPA >= 2.0).
    public void countStudentsByYear() {
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

        System.out.println("Year-wise Student Count:");
        System.out.println(" - First Year: " + totalFirst + ", With Success rate of " + String.format("%.3f" ,successfulFirst * 100.0 / totalFirst) + "%");
        System.out.println(" - Second Year: " + totalSecond + ", With Success rate of " + String.format("%.3f" ,successfulSecond * 100.0 / totalSecond) + "%");
        System.out.println(" - Third Year: " + totalThird + ", With Success rate of " + String.format("%.3f" ,successfulThird * 100.0 / totalThird) + "%");
        System.out.println(" - Fourth Year: " + totalFourth + ", With Success rate of " + String.format("%.3f" ,successfulFourth * 100.0 / totalFourth) + "%");
        System.out.println();
    }

    // Generate Class Performance Summary
    public void generateSummary() {
        if (this.studentList.isEmpty()) {
            System.out.println("No students found!\n");
            return;
        }

        System.out.println("\n------------------------------ CLASS PERFORMANCE ------------------------------\n");
        calculateAverageGPA();
        countTotalStudents();
        countStudentsByYear();
        displayTop5();
        displayFailingStudents();
    }
}
