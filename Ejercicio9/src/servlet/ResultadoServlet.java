package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Resultado")
public class ResultadoServlet extends HttpServlet {
	private static final int EDAD_JUBILACION = 65;
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Cabecera
		request
			.getRequestDispatcher("/Cabecera")
			.include(request, response);

		// Contenido
		List<String> errores = new ArrayList<String>();

		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String sedad = request.getParameter("edad");
		int edad = 0;
	
		// Validar
		if (nombre.trim().equals(""))
			errores.add("Nombre inválido");
		if (apellido.trim().equals(""))
			errores.add("Apellido inválido");
		
		try {
			edad = Integer.parseInt(sedad);
		} catch (NumberFormatException e) {
			errores.add("Edad inválida");
			e.printStackTrace();
		}
		
		// Imprimir resultados
		PrintWriter pw = response.getWriter();
		if (errores.size() == 0) {
			pw.println("Nombre: " + nombre + "<br/>");
			pw.println("Apellido: " + apellido + "<br/>");
			pw.println("Edad: " + edad + "<br/>");
			
			int anios = EDAD_JUBILACION - edad;
			if (anios <= 0) // Eres un máquina
				pw.println("<div style='color: green'>Eres un máquina!</div>");
			else  // A currar
				pw.println("<div style='color: violet'>A currar!</div>");
		} else { 
			// Imprimiendo errores 
			pw.println("<div style='background-color: red'>");
			for (String e : errores) {
				pw.println(e + "<br/>");
			}
			pw.println("</div>");
		}

		pw.println("<a href='Persona' >Volver</a>");
		
		// Pie
		request
			.getRequestDispatcher("/Pie")
			.include(request, response);

	
	}

}
