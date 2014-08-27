package servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Aula;

@WebServlet("/EjemploJstl")
public class EjemploJstl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Se supone que estas aulas vienen de la BD
		List<Aula> aulas = Arrays.asList(new Aula[] {
				new Aula(1, 20, "Aula #1"),
				new Aula(2, 10, "Aula #2"),
				new Aula(3, 30, "Aula #3")
		});
		
		// Pasando aulas a la JSP
		request.setAttribute("aulas", aulas);
		
		// Reireccionando
		request
			.getRequestDispatcher("/ejemploJstl.jsp")
			.forward(request, response);
	}

}
