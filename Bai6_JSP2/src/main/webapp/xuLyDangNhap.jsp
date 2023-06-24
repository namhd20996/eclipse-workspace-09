<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String user = request.getParameter("username");
		String passWord = request.getParameter("password");
	%>
	<%
		if(user.equalsIgnoreCase("nam") && passWord.equals("123"))
		{
	%>
		<h1>Đăng nhập thành công</h1>
	<%
		}else{
	%>
		<h1>Đăng nhập thất bại</h1>
	<%
		}
	%>
</body>
</html>