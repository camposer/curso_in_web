package servlet.persona;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/persona/Inicio")
public class InicioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Buscar personas en la BD
		// TODO Pasar personas recuperadas como atributo a la JSP
		
		request
			.getRequestDispatcher("/jsp/persona/inicio.jsp")
			.forward(request, response);
	}

}
