package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HolaMundoServlet
 */
@WebServlet({ 
	"/HolaMundoServlet", 
	"/HolaMundo", 
	"/hola/mundo",
	"/inicio"
})
// http://localhost:8080/BasicoWeb/HolaMundo
public class HolaMundoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter contenedor = 
				response.getWriter(); // Dame el contenedor
		// Llenando el contenedor
		contenedor.println("<html>");
		contenedor.println("<head>");
		contenedor.println("<title>Hola mundo!</title>");
		contenedor.println("</head>");
		contenedor.println("<body>");
		contenedor.println("Hola mundo desde el servlet!");
		contenedor.println("</body>");
		contenedor.println("</html>");
		contenedor.flush(); // Enviando el contenedor al cliente
	}

}
