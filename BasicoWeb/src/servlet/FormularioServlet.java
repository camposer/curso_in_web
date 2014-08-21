package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormularioServlet
 */
@WebServlet("/Formulario")
public class FormularioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		pw.println("<html>");
		
		pw.println("<head>");
		pw.println("<title>Formulario</title>");
		pw.println("<script>");
		pw.println("var validar = function() {");
		pw.println("	var edad = document.getElementById('edad').value;");
		pw.println("	var parse = parseInt(edad);");
		pw.println("	if (isNaN(parse)) {");
		pw.println("		alert('Edad debe ser un número');");
		pw.println("		return false;");
		pw.println("	} else");
		pw.println("		return true;");
		pw.println("};");
		pw.println("</script>");
		pw.println("</head>");
		
		pw.println("<body>");
		
		pw.println("<form method='post' action='Resultado'>");
		
		pw.println("Nombre: ");
		pw.println("<input type='text' name='nombre'/>");
		pw.println("<br/>");
		pw.println("Edad: ");
		pw.println("<input type='text' id='edad' name='edad'/>");
		pw.println("<input type='submit' value='Clic' onclick='return validar()'/>");
		
		pw.println("</form>");
		
		pw.println("</body>");
		pw.println("</html>");
	}

}
