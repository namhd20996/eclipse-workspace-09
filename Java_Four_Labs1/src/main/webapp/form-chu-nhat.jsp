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
	Double dienTich = (Double) request.getAttribute("dienTich");
	Double chuVi = (Double) request.getAttribute("chuVi");
	%>
	<form action="chu-nhat" method="post">
		<table>
			<tr>
				<td colspan="2">Thông Tin Hình Chữ Nhật</td>
			</tr>
			<tr>
				<td>Chiều dài</td>
				<td><input type="text" name="chieuDai" /></td>
			</tr>
			<tr>
				<td>Chiều rộng</td>
				<td><input type="text" name="chieuRong" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Tính" /></td>
			</tr>
			<tr>
				<td>Diện tích</td>
				<td><%=dienTich%></td>
			</tr>
			<tr>
				<td>Chu vi</td>
				<td><%=chuVi%></td>
			</tr>
		</table>
	</form>
</body>
</html>