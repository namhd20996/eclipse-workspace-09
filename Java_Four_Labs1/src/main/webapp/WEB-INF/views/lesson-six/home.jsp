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
	<form action="<c:url value='/bai-6'/>" method="POST">
		<table>
			<tr>
				<td colspan="2">Thông Tin Hình Chữ Nhật</td>
			</tr>
			<tr>
				<td>Chiều dài</td>
				<td><input type="text" name="length" /></td>
			</tr>
			<tr>
				<td>Chiều rộng</td>
				<td><input type="text" name="width" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Tính" /></td>
			</tr>
			<tr>
				<td>Diện tích</td>
				<td>${acreage}</td>
			</tr>
			<tr>
				<td>Chu vi</td>
				<td>${perimeter }</td>
			</tr>
		</table>
	</form>
	<a href="<c:url value='/home-page'/>" class="btn btn-outline-primary">Index</a>
</body>
</html>