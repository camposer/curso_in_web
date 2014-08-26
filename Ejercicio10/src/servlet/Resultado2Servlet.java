package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import to.PersonaTo;

@WebServlet("/Resultado2")
/**
 * Valida los datos de la petición que vienen del formulario
 * en /Persona2 y luego:
 * Si hubo error: define un atributo errores en la petición
 * Si no hubo error: define un atributo persona en la petición
 * 
 * El atributo persona contiene nombre, apellido, edad y comentario (si la persona puede jubilarse o no)
 * 
 * Finalmente devuelve el control (forward) a /Persona2 (que es quien pinta en pantalla!!!)
 */
public class Resultado2Servlet extends HttpServlet {
	private static final int EDAD_JUBILACION = 65;
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		
		String mensaje = (edad - EDAD_JUBILACION > 0)
				?"Eres un máquina":"A currar!"; 
				
		// Agrega atributos a la petición (request)
		if (errores.size() > 0)
			request.setAttribute("errores", errores);
		else 
			request.setAttribute("persona", 
					new PersonaTo(nombre, apellido, edad, mensaje));
		
		// Redireccionando para imprimir los datos
		request.getRequestDispatcher("/persona2.jsp")
			.forward(request, response);
	}
}
