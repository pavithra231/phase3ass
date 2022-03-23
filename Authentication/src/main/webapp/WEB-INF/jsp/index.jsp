<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<h2>Login</h2>
	<form action="/login" method="POST">
		<label for="email">Name:</label>
		<input type="text" placeholder="E-mail" id="email" name="email"><br><br>
		<label for="password">Password:</label>
		<input type="text" placeholder="Password" id="password" name="password"><br><br> 
		<br> <input type="submit" value="Login"><br><br>
	</form>
</body>
</html>