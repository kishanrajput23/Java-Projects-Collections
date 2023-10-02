import java.io.*;
import java.net.*;
class ClientProgram {
    public static void main(String args[]) throws Exception {
        Socket s=new Socket("localhost",1111); //you use any port available. Make sure to have the same port in both files.
        PrintStream ps=new PrintStream(s.getOutputStream());
        BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
        BufferedReader kb=new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String str,str1;
            System.out.print("Client: ");
            str=kb.readLine();
            if(str.equals("exit")) {
                break;
            }
            else {
                ps.println(str);
                str1=br.readLine();
                System.out.println("Server: " + str1);
            }
        }
        ps.close();
        br.close();
        kb.close();
        s.close();
    }
}
