<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ADD USER</title>
</head>
<body>
	<h3>Welcome, Enter The Customer Details</h3>

	<form:form method="POST" action="registerUser" modelAttribute="user">
		<table>
			<tr>
				<td><form:label path="userid">Enter User ID :</form:label></td>
				<td><form:input path="userid" /></td>
			</tr>
			<tr>
				<td><form:label path="username">Enter Username :</form:label></td>
				<td><form:input path="username" /></td>
			</tr>
			<tr>
				<td><form:label path="password">Enter Password :</form:label></td>
				<td><form:input path="password"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>

</body>