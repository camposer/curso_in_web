package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AmbitoForm")
public class AmbitoFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		pw.println("<html>");
		pw.println("<head><title>Ámbitos</title></head>");
		pw.println("<body>");
		pw.println("<form action='ResultadoAmbito' method='post'>");
		pw.println("<input type='text' name='nombre'/>");
		pw.println("<input type='submit' value='clic'/>");
		pw.println("</form>");
		pw.println("</body>");
		pw.println("</html>");
	}

}
