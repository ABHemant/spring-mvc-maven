<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Management</title>
</head>
<body>
	<form action="login" method="post">
		<table style="width: 100%">
			<tr>
				<td>USERNAME :</td>
				<td><input type="text" name="user" /></td>
			</tr>
			<tr>
				<td>PASSWORD :</td>
				<td><input type="text" name="password" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="login" /></td>
			</tr>
			<tr>
				<td><a href="forgot">Forgotpassword?</a></td>
				<td><a href="register">Register</a></td>
			</tr>
		</table>
	</form>
</body>
</html>