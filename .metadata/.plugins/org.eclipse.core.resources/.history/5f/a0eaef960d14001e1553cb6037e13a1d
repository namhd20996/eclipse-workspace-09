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
	String tenDangNhap = request.getAttribute("tenDangNhap") + "";
	String matKhau = request.getAttribute("matKhau") + "";
	String gioiTinh = request.getAttribute("gioiTinh") + "";
	String tinhTrangHonNhan = request.getAttribute("tinhTrangHonNhan") + "";
	String quocTich = request.getAttribute("quocTich") + "";
	String soThich = request.getAttribute("soThich") + "";
	String ghiChu = request.getAttribute("ghiChu") + "";

	tenDangNhap = tenDangNhap.equals("null") ? "" : tenDangNhap;
	matKhau = matKhau.equals("null") ? "" : matKhau;
	gioiTinh = gioiTinh.equals("null") ? "" : gioiTinh;
	tinhTrangHonNhan = tinhTrangHonNhan.equals("null") ? "" : tinhTrangHonNhan;
	quocTich = quocTich.equals("null") ? "" : quocTich;
	soThich = soThich.equals("null") ? "" : soThich;
	ghiChu = ghiChu.equals("null") ? "" : ghiChu;
	%>

	<h1>Thông tin đăng ký</h1>
	<ul>
		<li>Tên đăng nhập: <%=tenDangNhap%></li>
		<li>Mật khẩu: <%=matKhau%></li>
		<li>Giới tính: <%=gioiTinh%></li>
		<li>Tình trạng hôn nhân: <%=tinhTrangHonNhan%></li>
		<li>Quốc tịch: <%=quocTich%></li>
		<li>Sở thích: <%=soThich%></li>
		<li>Ghi chú: <%=ghiChu%></li>
	</ul>
</body>
</html>