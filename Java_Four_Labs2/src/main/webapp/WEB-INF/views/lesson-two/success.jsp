<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Thông tin đăng ký</h1>
	<ul>
		<li>Tên đăng nhập: ${tenDangNhap }</li>
		<li>Mật khẩu: ${matKhau }</li>
		<li>Giới tính: ${gioiTinh }</li>
		<li>Tình trạng hôn nhân: ${tinhTrangHonNhan }</li>
		<li>Quốc tịch: ${quocTich }</li>
		<li>Sở thích: ${soThich }</li>
		<li>Ghi chú: ${ghiChu }</li>
	</ul>
	<a href="<c:url value='/home-page'/>" class="btn btn-outline-primary">Index</a>
</body>
</html>