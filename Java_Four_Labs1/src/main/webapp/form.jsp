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
	String str = (String) request.getAttribute("name");
	if (str == null) {
		str = "Xin mời nhập họ tên";
	}
	%>
	<form action="param-servlet" method="post">
		<input type="text" name="name"> <input type="submit"
			name="Submit" value="Submit">
		<h1>
			Kết quả:
			<%=str%></h1>
	</form>
</body>
</html>