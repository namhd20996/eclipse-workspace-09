<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<c:url value='/bai-5'/>" method="POST">
	<h1>Nhập họ và tên</h1>
		<input type="text" name="name"> <input type="submit"
			name="Submit" value="Submit">
		<h1>${fullName}</h1>
	</form>
	<a href="<c:url value='/home-page'/>" class="btn btn-outline-primary">Index</a>
</body>
</html>