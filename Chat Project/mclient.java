import java.util.*;
import java.net.*;
import java.io.*;

public class mclient {

    public static void main(String s[]) throws Exception {
        Socket s1 = null;
        String line = null;
        DataInputStream br = null;
        DataInputStream is = null;
        PrintWriter os = null;
        try {
            s1 = new Socket("localhost", 9999);
            br = new DataInputStream(System.in);
            is = new DataInputStream(s1.getInputStream());
            os = new PrintWriter(s1.getOutputStream());

        } catch (IOException e) {
            System.err.print("IO Exception");

        }
        System.out.println("Enter data to server (enter QUIT to end) :-> "+s1.getRemoteSocketAddress().toString());
        String res = null;
        try {
            line = br.readLine();
            while (line.compareTo("QUIT") != 0) {
                os.println(line);
                os.flush();
                res = is.readLine();
                System.out.println("server response :-> " + res);
                line = br.readLine();
            }
            is.close();
            os.close();
            br.close();
            s1.close();
            System.out.println("close connection ");
        } catch (IOException e) {
            System.out.println("socket read error");
        }
    }
}
