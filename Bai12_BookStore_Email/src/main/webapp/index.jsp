<%@page import="model.KhachHangModel"%>
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
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<!-- Page content -->
	<div class="container">
		<div class="row">
			<!-- col-lg-3 chia 12 cột trên web thành số cột mong muốn -->
			<div class="col-lg-3">
				<!-- Menu left -->
				<div class="list-group">
					<a href="#" class="list-group-item list-group-item-action active"
						aria-current="true"> The current link item </a> <a href="#"
						class="list-group-item list-group-item-action">A second link
						item</a> <a href="#" class="list-group-item list-group-item-action">A
						third link item</a> <a href="#"
						class="list-group-item list-group-item-action">A fourth link
						item</a> <a class="list-group-item list-group-item-action disabled">A
						disabled link item</a>
				</div>

			</div>
			<!-- Menu right -->
			<div class="col-lg-9">
				<!-- Silder -->
				<div id="carouselExampleControlsNoTouching" class="carousel slide"
					data-bs-touch="false">
					<div class="carousel-inner">
						<div class="carousel-item active">
							<img
								src="https://salt.tikicdn.com/cache/w1080/ts/banner/45/86/fc/f85ab83e5379bbc3edf0cea1e6e6faa2.png.webp"
								class="d-block w-100" alt="...">
						</div>
						<div class="carousel-item">
							<img
								src="https://salt.tikicdn.com/cache/w1080/ts/banner/17/59/38/1d1b7f24b6c90b93b4b4d93b34c8e22d.png.webp"
								class="d-block w-100" alt="...">
						</div>
						<div class="carousel-item">
							<img
								src="https://salt.tikicdn.com/cache/w1080/ts/banner/f0/87/80/73a3ee32d6d736ca288656f77b6b9532.png.webp"
								class="d-block w-100" alt="...">
						</div>
					</div>
					<button class="carousel-control-prev" type="button"
						data-bs-target="#carouselExampleControlsNoTouching"
						data-bs-slide="prev">
						<span class="carousel-control-prev-icon" aria-hidden="true"></span>
						<span class="visually-hidden">Previous</span>
					</button>
					<button class="carousel-control-next" type="button"
						data-bs-target="#carouselExampleControlsNoTouching"
						data-bs-slide="next">
						<span class="carousel-control-next-icon" aria-hidden="true"></span>
						<span class="visually-hidden">Next</span>
					</button>
				</div>
				<!-- End Silder -->
				<!-- Product -->
				<div class="row">
					<div class="col-lg-4 col-md-6 mb-4">
						<div class="card h-100">
							<a href="#"><img class="card-img-top" src="product/1.png"
								alt="" height=""></a>
							<div class="card-body">
								<h4 class="card-title">
									<a href="#">Áo thun Pro-S1</a>
								</h4>
								<h5>50.000</h5>
								<p class="card-text">Sản phẩm thoáng mát, có độ bền tốt, giữ
									màu sắc tốt.</p>
							</div>
							<div class="card-footer">
								<small class="text-muted">&#9733; &#9733; &#9733;
									&#9733; &#9734;</small>
							</div>
						</div>
					</div>

					<div class="col-lg-4 col-md-6 mb-4">
						<div class="card h-100">
							<a href="#"><img class="card-img-top" src="product/1.png"
								alt="" height=""></a>
							<div class="card-body">
								<h4 class="card-title">
									<a href="#">Áo thun Pro-S1</a>
								</h4>
								<h5>50.000</h5>
								<p class="card-text">Sản phẩm thoáng mát, có độ bền tốt, giữ
									màu sắc tốt.</p>
							</div>
							<div class="card-footer">
								<small class="text-muted">&#9733; &#9733; &#9733;
									&#9733; &#9734;</small>
							</div>
						</div>
					</div>

					<div class="col-lg-4 col-md-6 mb-4">
						<div class="card h-100">
							<a href="#"><img class="card-img-top" src="product/1.png"
								alt="" height=""></a>
							<div class="card-body">
								<h4 class="card-title">
									<a href="#">Áo thun Pro-S1</a>
								</h4>
								<h5>50.000</h5>
								<p class="card-text">Sản phẩm thoáng mát, có độ bền tốt, giữ
									màu sắc tốt.</p>
							</div>
							<div class="card-footer">
								<small class="text-muted">&#9733; &#9733; &#9733;
									&#9733; &#9734;</small>
							</div>
						</div>
					</div>

					<!-- End product -->
				</div>
			</div>
		</div>
		<!-- End page content -->
		<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>