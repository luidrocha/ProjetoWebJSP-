<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP</title>
</head>
<body>

	<h1>Sistema em JSP</h1>

	<form action="ServletLoginController" method="post">
		<input type="hidden" value="<%=request.getParameter("url")%>" name="url">
		<table>
			<tr>
				<td><label>Login</label> <input type="text" name="login"></br>
				</br></td>
			<tr>
				<td><label>Senha</label> <input type="password" name="senha"></br>
				</br></td>
			</tr>
			</td>

			<tr>
				<td><input type="submit" value="Enviar"></td>
			</tr>

		</table>
	</form>

	<%-- Pega o atributo vindo do back-end  --%>

	<h4>${msg}</h4>

</body>
</html>