<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%! public static final int EDAD_JUBILACION = 65; %>

<!DOCTYPE html>
<html>
<head>
   <meta charset='UTF-8'>
   <title>Persona</title>
</head>
<body>
	<%
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
		if (errores.size() == 0) {
	%>

	Nombre: <%= nombre %><br/>
	Apellido: <%=  apellido %><br/>
	Edad: <%= edad %><br/>
	
	<%
			int anios = EDAD_JUBILACION - edad;
			if (anios <= 0) { // Eres un máquina
	%>

	<div style='color: green'>Eres un máquina!</div>

	<%
			} else {  // A currar
	%>

	<div style='color: violet'>A currar!</div>

	<%
			}
		} else { // Imprimiendo errores
	%>

	<div style='background-color: red'>

	<%
			for (String e : errores) {
	%>
				<%= e %><br/>
	<%
			}
	 %>
</div>
	<%
		}
	%>

	<a href='persona.jsp' >Volver</a>
</body>
</html>