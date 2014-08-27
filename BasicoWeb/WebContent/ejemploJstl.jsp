<%@page import="java.util.List"%>
<%@page import="model.Aula"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Aulas</h1>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Nombre</th>
			<th>Capacidad</th>
		</tr>
		<%
			List<Aula> aulas = (List<Aula>) request.getAttribute("aulas");
			int contador = 1;
			if (aulas != null)
				for (Aula a : aulas) {
					String color = "gray";
					if (contador++ % 2 == 0)
						color = "blue";
		%>
		<tr bgcolor="<%=color%>">
			<td><%=a.getId()%></td>
			<td><%=a.getNombre()%></td>
			<td><%=a.getCapacidad()%></td>
		</tr>
		<%
			}
		%>
	</table>

	<br />

	<table border="1">
		<tr>
			<th>Id</th>
			<th>Nombre</th>
			<th>Capacidad</th>
		</tr>
		<!-- Todo lo que va entre ${AQUI} se llama Expression Language (EL) -->
		<c:set var="contador" value="1" />
		<c:forEach items="${aulas}" var="a">
			<c:set var="color" value="gray" />
			<c:if test="${contador % 2 != 0}">
				<c:set var="color" value="blue" />
			</c:if>

			<tr bgcolor="<c:out value="${color}" />">
				<td><c:out value="${a.id}" /></td>
				<td><c:out value="${a.nombre}" /></td>
				<td><c:out value="${a.capacidad}" /></td>
			</tr>
			<c:set var="contador" value="${contador + 1}" />
		</c:forEach>
	</table>

</body>
</html>