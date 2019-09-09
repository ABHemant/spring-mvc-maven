<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ADD EMPLOYEEr</title>
</head>
<body>
	<h3>Welcome, Enter The Customer Details</h3>

	<form:form method="POST" action="saveEmployee" modelAttribute="employee">
		<table>
			<tr>
				<td><form:label path="id">Employee Id</form:label></td>
				<td><form:input path="id" /></td>
			</tr>
			<tr>
				<td><form:label path="firstname">First Name</form:label></td>
				<td><form:input path="firstname" /></td>
			</tr>
			<tr>
				<td><form:label path="lastname">Last Name</form:label></td>
				<td><form:input path="lastname"/></td>
			</tr>
			<tr>
				<td><form:label path="address">Address</form:label></td>
				<td><form:input path="address" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>

</body>