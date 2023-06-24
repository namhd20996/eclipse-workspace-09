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
</head>
<style>
	.rq {
		color: red;
	}
</style>
<script>
	function my_submit(){
			// Bắt lỗi
			var maSanPham = document.getElementById("maSanPham").value;
			var error = "";
			var giaBan = document.getElementById("giaBan").value;
			if(maSanPham.length==0){
				error = "Chưa nhập mã sản phẩm";
			}
			
			if(giaBan<=0){
				error_giaBan =  document.getElementById("error_giaBan");
				error_giaBan.innerHTML = "<span class='rq'>Bạn cần nhập giá bán </span>";
			}
			
			if(error.length>0){
				alert(error);
				return;
			}else{
				// Submit form
				var	my_form = document.getElementById("my_form");
				my_form.submit();
			}
	}
</script>
<body>
	<%
		String e_maSanPham = request.getAttribute("e_maSanPham")+"";
		e_maSanPham = e_maSanPham.equals("null")?"":e_maSanPham;
	
		String value_maSanPham = request.getAttribute("value_MSP")+"";
		String value_tenSanPham = request.getAttribute("value_tenSanPham")+"";
		String value_giaBanSP = request.getAttribute("value_giaBanSP")+"";
		String value_giaNhapSP = request.getAttribute("value_giaNhapSP")+"";
		String value_hanSuDung = request.getAttribute("value_hanSuDung")+"";
		String value_vat = request.getAttribute("value_vat")+"";
		String value_moTa = request.getAttribute("value_moTa")+"";
		
		value_maSanPham = value_maSanPham.equals("null")?"":value_maSanPham;
		value_tenSanPham = value_tenSanPham.equals("null")?"":value_tenSanPham;
		value_giaBanSP = value_giaBanSP.equals("null")?"":value_giaBanSP;
		value_giaNhapSP = value_giaNhapSP.equals("null")?"":value_giaNhapSP;
		value_hanSuDung = value_hanSuDung.equals("null")?"":value_hanSuDung;
		value_vat = value_vat.equals("null")?"":value_vat;
		value_moTa = value_moTa.equals("null")?"":value_moTa;
	%>

	<div class="container mt-4">
		<form action="save-product" class="row g-3 needs-validation" id="my_form">
			<div class="row">
				<div class="col-6">
					<label for="maSanPham" class="form-label">Mã sản phẩm<span
						class="rq">*</span></label> <input type="text" class="form-control"
						id="maSanPham" name="maSanPham" value="<%=value_maSanPham %>" required>
					<div class="rq"><%= e_maSanPham %></div>
				</div>
				<div class="col-6">
					<label for="tenSanPham" class="form-label">Tên sản phẩm<span
						class="rq">*</span></label> <input type="text" class="form-control"
						id="tenSanPham" name="tenSanPham" value="<%=value_tenSanPham %>" required>
				</div>
			</div>
			
			<div class="row">
				<div class="col-6">
					<label for="giaNhap" class="form-label">Giá nhập<span
						class="rq">*</span></label> <input type="number" class="form-control"
						id="giaNhap" name="giaNhap" value="<%=value_giaNhapSP %>" required>
					<div class="rq"></div>
				</div>
				<div class="col-6">
					<label for="giaBan" class="form-label">Giá bán<span
						class="rq">*</span></label> <input type="number" class="form-control"
						id="giaBan" name="giaBan" value="<%=value_giaBanSP %>" required>
						<span class="errorMessage" id="error_giaBan"></span>
				</div>
			</div>
			
			<div class="row">
				<div class="col-6">
					<label for="hanSuDung" class="form-label">Hạn sử dụng</label> 
					<input type="datetime-local" class="form-control"
						id="hanSuDung" name="hanSuDung" value="<%= value_hanSuDung %>" required>
					<div class="rq"></div>
				</div>
				<div class="col-6">
					<label for="vat" class="form-label">Thuế</label> 
					<input type="number" class="form-control"
						id="vat" name="vat" value="<%=value_vat %>" required>
				</div>
			</div>

			<div class="row">
				<div class="col-12">
					<label for="moTa" class="form-label">Mô tả sản phẩm </label>
					<textarea rows="10" cols="5" name="moTa" class="form-control" value=""><%=value_moTa %></textarea>
				</div>

				<div class="col-12">
					<button class="btn btn-primary col-12" type="button" onclick="my_submit()">Submit</button>
				</div>
		</form>
	</div>
</body>
</html>