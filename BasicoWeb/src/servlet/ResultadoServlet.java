package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResultadoServlet
 */
@WebServlet("/Resultado")
public class ResultadoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Extrayendo parámetros de la petición (request)
		String nombre = request.getParameter("nombre");
		String sedad = request.getParameter("edad");
		System.out.println("edad: "+ sedad);
		
		int edad;
		try {
			edad = Integer.parseInt(sedad);
		} catch (NumberFormatException e) {
			// TODO Redireccionar a otra página...
			edad = 0;
			e.printStackTrace();
		}
		
		PrintWriter pw = response.getWriter();
		pw.println("<html>");
		
		pw.println("<head>");
		pw.println("<title>Resultado</title>");
		pw.println("</head>");
		
		pw.println("<body>");

		pw.println("Hola " + nombre);
		pw.println("<br/>");

		if (edad >= 18)
			pw.println("Puedes manejar!");
		else
			pw.println("Transporte público contigo");
		
		pw.println("</body>");
		pw.println("</html>");
		
		
	}

	/*
	@Override
	protected void doPost(
			HttpServletRequest req, 
			HttpServletResponse resp)
			throws ServletException, IOException {
		
		doGet(req, resp);
	}
	*/
}
