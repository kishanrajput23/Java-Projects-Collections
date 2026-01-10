import java.util.*;
public class AttendancePercentage {
    public static void main(String[] args) {
        int[] attendanceData = {1,1,1,0,1,1,1,1,1,1,0,0,1,1,1,0,1,1,1,0,1};
        int totalClassesAttended = 0;
        for (int attendance : attendanceData) {
            if (attendance == 1) {
                totalClassesAttended++;
            }
        }
        double attendancePercentage = (double) totalClassesAttended / attendanceData.length * 100;
        System.out.println("The attendance percentage is " + attendancePercentage + "%");
    }
}
