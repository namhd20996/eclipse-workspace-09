<%@include file="/common/taglib.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Navbar -->
	<nav class="navbar navbar-expand-lg bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">Shopping Mall</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="#">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" role="button"
						data-bs-toggle="dropdown" aria-expanded="false"> Lesson </a>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="<c:url value='/detail-servlet'/>">Three</a></li>
							<li><a class="dropdown-item" href="<c:url value='/list-servlet'/>">Four</a></li>
							<li><hr class="dropdown-divider"></li>
						</ul></li>
					
				</ul>
				<form class="d-flex" role="search">
					<input class="form-control me-2" type="search" placeholder="Search"
						aria-label="Search">
					<button class="btn btn-outline-success" type="submit">Search</button>


					<a class="btn btn-primary" style="white-space: nowrap;"
						href="<c:url value='/user-servler'/>"> Đăng nhập </a>
					
					<% String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
									+ request.getContextPath(); %>
					
				</form>
			</div>
		</div>
	</nav>
	<!-- Navbar end -->