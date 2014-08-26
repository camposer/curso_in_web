package servlet.persona;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/persona/Agregar")
public class AgregarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Valida los datos que vienen en la petición (must)
		
		// TODO Qué pasa si los datos validados son incorrectos?
		
		// TODO Agrega la persona (llama al servicio) (must)
		
		// TODO Qué pasa si hay un error al agregar la persona en BD?
		
		// TODO Redirecciona el flujo a la acción /persona/Inicio
	}

}
