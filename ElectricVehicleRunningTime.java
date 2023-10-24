public class ElectricVehicleRunningTime {

    public static void main(String[] args) {

        // Create an array to store the on and off times of the electric vehicle
        int[] evTimes = {850, 945, 1145, 1155, 1230, 1245, 1330, 1340, 1425, 1445};

        // Calculate the total running time in minutes
        int runningTime = 0;
        for (int i = 1; i < evTimes.length; i += 2) {
            runningTime += evTimes[i] - evTimes[i - 1];
        }

        // Convert the running time to hours and minutes
        int hours = runningTime / 60;
        int minutes = runningTime % 60;

        // Display the running time
        System.out.println("The running time of the electric vehicle is " + hours + " hour(s) and " + minutes + " minute(s).");
    }
}