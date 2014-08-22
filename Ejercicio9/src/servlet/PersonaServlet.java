package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Persona")
public class PersonaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Cabecera
		request
			.getRequestDispatcher("/Cabecera")
			.include(request, response);
			
		// Cuerpo
		PrintWriter pw = response.getWriter();
		
		pw.println("   <script>");
		pw.println("      var validar = function() {");
		pw.println("         var nombre = document.getElementById('nombre').value;");
		pw.println("         var apellido = document.getElementById('apellido').value;");
		pw.println("         var edad = document.getElementById('edad').value;");
		pw.println("         var noEsNumero = isNaN(parseInt(edad));");
		pw.println("         var error = '';");
		pw.println("         ");
		pw.println("         if (nombre == '')");
		pw.println("            error += 'Debe especificar un nombre\\n';");
		pw.println("         if (apellido == '')");
		pw.println("            error += 'Debe especificar un apellido\\n';");
		pw.println("         if (noEsNumero || edad <= 0)");
		pw.println("            error += 'Edad inválida';");
		pw.println("         ");
		pw.println("         if (error != '')");
		pw.println("            window.alert(error);");
		pw.println("         else ");
		pw.println("            document.forms[0].submit();");
		pw.println("      };");
		pw.println("   </script>");
		
		pw.println("   <form action='Resultado' method='post'>");
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
		pw.println("               <input type='button' value='Enviar' onclick='validar()'/>");
		pw.println("            </td>");
		pw.println("         </tr>");
		pw.println("      </table>");
		pw.println("   </form>");

		// Pie
		request
			.getRequestDispatcher("/Pie")
			.include(request, response);
	}

}



