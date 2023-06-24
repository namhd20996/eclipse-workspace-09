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
	String img = request.getAttribute("image") + "";
	String document = request.getAttribute("document") + "";
	
	%>
	Name: <%=img%>
	<img alt="" src="uploads/<%=img%>">
	<br>
	Name document: <%=document%>
	<a href="uploas/<%=document%>">Dowload</a>
</body>
</html>