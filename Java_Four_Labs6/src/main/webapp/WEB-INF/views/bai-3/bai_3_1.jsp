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
		<form action="<c:url value='/bai-3-1'/>" method="post">
			<div class="input-group">
				<input type="search" class="form-control rounded"
					placeholder="Keyword?" aria-label="Search"
					aria-describedby="search-addon" name="keyword" />
				<button type="submit" class="btn btn-outline-primary">search</button>
			</div>
		</form>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">Id</th>
					<th scope="col">Title</th>
					<th scope="col">Views</th>
					<th scope="col">Active</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${list}">
					<tr>
						<th scope="row">${item.id}</th>
						<td>${item.title }</td>
						<td>${item.views }</td>
						<td>${item.active }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>