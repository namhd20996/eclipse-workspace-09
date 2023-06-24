 <%@page import="model.KhachHangModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Navbar -->
	<nav class="navbar navbar-expand-lg bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">Navbar</a>
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
						data-bs-toggle="dropdown" aria-expanded="false"> Dropdown </a>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="#">Action</a></li>
							<li><a class="dropdown-item" href="#">Another action</a></li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item" href="#">Something else
									here</a></li>
						</ul></li>
					<li class="nav-item"><a class="nav-link disabled">Disabled</a>
					</li>
				</ul>
				<form class="d-flex" role="search">
					<input class="form-control me-2" type="search" placeholder="Search"
						aria-label="Search">
					<button class="btn btn-outline-success" type="submit">Search</button>

					<%
					KhachHangModel khachHang = (KhachHangModel) session.getAttribute("khachHang");
					
					if (khachHang == null) {
					%>

					<a class="btn btn-primary" style="white-space: nowrap;"
						href="khachhang/login.jsp"> Đăng nhập </a>
					<%
					} else {
					%>
					<% String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
									+ request.getContextPath(); %>
					<ul class="navbar-nav me-auto mb-2 mb-lg-0 bg-infor ">
						<li class="nav-item dropdown dropstart"><a
							class="nav-link dropdown-toggle" href="#" role="button"
							data-bs-toggle="dropdown" aria-expanded="false"> Tài khoản</a>
							<ul class="dropdown-menu">
								<li><a class="dropdown-item" href="#">Đơn hàng của tôi</a></li>
								<li><a class="dropdown-item" href="#">Thông báo</a></li>
								<li><a class="dropdown-item"
									href="<%=url %>/khachhang/information.jsp">Thay đổi thông tin</a></li>
									<li><a class="dropdown-item"
									href="<%=url %>/khachhang/changeimg.jsp">Thay đổi ảnh</a></li>
								<li><a class="dropdown-item"
									href="<%=url %>/khachhang/changepassword.jsp">Đổi mật khẩu</a></li>
								<li><hr class="dropdown-divider"></li>
								<li><a class="dropdown-item"
									href="<%=url %>/khach-hang?action=dang-xuat">Thoát tài khoản</a></li>
							</ul></li>
					</ul>
					<%
					}
					%>
				</form>
			</div>
		</div>
	</nav>
	<!-- Navbar end -->