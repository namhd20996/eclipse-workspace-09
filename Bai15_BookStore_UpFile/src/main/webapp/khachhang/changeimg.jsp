<%@page import="model.KhachHangModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Đăng ký tài khoản</title>
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

<style type="text/css">
.red {
	color: red;
}
</style>
</head>
<body>

	<%
	KhachHangModel kh = (KhachHangModel) session.getAttribute("khachHang");
	if (kh == null) {
	%>
	<h1>Vui lòng đăng nhập!</h1>
	<%
	} else {
	%>


	<%
	String baoLoi = request.getAttribute("baoLoi") + "";
	baoLoi = baoLoi.equals("null") ? "" : baoLoi;
	
	String duongDanAnh = kh.getDuongDanAnh();
	
	%>

	<div class="container">
		<div class="text-center">
			<h1>Thay Đổi Thông Tin</h1>
		</div>
		<div class="red">
			<%=baoLoi%>
		</div>
		<div class="red" id="baoLoi"></div>
		<% String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
		+ request.getContextPath(); %>
		<!-- Form upload file phải có  enctype="multipart/form-data" và phải là method="post"-->
		<form class="form" action="<%=url %>/khach-hang-thay-doi-anh" method="post" enctype="multipart/form-data">
			<input type="hidden" name="action" value="thay-doi-anh">
			<div class="row">
				<div class="col-sm-6">

					<h3>Thông tin khách hàng</h3>
					<img alt="Ảnh avatar" src="<%=url%>/hinhanh/<%=duongDanAnh%>">
					
					<div class="mb-3">
						<label for="duongDanAnh" class="form-label">Đường dẫn ảnh</label> <input
							type="file" class="form-control" id="duongDanAnh" name="duongDanAnh">
					</div>
					<input class="btn btn-primary form-control" type="submit"
						value="Đăng ký" name="submit" id="submit" />
				</div>
			</div>
		</form>
	</div>
	<%
	}
	%>
</body>
<script type="text/javascript">
	function kiemTraMatKhau() {
		var matKhau = document.getElementById("matKhau").value;
		var matKhauC = document.getElementById("matKhauNhapLai").value;
		if (matKhau != matKhauC) {
			document.getElementById("msg").innerHTML = "Mật khẩu xác nhận chưa đúng";
			return false;
		} else {
			document.getElementById("msg").innerHTML = "";
			return true;
		}
	}
</script>
</html>