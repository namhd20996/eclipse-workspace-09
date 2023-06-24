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
	String hoVaTen = request.getParameter("hoVaTen");
	String email = request.getParameter("email");
	String soLuong = request.getParameter("soLuong");
	%>

	<h1>Xác nhận đăng ký:</h1>
	<p>
		Xin cảm ơn bạn: <b> <%=hoVaTen%></b> Đã đặt:<b> <%=soLuong%>
		</b> sản phẩm <br> Bạn sẽ nhận được thông báo qua email:
		<%=email%>
	</p>
</body>
</html>