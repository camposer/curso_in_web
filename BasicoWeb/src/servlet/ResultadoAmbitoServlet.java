package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(
		urlPatterns = { "/ResultadoAmbito" }, 
		initParams = { 
				@WebInitParam(name = "uno", value = "1"), 
				@WebInitParam(name = "dos", value = "2", description = "Esto es un texto opcional")
		})
public class ResultadoAmbitoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String nombre = request.getParameter("nombre");
		String nombre = (String)request.getAttribute("nombre");
		HttpSession session = request.getSession();
		ServletContext global = getServletContext();
		ServletConfig config = getServletConfig();
		
		if (nombre != null) {
			request.setAttribute("nombre", nombre);
			session.setAttribute("nombre", nombre);
			global.setAttribute("nombre", nombre);
		}
		
		PrintWriter pw = response.getWriter();
		pw.println("<html>");
		pw.println("<head><title>Ámbitos</title></head>");
		pw.println("<body>");

		pw.println("El nombre en request es: " + 
				request.getAttribute("nombre") + "<br/>");
		
		pw.println("El nombre en session es: " + 
				session.getAttribute("nombre") + "<br/>");

		pw.println("El nombre en global es: " + 
				global.getAttribute("nombre") + "<br/>");
		
		pw.println("Init parameter uno es: " + 
				config.getInitParameter("uno") + "<br/>");

		pw.println("Init parameter dos es: " + 
				config.getInitParameter("dos") + "<br/>");

		pw.println("<a href='CerrarSesion'>Cerrar sesión</a>");
		pw.println("</body>");
		pw.println("</html>");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
}
