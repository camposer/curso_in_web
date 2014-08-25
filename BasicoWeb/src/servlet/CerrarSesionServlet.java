package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CerrarSesion")
public class CerrarSesionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().invalidate();
		
		//response.sendRedirect("/BasicoWeb/ResultadoAmbito"); // Importante! No lleva la barra
		//response.sendRedirect("http://www.insags.com"); // Importante! No lleva la barra
		response.sendRedirect("ResultadoAmbito"); // Importante! No lleva la barra
	}

}
