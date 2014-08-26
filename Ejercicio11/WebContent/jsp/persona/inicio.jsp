<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Personas</title>
	<link rel="stylesheet" type="text/css" href="../css/comun.css">
	<link rel="stylesheet" type="text/css" href="../css/persona.css">
</head>
<body onload="init()">
	<h1>Personas</h1>
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
			<td>Sexo:</td>
			<td>
				M <input type="radio" name="inputSexo" value="M" checked="checked"/>
				F <input type="radio" name="inputSexo" value="F"/>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" value="Agregar" onclick="guardar('agr')"/>
				<input type="button" value="Modificar" onclick="guardar('mod')"/>
			</td>
		</tr>
	</table>
	<br/>

	<table id="tablaPersonas" class="tablaCentrada tablaDatos">
		<thead>
			<tr>
				<th>Nombre</th>
				<th>Apellido</th>
				<th>Fecha</th>
				<th>Sexo</th>
				<th>Mostrar</th>
				<th>Eliminar</th>			
			</tr>
		</thead>

		<tbody id="tbodyPersonas">
		</tbody>
	</table>
</body>
</html>