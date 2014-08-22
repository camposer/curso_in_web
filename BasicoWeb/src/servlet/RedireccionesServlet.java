package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Redirecciones")
public class RedireccionesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = 
				response.getWriter(); // Dame el contenedor

		// Cabecera
		// Entrega el control a Cabecera y regresa
		request
			.getRequestDispatcher("/Cabecera")
			.include(request, response); 
		
		// Contenido
		pw.println("<form action='ProcesarRedirecciones'>");
		pw.println("<div id='contenido'>");
		
		String error = (String)request.getAttribute("error");
		String mensaje = (String)request.getAttribute("mensaje");
		if (error != null) {
			pw.println("<div style='color: red'>");
			pw.println(error);
			pw.println("</div>");
		} else if (mensaje != null) {
			pw.println("<div style='color: green'>");
			pw.println(mensaje);
			pw.println("</div>");
			
		}
		
		pw.println("Nombre: ");
		pw.println("<input type='text' name='nombre'/>");
		pw.println("<input type='submit' value='Clic'/>");
		pw.println("</div>");
		pw.println("</form>");

		// Pie
		request
			.getRequestDispatcher("/Pie")
			.include(request, response);
		
		
	}
}

