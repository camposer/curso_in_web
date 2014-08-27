<%@page import="model.Persona"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Personas</title>
	<link rel="stylesheet" type="text/css" href="../css/comun.css">
	<link rel="stylesheet" type="text/css" href="../css/persona.css">
	<style>
		.errores {
			background-color: red; 
			color: white; 
			margin-left: auto;
			margin-right: auto;
			width: 60%		
		}
	</style>
	<script>
		var confirmar = function() {
			var confirmado = confirm("Está seguro de que desea eliminar la persona seleccionada?");
			return confirmado; // true o false
		};
	</script>
</head>
<body>
	<h1>Personas</h1>
	<div class="errores">
	<%
		List<String> errores = (List<String>)session.getAttribute("errores"); 
		if (errores != null && errores.size() > 0) 
			for (String e : errores) {
	%>
				<%= e %><br/>
	<%
			}
		session.removeAttribute("errores");
	%>
	</div>
	<form action="Agregar" method="post">
	<input type="hidden" name="inputId" id="inputId"/>
	<table class="tablaCentrada tablaFormulario">
		<tr>
			<td>Nombre:</td>
			<td><input type="text" name="inputNombre" id="inputNombre"/></td>
		</tr>
		<tr>
			<td>Apellido:</td>
			<td><input type="text" name="inputApellido" id="inputApellido"/></td>
		</tr>
		<tr>
			<td>Fecha:</td>
			<td><input type="text" name="inputFecha" id="inputFecha"/></td>
		</tr>
		<tr>
			<td>Altura:</td>
			<td><input type="text" name="inputAltura" id="inputAltura"/></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="Agregar"/>
				<input type="button" value="Modificar"/>
			</td>
		</tr>
	</table>
	</form>
	
	<br/>

	<table id="tablaPersonas" class="tablaCentrada tablaDatos">
		<thead>
			<tr>
				<th>#</th>
				<th>Id</th>
				<th>Nombre</th>
				<th>Apellido</th>
				<th>Fecha</th>
				<th>Altura</th>
				<th>Mostrar</th>
				<th>Eliminar</th>			
			</tr>
		</thead>

		<tbody id="tbodyPersonas">
		<%
			// Obteniendo personas que son enviadas desde el Controlador
			List<Persona> personas = (List<Persona>)
				request.getAttribute("personas");
		
			if (personas != null) {
				int num = 1;
				for (Persona p : personas) {
		%>
					<tr>
						<td><%= num++ %></td>
						<td><%= p.getId() %></td>
						<td><%= p.getNombre() %></td>
						<td><%= p.getApellido() %></td>
						<td><%= p.getFechaNacimiento() %></td>
						<td><%= p.getAltura() %></td>
						<td><a href="#">mostrar</a></td>
						<td><a 
								href="<%= getServletContext().getContextPath() %>/persona/Eliminar?id=<%= p.getId() %>" 
								onclick="return confirmar()">
									eliminar
							</a>
						</td>
					</tr>
		<%
				}
			}
		%>
		</tbody>
	</table>
</body>
</html>