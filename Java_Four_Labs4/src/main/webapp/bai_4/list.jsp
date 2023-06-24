<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<!DOCTYPE html>
<html>
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
	String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath();
	String baoLoi = request.getAttribute("baoLoi") + "";
	baoLoi = baoLoi.equals("null") ? "" : baoLoi;
	%>

	<div class="container">
		<form action="" method="post">
			<!-- Product -->
			<div class="row">
				<c:forEach var="item" items="${items }">
				<div class="col-lg-4 col-md-6 mb-4">
						<div class="card h-100">
							<a href="<%=url%>/bai_3/detail.jsp"><img class="card-img-top"
								src="<%=url %>/image/${item.image}" alt="" height=""></a>
							<div class="card-body">
								<h4 class="card-title">
									<a href="#">Tên sản phẩm: ${item.name }</a>
								</h4>
								<h5>
									Giá gốc:<strike>${item.price}</strike>
								</h5>
								<h5>Giá giảm:${item.price*(1-item.discount)}</h5>
							</div>

							<div class="card-footer">
								<small class="text-muted">&#9733; &#9733; &#9733;
									&#9733; &#9734;</small>
							</div>
						</div>
					</div>
				</c:forEach>
				<!-- End product -->
		</form>
	</div>
	</div>
</body>
</html>