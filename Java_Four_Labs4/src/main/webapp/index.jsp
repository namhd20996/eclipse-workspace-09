
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

		<jsp:include page="category.jsp"></jsp:include>

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
				<jsp:include page="item.jsp">
				<jsp:param value="mountains-and-hills-5112952__480.jpg" name="image"/>
				<jsp:param value="Áo thun Pro-S1" name="name"/>
				<jsp:param value="50.000" name="price"/>
				<jsp:param value="Sản phẩm thoáng mát, có độ bền tốt, giữ màu
				sắc tốt." name="description"/>
				</jsp:include>
				
				<jsp:include page="item.jsp">
				<jsp:param value="mountains-and-hills-5112952__480.jpg" name="image"/>
				<jsp:param value="Áo thun Pro-S1" name="name"/>
				<jsp:param value="50.000" name="price"/>
				<jsp:param value="Sản phẩm thoáng mát, có độ bền tốt, giữ màu
				sắc tốt." name="description"/>
				</jsp:include>
				
				<jsp:include page="item.jsp">
				<jsp:param value="mountains-and-hills-5112952__480.jpg" name="image"/>
				<jsp:param value="Áo thun Pro-S1" name="name"/>
				<jsp:param value="50.000" name="price"/>
				<jsp:param value="Sản phẩm thoáng mát, có độ bền tốt, giữ màu
				sắc tốt." name="description"/>
				</jsp:include>
				
				<jsp:include page="item.jsp">
				<jsp:param value="mountains-and-hills-5112952__480.jpg" name="image"/>
				<jsp:param value="Áo thun Pro-S1" name="name"/>
				<jsp:param value="50.000" name="price"/>
				<jsp:param value="Sản phẩm thoáng mát, có độ bền tốt, giữ màu
				sắc tốt." name="description"/>
				</jsp:include>
				
				<jsp:include page="item.jsp">
				<jsp:param value="mountains-and-hills-5112952__480.jpg" name="image"/>
				<jsp:param value="Áo thun Pro-S1" name="name"/>
				<jsp:param value="50.000" name="price"/>
				<jsp:param value="Sản phẩm thoáng mát, có độ bền tốt, giữ màu
				sắc tốt." name="description"/>
				</jsp:include>
				
				<jsp:include page="item.jsp">
				<jsp:param value="mountains-and-hills-5112952__480.jpg" name="image"/>
				<jsp:param value="Áo thun Pro-S1" name="name"/>
				<jsp:param value="50.000" name="price"/>
				<jsp:param value="Sản phẩm thoáng mát, có độ bền tốt, giữ màu
				sắc tốt." name="description"/>
				</jsp:include>
				
			</div>

			<!-- End product -->

		</div>
	</div>
	</div>
	<!-- End page content -->
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>