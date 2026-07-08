package Atm;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;



public class LoginServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String user = request.getParameter("username");
        out.println("Login Servlet Working ✔<br>");
        out.println("Username: " + user + "<br>");
    }
}