import java.io.*;
import java.net.*;
class ServerProgram {
    public static void main(String args[]) throws Exception {
        ServerSocket ss=new ServerSocket(1111); //you use any port available. Make sure to have the same port in both files.
        Socket s=ss.accept();
        System.out.println("Connection Estabished");
        PrintStream ps=new PrintStream(s.getOutputStream());
        BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
        BufferedReader kb=new BufferedReader(new InputStreamReader(System.in));
           try {
            while (true) {
                String str = br.readLine(); 
                if (str == null || str.equals("exit")) {
                    break; 
                }
                System.out.println("Cliente: " + str);

                System.out.print("Servidor: ");
                String str1 = kb.readLine();
                ps.println(str1);
            }
        } catch (IOException e) {
            System.out.println("Communication error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
                if (br != null) br.close();
                if (kb != null) kb.close();
                if (s != null) s.close();
                if (ss != null) ss.close();
            } catch (IOException e) {
                System.out.println("Error closing resources: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
