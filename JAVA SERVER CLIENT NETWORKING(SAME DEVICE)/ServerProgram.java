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
        while(true) {
            String str=br.readLine();
            String str1;
            if(str.equals("exit")) {
                break;
            }
            else {
                System.out.println("Client: "+str);
                System.out.print("Server: ");
                str1=kb.readLine();
                ps.println(str1);
            }
        }
        ps.close();
        br.close();
        kb.close();
        s.close();
        ss.close();
    }
}
