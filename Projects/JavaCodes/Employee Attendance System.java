import java.util.*;
import java.text.SimpleDateFormat;

class Employee {
    private String name;
    private int id;
    private List<String> attendance;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
        this.attendance = new ArrayList<>();
    }

    public void markAttendance() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        attendance.add(dateFormat.format(date));
    }

    public List<String> getAttendance() {
        return attendance;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}

public class AttendanceSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();
        int employeeIdCounter = 1;

        while (true) {
            System.out.println("Employee Attendance System Menu:");
            System.out.println("1. Add Employee");
            System.out.println("2. Mark Attendance");
            System.out.println("3. View Attendance");
            System.out.println("4. Exit");
            System.out.print("Select an option (1/2/3/4): ");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    scanner.nextLine();
                    System.out.print("Enter the employee's name: ");
                    String name = scanner.nextLine();
                    employees.add(new Employee(employeeIdCounter, name));
                    employeeIdCounter++;
                    System.out.println("Employee added successfully.");
                    break;
                case 2:
                    System.out.print("Enter employee ID to mark attendance: ");
                    int employeeId = scanner.nextInt();
                    Employee employee = findEmployeeById(employees, employeeId);
                    if (employee != null) {
                        employee.markAttendance();
                        System.out.println("Attendance marked for " + employee.getName());
                    } else {
                        System.out.println("Employee not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter employee ID to view attendance: ");
                    int idToView = scanner.nextInt();
                    Employee empToView = findEmployeeById(employees, idToView);
                    if (empToView != null) {
                        List<String> attendance = empToView.getAttendance();
                        if (attendance.isEmpty()) {
                            System.out.println(empToView.getName() + " has no attendance records.");
                        } else {
                            System.out.println("Attendance records for " + empToView.getName() + ":");
                            for (String record : attendance) {
                                System.out.println(record);
                            }
                        }
                    } else {
                        System.out.println("Employee not found.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting the Attendance System.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please select 1, 2, 3, or 4.");
            }
        }
    }

    private static Employee findEmployeeById(List<Employee> employees, int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }
}
