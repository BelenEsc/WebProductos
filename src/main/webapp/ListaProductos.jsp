<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%-- <%@ page import="java.util.*, com.belenaprende.productos.*"%>  --%>
<!--  cuando se utilizan las tags jsp tags no se necesita esto aqui por que esto va a ir en otra clase en vez de eso anadira la linea q nos permite usar las tags -->



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.cabecera {
	fond-size: 1.2em;
	font-weight: bold;
	color: #FFFFFF;
	background-color: #08088A;
}

.filas {
	text-align: center;
	background-color: #5882FA;
}

table {
	float: left;
	/* todo lo que haya a continuacion de la tabla aparezca a la derecha   */
}

#contenedorBoton {
	margin-left: 1000px;
}
</style>
</head>

<%-- <%
/* 
Recibe productos del controlador servlet
 */
List<Productos> losProductos = (List<Productos>) request.getAttribute("LISTAPRODUCTOS");
%>
esto tampoco se necesita ya --%>
<body>

	<table>

		<tr>
			<!-- td crea el titulo de las columnas -->
			<td class="cabecera">Codigo Articulo</td>
			<td class="cabecera">Seccion</td>
			<td class="cabecera">Nombre Art</td>
			<td class="cabecera">Fecha</td>
			<td class="cabecera">Precio</td>
			<td class="cabecera">Importado</td>
			<td class="cabecera">País de orígen</td>
			<td class="cabecera">Accion</td>

		</tr>

		<%-- <%
		for (Productos tempProductos : losProductos) {
		%> --%>

		<c:forEach var="tempProductos" items="${LISTAPRODUCTOS}">
			<!-- en este item tiene que venir lo que le estamos pasando desde el servlet. O sea con el nombre que se le bautizo en el servlet en el campo setattribute -->

			<!-- Link para cada producto con su campo clave  -->

			<c:url var="linkTemp" value="controladorProductos">
				<c:param name="instruccion" value="cargar"></c:param>
				<c:param name="CArticulo" value="${tempProductos.codigoArt}"></c:param>
			</c:url>
			<tr>

				<!-- una vez que se usan tags, ya no se necesita acceder a los metodos para acceder a los valores, basta con acceder al valor mismo -->
				<td class="filas">${tempProductos.codigoArt}</td>
				<td class="filas">${tempProductos.seccion}</td>
				<td class="filas">${tempProductos.nomArt}</td>
				<td class="filas">${tempProductos.paisOrigen}</td>
				<td class="filas">${tempProductos.importado}</td>
				<td class="filas">${tempProductos.fecha}</td>
				<td class="filas">${tempProductos.precio}</td>
				<td class="filas"><a href="${linkTemp}"> Actualizar </a></td>
				<!-- enlace para que al pulsarlo, le pase el campo clave del articulo pulsado  -->

			</tr>

		</c:forEach>
		<%-- <%}%> --%>
	</table>

	<div id="contenedorBoton">
		<input type="button" value="insertar registro"
			onclick="window.location.href='inserta_producto.jsp'" />

	</div>


</body>
</html>