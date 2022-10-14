import java.util.*;
import java.net.*;
import java.io.*;

public class mserver {

    public static void main(String s[]) throws Exception {
        Socket sa = null;
        ServerSocket ss2 = null;
        System.out.println("Host starts accepting response ");
        try {
            ss2 = new ServerSocket(9999);
        } catch (IOException e) {
            System.out.println("server error");
        }
        while (true) {
            try {
                sa = ss2.accept();
                System.out.println("connetion established by"+ ss2.getInetAddress());
                ServerThread st = new ServerThread(sa);
                st.start();
            } catch (Exception e) {
                System.out.println("connetion error");
            }
        }
    }
}

class ServerThread extends Thread {
    String line = null;
    DataInputStream is = null;
    PrintWriter od = null;
    Socket s1 = null;

    public ServerThread(Socket s) {
        s1 = s;
    }
+
    public void run() {
        try {

            is = new DataInputStream(s1.getInputStream());
            od = new PrintWriter(s1.getOutputStream());

            line = is.readLine();

            while (!line.equals("QUIT")) {
                od.println(line);
                od.flush();

                System.out.println("response to client " + line);
                line = is.readLine();

            }
            is.close();
            od.close();
            s1.close();

        } catch (IOException ie) {
            System.out.println("socket close error");
        }
    }
}