<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Insert title here</title>
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
<style type="text/css">
	.red {
		color: red;
	}

</style>


<!-- Custom styles for this template -->
<%
String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
		+ request.getContextPath();
String baoLoi = request.getAttribute("baoLoi")+"";
baoLoi = baoLoi.equals("null")?"":baoLoi;
%>
<link href="<%=url%>/css/signin.css" rel="stylesheet"><body>
	<main class="form-signin w-100 m-auto">
		<form class="text-center" action="dang-nhap" method="POST">
			<img class="mb-4" src="<%=url%>/img/logo/Duynam%20(4).png" alt=""
				width="280px">
			<h1 class="h3 mb-3 fw-normal">ĐĂNG NHẬP</h1>
			<div class="text-center"> <span class="red"><%=baoLoi %></span> </div>
			<div class="text-center">
				<span class="red"></span>
			</div>
			<div class="form-floating">
				<input type="text" class="form-control" id="tenDangNhap"
					placeholder="Tên đăng nhập" name="tenDangNhap"> <label
					for="tenDangNhap">Tên đăng nhập</label>
			</div>
			<div class="form-floating">
				<input type="password" class="form-control" id="matKhau"
					placeholder="Mật khẩu" name="matKhau"> <label for="matKhau">Mật
					khẩu</label>
			</div>

			<div class="checkbox mb-3">
				<label> <input type="checkbox" value="remember-me">
					Ghi nhớ tài khoản này
				</label>
			</div>
			<button class="w-100 btn btn-lg btn-primary" type="submit">Đăng
				nhập</button>
			<a href="register.jsp">Đăng ký tài khoản mới</a>
			<p class="mt-5 mb-3 text-muted">&copy; 2017–2025</p>
		</form>
	</main>
</body>
</html>