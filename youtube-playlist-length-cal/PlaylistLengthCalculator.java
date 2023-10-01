public class PlaylistLengthCalculator {
    public static void main(String[] args) {
        // Define the durations of songs in seconds
        int[] videoDuration = {240, 180, 210, 300, 150, 270}; // Example durations in seconds

        // Calculate the total length of the playlist
        int totalLengthInSeconds = calculateTotalLength(videoDuration);

        // Convert the total length to hours, minutes, and seconds
        int hours = totalLengthInSeconds / 3600;
        int minutes = (totalLengthInSeconds % 3600) / 60;
        int seconds = totalLengthInSeconds % 60;

        // Display the total length of the playlist
        System.out.println("Total Playlist Length: " + hours + " hours, " + minutes + " minutes, " + seconds + " seconds");
    }

    public static int calculateTotalLength(int[] durations) {
        int totalDuration = 0;
        for (int duration : durations) {
            totalDuration += duration;
        }
        return totalDuration;
    }
}
