<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, to.PersonaTo" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Persona</title>
</head>
<body>
	<%
		// TODO Incluir div!
		List<String> errores = (List<String>)
				request.getAttribute("errores"); // => null para la primera ejecución
		PersonaTo persona = (PersonaTo)
				request.getAttribute("persona"); // => null para la primera ejecución
		
		if (errores != null) { // Hay errores por imprimir
	%>
	
			<div style='color: red'>
	
	<%			
			for (String e : errores) {
	%>
				<%= e %><br/>
	<%
			}
	%>
			</div>
	<%
		} else if (persona != null) { // Hay una persona por imprimir
	%>

			<div style='color: green'>
				Nombre: <%= persona.getNombre() %><br/>
				Apellido: <%= persona.getApellido() %><br/>
				Edad: <%= persona.getEdad() %><br/>
				<b><%= persona.getMensaje() %></b><br/>			
			</div>
	<%
		}
		
		String nombre = request.getParameter("nombre");
	%>
		
   <form action='Resultado2' method='post'>
      <table>
         <tr>
            <td>Nombre:</td>
            <td><input type='text' name='nombre' id='nombre' value='<%= ((nombre!=null)?nombre:"") %>'/></td>
         </tr>
         <tr>
            <td>Apellido:</td>
            <td><input type='text' name='apellido' id='apellido'/></td>
         </tr>
         <tr>
            <td>Edad:</td>
            <td><input type='text' name='edad' id='edad'/></td>
         </tr>
         <tr>
            <td colspan='2'>
               <input type='submit' value='Enviar'/>
            </td>
         </tr>
      </table>
   </form>

</body>
</html>