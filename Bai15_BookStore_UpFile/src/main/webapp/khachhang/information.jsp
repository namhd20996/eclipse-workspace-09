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

	String hoTen = kh.getHoTen();
	boolean gioiTinhT = kh.isGioiTinh();
	String gioiTinh = "";
	if (gioiTinhT) {
		gioiTinh = "Nam";
	} else {
		gioiTinh = "Nữ";
	}
	String ngaySinh = kh.getNgaySinh().toString();
	String diaChiKhachHang = kh.getDiaChi();
	String diaChiMuaHang = kh.getDiaChiMuaHang();
	String diaChiNhanHang = kh.getDiaChiNhanHang();
	String soDienThoai = kh.getSoDienThoai();
	String email = kh.getEmail();
	boolean dongYNhanMail = kh.isDangKyNhanTin();
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
		<form class="form" action="<%=url %>/khach-hang" method="post">
			<input type="hidden" name="action" value="thay-doi-tt">
			<div class="row">
				<div class="col-sm-6">

					<h3>Thông tin khách hàng</h3>
					<div class="mb-3">
						<label for="hoVaTen" class="form-label">Họ và tên</label> <input
							type="text" class="form-control" id="hoVaTen" name="hoVaTen"
							value="<%=hoTen%>">
					</div>
					<div class="mb-3">
						<label for="gioiTinh" class="form-label">Giới tính</label> <select
							class="form-control" id="gioiTinh" name="gioiTinh">
							<option></option>
							<option value="Nam"
								<%=gioiTinh.equals("Nam") ? "selected='selected'" : ""%>>Nam</option>
							<option value="Nữ"
								<%=gioiTinh.equals("Nữ") ? "selected='selected'" : ""%>>Nữ</option>
							<option value="Khác"
								<%=gioiTinh.equals("Khác") ? "selected='selected'" : ""%>>Other</option>
						</select>
					</div>
					<div class="mb-3">
						<label for="ngaySinh" class="form-label">Ngày sinh</label> <input
							type="date" class="form-control" id="ngaySinh" name="ngaySinh"
							value="<%=ngaySinh%>">
					</div>
				</div>
				<div class="col-sm-6">
					<h3>Địa chỉ</h3>
					<div class="mb-3">
						<label for="diaChiKhachHang" class="form-label">Địa chỉ
							khách hàng</label> <input type="text" class="form-control"
							id="diaChiKhachHang" name="diaChiKhachHang"
							value="<%=diaChiKhachHang%>">
					</div>
					<div class="mb-3">
						<label for="diaChiMuaHang" class="form-label">Địa chỉ mua
							hàng</label> <input type="text" class="form-control" id="diaChiMuaHang"
							name="diaChiMuaHang" value="<%=diaChiMuaHang%>">
					</div>
					<div class="mb-3">
						<label for="diaChiNhanHang" class="form-label">Địa chỉ
							nhận hàng</label> <input type="text" class="form-control"
							id="diaChiNhanHang" name="diaChiNhanHang"
							value="<%=diaChiNhanHang%>">
					</div>
					<div class="mb-3">
						<label for="dienThoai" class="form-label">Điện thoại</label> <input
							type="tel" class="form-control" id="dienThoai" name="dienThoai"
							value="<%=soDienThoai%>">
					</div>
					<div class="mb-3">
						<label for="email" class="form-label">Email</label> <input
							type="email" class="form-control" id="email" name="email"
							value="<%=email%>">
					</div>
					<hr />

					<div class="mb-3">
						<label for="dongYNhanMail" class="form-label">Đồng ý nhận
							email</label> <input type="checkbox" class="form-check-input"
							value="dongYNhanMail" id="dongYNhanMail" name="dongYNhanMail"
							<%=dongYNhanMail ? "checked" : ""%>>
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