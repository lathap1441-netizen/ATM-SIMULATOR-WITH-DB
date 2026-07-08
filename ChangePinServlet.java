package Atm;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class ChangePinServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String account = request.getParameter("accountno");
        String newPin = request.getParameter("newpin");

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                    "UPDATE account SET pin=? WHERE accountno=?");

            ps.setString(1, newPin);
            ps.setString(2, account);

            int i = ps.executeUpdate();

            if (i > 0) {
                out.println("<h2>PIN Changed Successfully</h2>");
            } else {
                out.println("<h2>Account Not Found</h2>");
            }

            out.println("<br><a href='dashboard.html'>Back to Dashboard</a>");

            con.close();

        } catch (Exception e) {
            out.println(e);
        }
    }
}