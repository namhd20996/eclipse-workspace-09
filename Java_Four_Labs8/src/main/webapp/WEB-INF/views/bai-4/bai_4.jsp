<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.7/dist/umd/popper.min.js"
	integrity="sha384-zYPOMqeu1DAVkHiLqWBUTcbYfZ8osu1Nd6Z89ify25QV9guujx43ITvfi12/QExE"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.min.js"
	integrity="sha384-Y4oOpwW3duJdCWv5ly8SCFYWqFDsfob/3GkgExXKV4idmbt98QcxXYs9UoXAB7BZ"
	crossorigin="anonymous"></script>
</head>
<body>
	<fmt:setLocale value="${sessionScope.lang }"/>
	<fmt:setBundle basename="com.example.i18n.example"/>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="#"><fmt:message key="menu.navarbar"/></a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link" href="#"><fmt:message key="menu.myFavorites"/></a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-bs-toggle="dropdown" aria-expanded="false">
							 <fmt:message key="menu.account"/></a>
						<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
							<li><a class="dropdown-item" href="<c:url value='/login'/>"><fmt:message key="menu.login"/></a></li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item" href="<c:url value='/logout'/>"><fmt:message key="menu.forgot"/></a></li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item" href="<c:url value='/logout'/>"><fmt:message key="menu.registration"/></a></li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item" href="<c:url value='/logout'/>"><fmt:message key="menu.changePass"/></a></li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item" href="<c:url value='/logout'/>"><fmt:message key="menu.logout"/></a></li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item" href="<c:url value='/logout'/>"><fmt:message key="menu.edit"/></a></li>
						</ul></li>
				</ul>
				<form class="d-flex">
					<a href="?lang=vi_VN" class="btn btn-outline-warning" type="submit"><img style="width: 50px; height: 25px" alt="" src="https://st.quantrimang.com/photos/image/2021/09/05/Co-Vietnam.png"></a>
					<a href="?lang=en_US" class="btn btn-outline-warning" type="submit"><img style="width: 50px; height: 25px" alt="" src="https://gotusa-admin-storage.s3.us-east-2.amazonaws.com/5fb84260-718d-11ea-97a3-972b6b8f96d6.jpg"></a>
				</form>
			</div>
		</div>
	</nav>
</body>
</html>