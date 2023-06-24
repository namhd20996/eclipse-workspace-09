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
	// Lấy ra đường dẫn trang chính
	// request.getScheme() lấy ra http hoặc https, request.getContextPath() lấy ra tên project
	String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath();
	%>
	<h1>Rất tiếc, trang bạn truy cập không tồn tại!</h1>
	<%=path%>
	<img alt="Error 404" src="<%=path%>/img/error404.png">
</body>
</html>