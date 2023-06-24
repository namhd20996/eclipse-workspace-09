<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
		.rq {
			color: red;
		}
	
	</style>
</head>
<body>
	<%
	
	%>
	<div class="container mt-4">
		<form action="save-product" class="row g-3 needs-validation" id="my_form">
			<div class="row">
				<div class="col-6">
					<label for="maSanPham" class="form-label">Mã sản phẩm<span
						class="rq">*</span></label> <input type="text" class="form-control"
						id="maSanPham" name="maSanPham" value="" required="required">
					<div class="rq"></div>
				</div>
				<div class="col-6">
					<label for="tenSanPham" class="form-label">Tên sản phẩm<span
						class="rq">*</span></label> <input type="text" class="form-control"
						id="tenSanPham" name="tenSanPham" value="" required>
				</div>
			</div>
			
			<div class="row">
				<div class="col-6">
					<label for="giaNhap" class="form-label">Giá nhập<span
						class="rq">*</span></label> <input type="number" class="form-control"
						id="giaNhap" name="giaNhap" value="" required>
					<div class="rq"></div>
				</div>
				<div class="col-6">
					<label for="giaBan" class="form-label">Giá bán<span
						class="rq">*</span></label> <input type="number" class="form-control"
						id="giaBan" name="giaBan" value="" required>
						<span class="errorMessage" id="error_giaBan"></span>
				</div>
			</div>
			
			<div class="row">
				<div class="col-6">
					<label for="hanSuDung" class="form-label">Hạn sử dụng</label> 
					<input type="datetime-local" class="form-control"
						id="hanSuDung" name="hanSuDung" value="" required>
					<div class="rq"></div>
				</div>
				<div class="col-6">
					<label for="vat" class="form-label">Thuế</label> 
					<input type="number" class="form-control"
						id="vat" name="vat" value="" required>
				</div>
			</div>

			<div class="row">
				<div class="col-12">
					<label for="moTa" class="form-label">Mô tả sản phẩm </label>
					<textarea rows="10" cols="5" name="moTa" class="form-control" value=""></textarea>
				</div>

				<div class="col-12">
					<button class="btn btn-primary col-12" type="submit">Submit</button>
				</div>
		</form>
	</div>
	
</body>
</html>