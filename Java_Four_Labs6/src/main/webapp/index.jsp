<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.7/dist/umd/popper.min.js"
	integrity="sha384-zYPOMqeu1DAVkHiLqWBUTcbYfZ8osu1Nd6Z89ify25QV9guujx43ITvfi12/QExE"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.min.js"
	integrity="sha384-Y4oOpwW3duJdCWv5ly8SCFYWqFDsfob/3GkgExXKV4idmbt98QcxXYs9UoXAB7BZ"
	crossorigin="anonymous"></script>
</head>
<body>
	<div class="container mt-4">
		<div>
			<a href="<c:url value='/bai-2-1'/>" class="btn btn-outline-primary">Bài 2.1</a>
			<a href="<c:url value='/bai-2-2'/>" class="btn btn-outline-secondary">Bài 2.2</a>
			<a href="<c:url value='/bai-2-3'/>" class="btn btn-outline-success">Bài 2.3</a>
			<a href="<c:url value='/bai-2-4'/>" class="btn btn-outline-danger">Bài 2.4</a>
			<a href="<c:url value='/bai-2-5'/>" class="btn btn-outline-warning">Bài 2.5</a>
		</div>
		<br>
		<div>
			<a href="<c:url value='/bai-3-1'/>" class="btn btn-outline-primary">Bài 3.1</a>
			<a href="<c:url value='/bai-3-2'/>" class="btn btn-outline-secondary">Bài 3.2</a>
			<a href="<c:url value='/bai-3-3'/>" class="btn btn-outline-success">Bài 3.3</a>
			<a href="<c:url value='/bai-3-4'/>" class="btn btn-outline-danger">Bài 3.4</a>
		</div>
		<br>
		<div>
			<a href="<c:url value='/bai-4-1'/>" class="btn btn-outline-primary">Bài 4.1</a>
			<a href="<c:url value='/bai-4-2'/>" class="btn btn-outline-secondary">Bài 4.2</a>
		</div>
	</div>
</body>
</html>