import java.util.Scanner;

public class Main extends Host{
    public static void main(String[] args) {

        Host Host_obj = new Main();

        synchronized (Host_obj) {

            // select subject
            Host_obj.subject();

            // select questions
            boolean Questions = Host_obj.questions();
            if (Questions) {
                System.out.println("Successfully selected " + question_setter.ques + " questions for the Quiz..");
            } else {
                System.out.println("!! Unable to select questions !!");
            }

            // select time for each question
            System.out.print("Enter time(in seconds) for each question : ");
            int time;
            Scanner scan = new Scanner(System.in);

            time = scan.nextInt();
            Host_obj.time(time);
            
            System.out.println("Waiting for participants to connect..");

            // Creating ClientThreads and connect to server.
            ClientThread.initialise(question_setter.ques, Set_time.t);
            ClientThread clientThread = new ClientThread(1000);
            ClientThread clientThread1 = new ClientThread(1001);
            ClientThread clientThread2 = new ClientThread(1002);

            clientThread.start();
            clientThread1.start();
            clientThread2.start();
        }
    }
}