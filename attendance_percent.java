import java.util.*;

public class AttendancePercentage {

    public static void main(String[] args) {

        // Create an array to store the attendance data
        int[] attendanceData = {1,1,1,0,1,1,1,1,1,1,0,0,1,1,1,0,1,1,1,0,1};

        // Calculate the total number of classes attended
        int totalClassesAttended = 0;
        for (int attendance : attendanceData) {
            if (attendance == 1) {
                totalClassesAttended++;
            }
        }

        // Calculate the attendance percentage
        double attendancePercentage = (double) totalClassesAttended / attendanceData.length * 100;

        // Display the attendance percentage
        System.out.println("The attendance percentage is " + attendancePercentage + "%");
    }
}
