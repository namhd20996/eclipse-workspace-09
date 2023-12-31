<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
	integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js"
	integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz"
	crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<div class="text-center">
			<h1>ĐĂNG KÝ TÀI KHOẢN</h1>
		</div>
		<form action="<c:url value='/bai-2'/>" method="post">
			<div class="mb-3">
				<label for="tenDangNhap" class="form-label">Tên đăng nhập</label> <input
					type="text" class="form-control" id="tenDangNhap"
					aria-describedby="emailHelp" name="tenDangNhap" value="">

			</div>
			<div class="mb-3">
				<label for="matKhau" class="form-label">Mật khẩu</label> <input
					type="password" class="form-control" id="matKhau" name="matKhau"
					value="">
			</div>
			<label for="tenDangNhap" class="form-label">Giới tính</label>
			<div class="form-check">
				<input class="form-check-input" type="radio" name="gender" id="nam"
					value="nam"> <label class="form-check-label" for="nam">
					Nam </label>
			</div>
			<div class="form-check">
				<input class="form-check-input" type="radio" name="gender" id="nu"
					value="nu"> <label class="form-check-label" for="nu">
					Nữ </label>
			</div>

			<label for="tenDangNhap" class="form-label">Trạng thái hôn
				nhân</label>
			<div class="form-check">
				<input class="form-check-input" type="checkbox"
					value="Đã có gia đình" id="giaDinh" name="tinhTrangHonNhan">
				<label class="form-check-label" for="giaDinh"> Đã có gia
					đình </label>
			</div>

			<label for="tenDangNhap" class="form-label">Quốc tịch</label> <select
				class="form-select" aria-label="multiple select example"
				name="quocTich">
				<option value="Mỹ">Mỹ</option>
				<option value="Canada">Canada</option>
				<option value="Việt Nam">Việt nam</option>
			</select> <label for="tenDangNhap" class="form-label">Sở thích</label>
			<div class="form-check">
				<input class="form-check-input" type="checkbox" name="hobbies"
					value="docSach" id="docSach"> <label
					class="form-check-label" for="docSach"> Đọc sách </label>
			</div>
			<div class="form-check">
				<input class="form-check-input" type="checkbox" name="hobbies"
					value="duLich" id="duLich"> <label class="form-check-label"
					for="duLich"> Du lịch </label>
			</div>
			<div class="form-check">
				<input class="form-check-input" type="checkbox" name="hobbies"
					value="amNhac" id="amNhac"> <label class="form-check-label"
					for="amNhac"> Âm nhạc </label>
			</div>
			<div class="form-check">
				<input class="form-check-input" type="checkbox" name="hobbies"
					value="khac" id="khac"> <label class="form-check-label"
					for="khac"> Khác </label>
			</div>

			<br>
			<div class="mb-3">
				<label for="ghiChu" class="form-label">Ghi chú</label>
				<textarea class="form-control" rows="" cols="" name="ghiChu"></textarea>
			</div>
			<hr>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
		<a href="<c:url value='/home-page'/>" class="btn btn-outline-primary">Index</a>
	</div>
</body>
</html>