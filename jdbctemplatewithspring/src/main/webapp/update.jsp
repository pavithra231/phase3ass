<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Edit User</h2>
<form action="update" method="get">
             
			<label for="name">Edit Name:</label>
			<input type="text" placeholder="Name" id="name" name="name"><br><br> 
			<label for="email">Edit E-mail:</label>
			<input type="text" placeholder="Email" id="email" name="email"><br><br> 
			<label for="password">Enter Password:</label>
			<input type="password" placeholder="Password" id="password" name="password"><br><br> 
			<br> <input type="submit" value="Update"><br><br>
	</form>
</body>
</html>