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
		String userName = session.getAttribute("userName")+"";
	%>
	<h1>Xin chào: <%=userName %></h1> <br>
	<h1>Đây là trang 2</h1>
	<a href="trang3.jsp">Trang 3</a>
</body>
</html>