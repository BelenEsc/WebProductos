<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<H1 style="text-align: center;">Actualizar Producto</H1>

	<form name="form1" method="get" action="controladorProductos">
		<input type="hidden" name="instruccion" value="actualizarBBDD">
		<input type="hidden" name="CArt" value="${ProductoActualizar.codigoArt}">

		<table style="width: 400px;">

			<tbody>

			<!-- 	<tr>
					<td>CODIGOARTICULO</td>
					<td><input maxlength="4" size="24" type="text" name="CArt"
						id="Cart"></td>
				</tr> -->

				<tr>
					<td>SECCION</td>
					<td><input maxlength="11" size="24" type="text" name="Sec"
						id="Sec" value="${ProductoActualizar.seccion}"></td>
				</tr>

				<tr>
					<td>NOMBREARTICULO</td>
					<td><input maxlength="24" size="24" type="text" name="NArt"
						id="NArt" value="${ProductoActualizar.nomArt}"></td>
				</tr>

				<tr>
					<td>PRECIO</td>
					<td><input maxlength="10" size="24" type="text" name="Prec"
						id="Prec" value="${ProductoActualizar.precio}"></td>
				</tr>

				<tr>
					<td>FECHA</td>
					<td><input maxlength="10" size="24" type="text" name="Fecha"
						id="Fecha" value="${ProductoActualizar.fecha}"></td>
				</tr>

				<tr>
					<td>IMPORTADO</td>
					<td><input maxlength="9" size="24" type="text" name="Imp"
						id="Imp" value="${ProductoActualizar.importado}"></td>
				</tr>

				<tr>
					<td>PAISDEORIGEN</td>
					<td><input maxlength="9" size="24" type="text" name="POri"
						id="POri" value="${ProductoActualizar.paisOrigen}"></td>
				</tr>

				<tr>
					<td><input type="submit" value="Enviar" /></td>
					<td><input type="button" value="Restablecer" /></td>
				</tr>

			</tbody>

		</table>

	</form>

</body>
</html>