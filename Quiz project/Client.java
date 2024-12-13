import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

class Client {
    public static void main(String[] args) {
        int port = 999;
        System.out.print("Enter your Participant ID (1/2/3): ");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        scanner.nextLine();
        port += id;
        Socket socket = null;
        try {
            socket = new Socket("localhost", port);
        } catch (Exception e) {
            System.out.println("!! ERROR while Connecting to the Server !!");
            System.out.println("** Host has not yet created the Quiz, Host should connect first **");
            System.exit(1);
        }
        System.out.println("Connected to server..");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        try {
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            dataOutputStream.writeUTF(name);
            int total_ques = dataInputStream.readInt();
            int time_per_ques = dataInputStream.readInt();
            for (int i = 0; i < total_ques; i++) {
                String ques = dataInputStream.readUTF();
                String options = dataInputStream.readUTF();
                System.out.println(ques);
                System.out.println(options);
                timer t = new timer();
                String ans = t.getInput(time_per_ques);
                dataOutputStream.writeUTF(ans);
            }

            System.out.println("!! You had successfully completed the Quiz !!");
            System.out.println("***Contact the owner for Final Score***");
            socket.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
