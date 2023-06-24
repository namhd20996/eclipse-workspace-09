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
	<div class="dropdown show">
		  <a class="btn btn-secondary dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Select Year
		  </a>
			  <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
			    <a class="dropdown-item" href="<c:url value='/bai-4-2?year=2020'/>">2020</a>
			    <a class="dropdown-item" href="<c:url value='/bai-4-2?year=2021'/>">2021</a>
			    <a class="dropdown-item" href="<c:url value='/bai-4-2?year=2023'/>">2023</a>
			  </div>
		</div>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">Title</th>
					<th scope="col">Favorite count</th>
					<th scope="col">Newest date</th>
					<th scope="col">Oldest date</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${list}">
					<tr>
						<th scope="row">${item.group}</th>
						<td>${item.likes }</td>
						<td>${item.newest }</td>
						<td>${item.oldest }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>