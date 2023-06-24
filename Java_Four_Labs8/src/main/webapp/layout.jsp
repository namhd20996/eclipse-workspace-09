<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>FPT Polytechnic</h1>
	<hr />
	<c:url var="home" value='/home' />
	<a href="${home }/index">Index</a>
	<a href="${home }/about">About</a>
	<a href="${home }/contact">Contact</a>
	<a href="${home }/bai-2">Bai 2</a>
	<a href="${home }/bai-3">Bài 3</a>
	<a href="${home }/bai-4">Bài 4</a>
	<c:if test="${view != null }">
		<jsp:include page="${view}"></jsp:include>
	</c:if>
	<hr />
	<div>2020 by Poly.All rights reserved</div>
</body>
</html>