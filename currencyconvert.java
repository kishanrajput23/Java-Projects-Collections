import java.io.*;
import java.net.*;
import java.util.StringTokenizer;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.google.gson.Gson;

@WebServlet("/CurrencyConverter")
public class CurrencyConverter extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String query = "";
        String amount = "";
        String curTo = "";
        String curFrom = "";
        String res = "";

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        /* Read request parameters */
        amount = request.getParameter("amount");
        curTo = request.getParameter("to");
        curFrom = request.getParameter("from");

        /* Open a connection to Google and read the result */
        try {
            query = "http://www.google.com/ig/calculator?hl=en&q=" + amount + curFrom + "=?" + curTo;
            URL url = new URL(query);

            try (InputStreamReader stream = new InputStreamReader(url.openStream());
                 BufferedReader in = new BufferedReader(stream)) {

                String str = "";
                String temp = "";

                while ((temp = in.readLine()) != null) {
                    str = str + temp;
                }

                /* Parse the result which is in JSON format */
                Gson gson = new Gson();
                Recv st = gson.fromJson(str, Recv.class);
                String rhs = st.getRhs();
                rhs = rhs.replace("�", "");

                /* Check if there are additional words (millions, billions, etc.) and print them */
                StringTokenizer strto = new StringTokenizer(rhs);
                String nextToken = strto.nextToken();
                out.write(nextToken);

                nextToken = strto.nextToken();
                if (nextToken.equals("million") || nextToken.equals("billion") || nextToken.equals("trillion")) {
                    out.println(" " + nextToken);
                }
            }
        } catch (NumberFormatException e) {
            out.println("The given amount is not a valid number");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
