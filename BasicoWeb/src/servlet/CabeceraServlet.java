package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Cabecera")
public class CabeceraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>Hola mundo!</title>");
		pw.println("<style>");
		pw.println("#cabecera { background-color: violet; }");
		pw.println("#contenido { background-color: lightgray; }");
		pw.println("#pie { background-color: lightblue; }");
		pw.println("</style>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<div id='contenedor'>");
		pw.println("<div id='cabecera'>");
		pw.println("Cabecera");
		pw.println("</div>");
		
	}

}
