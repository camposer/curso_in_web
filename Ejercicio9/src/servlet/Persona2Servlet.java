package servlet;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import to.PersonaTo;

@WebServlet("/Persona2")
public class Persona2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Cabecera
		request
			.getRequestDispatcher("/Cabecera")
			.include(request, response);
			
		// Cuerpo
		response.setContentType("text/html; charset=UTF-8"); // Cambia la codificación de ISO (por defecto) a UTF-8
		//PrintWriter pw = new PrintWriter(new OutputStreamWriter(out, "utf-8"));
		PrintWriter pw = response.getWriter();
		
		// TODO Incluir div!
		List<String> errores = (List<String>)request.getAttribute("errores");
		PersonaTo persona = (PersonaTo)request.getAttribute("persona");
		
		if (errores != null) { // Hay errores por imprimir
			pw.println("   <div style='color: red'>");
			for (String e : errores) {
				pw.println(e + "<br/>");
			}
			pw.println("   </div>");
		} else if (persona != null) { // Hay una persona por imprimir
			pw.println("   <div style='color: green'>");
			pw.println("   	Nombre: " + persona.getNombre() + "<br/>");
			pw.println("   	Apellido: " + persona.getApellido() + "<br/>");
			pw.println("   	Edad: " + persona.getEdad() + "<br/>");
			pw.println("	<b>" + persona.getMensaje() + "</b><br/>");			
			pw.println("   </div>");
		}
		
		pw.println("   <form action='Resultado2' method='post'>");
		pw.println("      <table>");
		pw.println("         <tr>");
		pw.println("            <td>Nombre:</td>");
		pw.println("            <td><input type='text' name='nombre' id='nombre'/></td>");
		pw.println("         </tr>");
		pw.println("         <tr>");
		pw.println("            <td>Apellido:</td>");
		pw.println("            <td><input type='text' name='apellido' id='apellido'/></td>");
		pw.println("         </tr>");
		pw.println("         <tr>");
		pw.println("            <td>Edad:</td>");
		pw.println("            <td><input type='text' name='edad' id='edad'/></td>");
		pw.println("         </tr>");
		pw.println("         <tr>");
		pw.println("            <td colspan='2'>");
		pw.println("               <input type='submit' value='Enviar'/>");
		pw.println("            </td>");
		pw.println("         </tr>");
		pw.println("      </table>");
		pw.println("   </form>");

		// Pie
		request
			.getRequestDispatcher("/Pie")
			.include(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		doGet(req, resp);
	}
}



