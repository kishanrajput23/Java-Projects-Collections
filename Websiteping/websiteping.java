import java.net.InetAddress;

public class PingExample {
    public static void main(String[] args) {
        String host = "www.google.com"; 

        try {
            InetAddress inetAddress = InetAddress.getByName(host);
            long startTime = System.currentTimeMillis();

            if (inetAddress.isReachable(5000)) {
                long endTime = System.currentTimeMillis();
                long pingTime = endTime - startTime;
                System.out.println("Ping for " + host + " Successful. Time: " + pingTime + "ms");
            } else {
                System.out.println("Unable to ping host " + host);
            }
        } catch (Exception e) {
            System.out.println("Error pinging host " + host + ": " + e.getMessage());
        }
    }
}
