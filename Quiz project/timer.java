import java.util.Timer;
import java.util.TimerTask;
import java.io.*;

public class timer {
    private String str = "", str2 = "";
    BufferedReader in;
    Timer timer = new Timer();
    boolean hasRun = false;

    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            hasRun = true;
            if (str.equals("")) {
                System.out.println("you had enter nothing. Press 'Enter' to proceed to next ques.");
                System.out.println("------------------------------------------");
            }
            timer.cancel();
        }
    };

    public String getInput(int seconds) throws IOException {
        timer.schedule(task, seconds * 1000);
        System.out.println("Answer within " + seconds + " seconds: ");
        System.out.print("Your ans: ");
        in = new BufferedReader(new InputStreamReader(System.in));
        str2 = in.readLine();
        if (!hasRun) {
            timer.cancel();
            str = str2;
        }
        System.out.println("------------------------------------------");
        return str;
    }

}