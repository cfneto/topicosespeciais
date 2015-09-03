<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<form action="TrataRequisicao">
		<table>
			<tr>
				<td>ISBN: </td>
				<td><input type="text" name="nmisbn"></td>
			</tr>
			<tr>
				<td>Titulo: </td>
				<td><input type="text" name="nmtitulo"></td>
			</tr>
			<tr>
				<td>Autor: </td>
				<td><input type="text" name="nmautor"></td>
			</tr>
			<tr>
				<td>Editor: </td>
				<td><input type="text" name="nmeditor"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" name="nmsubmit" value="Incluir Livro"></td>
			</tr>
		</table>
		
	</form>

</body>
</html>