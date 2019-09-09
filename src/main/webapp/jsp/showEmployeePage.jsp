<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<h2>Students Data</h2>
		<ul>
			<c:forEach var="emp" items="${employeeList}">
				<li>${emp.firstname}</li>
				<li>${emp.lastname}</li>
				<li>${emp.address}</li>
			</c:forEach>
		</ul>
</body>
</html>
