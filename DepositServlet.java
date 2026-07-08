package Atm;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class DepositServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String amount = request.getParameter("amount");

        out.println("<html><body>");
        out.println("<h2>Deposit Successful</h2>");
        out.println("<p>Amount Deposited: ₹ " + amount + "</p>");
        out.println("<br><a href='dashboard.html'>Back to Dashboard</a>");
        out.println("</body></html>");
    }
}