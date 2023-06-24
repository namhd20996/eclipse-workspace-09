<%@page import="model.KhachHangModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Change Password</title>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Book Store</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
	integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.min.js"
	integrity="sha384-IDwe1+LCz02ROU9k972gdyvl+AESN10+x7tBKgc9I5HFtuNz0wWnPclzo6p9vxnk"
	crossorigin="anonymous"></script>

</head>
<body>
	<%
	KhachHangModel kh = (KhachHangModel) session.getAttribute("khachHang");
	if (kh == null) {
	%>
	<h1>Bạn chưa đăng nhập vào hệ thống!</h1>
	<%
	} else {
	%>
	<%
	String baoLoi = request.getAttribute("baoLoi") + "";
	baoLoi = baoLoi.equals("null") ? "" : baoLoi;
	%>

	<div class="container">
		<h1>ĐỔI MẬT KHẨU</h1>
		<span style="color: red"><%=baoLoi%> </span>
		<% String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
		+ request.getContextPath(); %>
		<form action="<%=url %>/khach-hang" method="POST">
			<input type="hidden" name="action" value="doi-mat-khau">
			<div class="mb-3">
				<label for="matKhauHienTai" class="form-label">Mật khẩu hiện
					tại</label> <input type="password" class="form-control" id="matKhauHienTai"
					name="matKhauHienTai">
			</div>
			<div class="mb-3">
				<label for="matKhauMoi" class="form-label">Mật khẩu mới</label> <input
					type="password" class="form-control" id="matKhauMoi"
					name="matKhauMoi">
			</div>
			<div class="mb-3">
				<label for="matKhauMoiNhapLai" class="form-label">Mật khẩu
					mới</label> <input type="password" class="form-control"
					id="matKhauMoiNhapLai" name="matKhauMoiNhapLai">
			</div>
			<button type="submit" class="btn btn-primary">Lưu mật khẩu</button>
		</form>
	</div>
	<%
	}
	%>
</body>
</html>