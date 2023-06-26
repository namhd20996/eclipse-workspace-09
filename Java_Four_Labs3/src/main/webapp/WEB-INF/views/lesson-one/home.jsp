<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
</head>
<body>
	<form action="<c:url value='/bai-1'/>" method="post" enctype="multipart/form-data">
		<input type="hidden" name="action" value="upload">
		Hình: <input placeholder="Hình Ảnh" type="file" name="image"> <br>
		File: <input type="file" name ="document"><br>
		<hr>
		<input class="btn btn-primary" type="submit" value="Submit">
		<a href="<c:url value='/home-page'/>" class="btn btn-outline-primary">Index</a>
	</form>
	
</body>
</html>