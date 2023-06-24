<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
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
<%
String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
		+ request.getContextPath();
String baoLoi = request.getAttribute("baoLoi") + "";
baoLoi = baoLoi.equals("null") ? "" : baoLoi;
%>
	<form action="<%=url%>/detail-servlet" method="post">
		<div class="card" style="width: 50%;">
			<img src="<%=url%>/image/${item.image }"
				class="card-img-top" alt="...">
			<div class="card-body">
				<h5 class="card-title">Tên sản phẩm:${item.name }</h5>
				<p class="card-text">
					Giá gốc:<strike>${item.price}</strike>
				</p>
				<p class="card-text">
					Giá mới:
					<c:set var="newprice" value="${item.price*(1-item.discount)}" />
					<fmt:formatNumber value="${newprice}" />
				</p>
				<p class="card-text">
					Mức giá:
					<c:choose>
						<c:when test="${newprice< 10}">Giá thấp</c:when>
						<c:when test="${newprice> 100}">Giá cao</c:when>
						<c:otherwise>Bình thường</c:otherwise>
					</c:choose>
				</p>
			</div>
		</div>
	</form>
</body>
</html>