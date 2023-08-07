<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<H1 style="text-align: center;">Insertar Registros</H1>

	<form name="form1" method="get" action="controladorProductos">
		<input type="hidden" name="instruccion" value="insertarBBDD">

		<table style="width: 400px;">

			<tbody>

				<tr>
					<td>CODIGOARTICULO</td>
					<td><input maxlength="4" size="24" type="text" name="CArt"
						id="Cart"></td>
				</tr>

				<tr>
					<td>SECCION</td>
					<td><input maxlength="11" size="24" type="text" name="Sec"
						id="Sec"></td>
				</tr>

				<tr>
					<td>NOMBREARTICULO</td>
					<td><input maxlength="24" size="24" type="text" name="NArt"
						id="NArt"></td>
				</tr>

				<tr>
					<td>PRECIO</td>
					<td><input maxlength="10" size="24" type="text" name="Prec"
						id="Prec"></td>
				</tr>

				<tr>
					<td>FECHA</td>
					<td><input maxlength="10" size="24" type="text" name="Fecha"
						id="Fecha"></td>
				</tr>

				<tr>
					<td>IMPORTADO</td>
					<td><input maxlength="9" size="24" type="text" name="Imp"
						id="Imp"></td>
				</tr>

				<tr>
					<td>PAISDEORIGEN</td>
					<td><input maxlength="9" size="24" type="text" name="POri"
						id="POri"></td>
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