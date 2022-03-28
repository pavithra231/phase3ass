<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<style>
table {
float: left;
}
table, th, td {
border: 1px solid black;
}
</style>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>user details</h3>
<table>
	<tr>
		<th>ID</th><th>Name</th><th>Email</th><th>Password</th>
	</tr>
	<c:forEach var="user" items="${list }">
		<tr>
			<td>${user.ID }</td>
			<td>${user.name }</td>
			<td>${user.email }</td>
			<td>${user.password }</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>