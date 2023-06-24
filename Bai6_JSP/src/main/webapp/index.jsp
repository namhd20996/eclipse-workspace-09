<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ page import="java.lang.Math" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		int a = 5;
		double b = Math.sqrt(a);
	%>
	Căn  của a = <%= b %>
</body>
</html>