<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap demo</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
</head>
<body>

	<h1 style="text-align: center;">Thông Tin Nhân Viên</h1>
	<div class="container">
		<form class="row g-3" action="<c:url value='/bai-2'/>" method="POST"
			enctype="multipart/form-data">
			<div class="col-md-6">
				<label for="hoTen" class="form-label">Họ tên</label> <input
					type="text" class="form-control" id="hoTen" name="hoTen">
			</div>
			<div class="col-md-6">
				<label for="ngaySinh" class="form-label">Ngày sinh</label> <input
					type="date" class="form-control" id="ngaySinh" name="ngaySinh">
			</div>


			<div class="col-md-6">
				<label class="form-label">Hình ảnh</label> <input
					type="file" class="form-control"  name="hinhAnh">
			</div>
			<div class="col-md-6">
				<label for="quocTich" class="form-label">Quốc Gia</label> <select
					id="quocTich" class="form-select" name="quocTich">
					<option selected>Choose...</option>
					<option value="USA">Mỹ</option>
					<option value="TL">Thái Lan</option>
					<option value="VN">Việt Nam</option>
				</select>
			</div>
			<div class="col-md-6">
				<label for="gioiTinh" class="form-label">Giới tính:</label>
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="radio" name="gioiTinh"
						id="nam" value="true"> <label class="form-check-label"
						for="nam">Nam</label>
				</div>
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="radio" name="gioiTinh"
						id="nu" value="false"> <label class="form-check-label"
						for="nu">Nữ</label>
				</div>

			</div>
			<div class="col-md-6">
				<label for="gioiTinh" class="form-label">Tình trạng hôn
					nhân:</label>
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="checkbox" name="ttHonNhan"
						id="" value="true"> <label class="form-check-label"
						for="ttHonNhan"></label>
				</div>

			</div>
			<div class="col-md-6">
				<label for="" class="form-label">Sở thích:</label>
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="checkbox" id="docSach"
						name="soThich" value="docSach"> <label
						class="form-check-label" for="docSach">Đọc sách</label>
				</div>
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="checkbox" id="duLich"
						name="soThich" value="option2"> <label
						class="form-check-label" for="duLich">Du lịch</label>
				</div>
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="checkbox" id="amNhac"
						name="soThich" value="option2"> <label
						class="form-check-label" for="amNhac">Âm nhạc</label>
				</div>
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="checkbox" id="khac"
						value="khac"> <label class="form-check-label"
						name="soThich" for="khac">Khác</label>
				</div>
			</div>
			<div class="form-floating">
				<textarea class="form-control" placeholder="Leave a comment here"
					id="ghiChu" style="height: 100px" name="ghiChu"></textarea>
				<label for="ghiChu">Ghi chú</label>
			</div>
			<hr>
			<div class="col-12">
				<button type="submit" class="btn btn-primary">Sign in</button>
				<a href="<c:url value='/home-page'/>" class="btn btn-outline-primary">Index</a>
			</div>
		</form>
		
		
		<h1 style="text-align: center;">Thông Tin Đăng Ký</h1>
		<ul>
			<li>Họ và tên: ${staff.hoTen }</li>
			<li>Hình ảnh: ${staff.hinhAnh }</li>
			<li>Ngày sinh: ${staff.ngaySinh }</li>
			<li>Giới tính: ${staff.gioiTinh ?"Nam":"Nữ" }</li>
			<li>Quốc tịch: ${staff.quocTich }</li>
			<li>TT Hôn nhân: ${staff.ttHonNhan ? "Đã kết hôn" : "Chưa kết hôn" }</li>
			<li>Sở thích: ${staff.soThich }</li>
			<li>Ghi chú: ${staff.ghiChu }</li>
			<li><img alt="" src="images/${staff.hinhAnh }"> </li>
		</ul>
		
	</div>
</body>
</html>