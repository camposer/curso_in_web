<%@ page 
	language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Hola mundo</title>
</head>
<body>
	<%! // Esto va fuera del método service
		private String saludar(int numero) {
			return "Hola mundo " + numero;
		}
	%>

	<%
		String chao = "chao";
	%>
	<!-- Contenido estático -->
	<font color="red">Hola mundo 1</font><br/>
	
	<!-- 
		Contenido dinámico con expresión
		Utiliza la expresión para imprimir 
	-->
	<font color="blue"><%= "Hola mundo 2" %></font><br/>
	
	<!-- 
		Contenido dinámico con scriptlet
		Utiliza el objeto implícito out
	 -->
	<font color="green">
	<%
		String mensaje = "Hola mundo 3";
		out.println(mensaje);
	%>
	</font><br/>
	
	<!-- Contenido dinámico con expresión y valor arrojado por una función  -->
	<font color="violet">
	<%= saludar(4) %>
	</font><br/>

	<!-- Contenido dinámico con expresión utilizando variable -->
	<%= chao %>
	
	<%-- http://localhost:8080/BasicoWeb/holaMundo.jsp --%>
</body>
</html>