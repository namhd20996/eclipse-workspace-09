<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Register</h1>
	<hr>
	<form action="register" method="post" enctype="multipart/form-data">
		Name: <input type="text" name="name" placeholder="Name"> <br>
		Image: <input type="file" name="img" placeholder="IMG"> <br>
		<input type="submit" value="Register">
		<input type="reset" value="Reset">
	</form>
</body>
</html>