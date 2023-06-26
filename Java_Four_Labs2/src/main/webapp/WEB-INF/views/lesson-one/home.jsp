<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<c:url value='/bai-1'/>" method="POST">
		<table>
			<tr>
				<td colspan="2">Thông Tin Hình Tam Giác</td>
			</tr>
			<tr>
				<td>Cạnh a</td>
				<td><input type="text" name="canhA" value="" /></td>
			</tr>
			<tr>
				<td>Cạnh b</td>
				<td><input type="text" name="canhB" value="" /></td>
			</tr>


			<tr>
				<td>Cạnh c</td>
				<td><input type="text" name="canhC" value="" /></td>
			</tr>
			<tr>
				<td colspan=""><button type="submit"  name="action"  value="tinhDienTich">Tính diện tích</button></td>
				<td colspan=""><button type="submit"  name="action" value="tinhChuVi">Tính chu vi</button></td>
			</tr>

			<tr>
				<td>Diện tích</td>
				<td><input type="text" name="canhc" value="${acreage }" /></td>
			</tr>

			<tr>
				<td>Chu vi</td>
				<td><input type="text" name="canhc" value="${perimeter }" /></td>
			</tr>
			<tr>
				<td>${error}</td>
			</tr>

		</table>
	</form>
	<a href="<c:url value='/home-page'/>" class="btn btn-outline-primary">Index</a>
</body>
</html>