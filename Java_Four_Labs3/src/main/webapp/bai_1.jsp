<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="labs3-ctl" method="post" enctype="multipart/form-data">
		<input type="hidden" name="action" value="upload">
		Hình: <input placeholder="Hình Ảnh" type="file" name="image"> <br>
		File: <input type="file" name ="document"><br>
		<hr>
		<input type="submit" value="Submit">
	</form>
</body>
</html>