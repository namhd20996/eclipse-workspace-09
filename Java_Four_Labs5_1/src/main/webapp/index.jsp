<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="dao.UserDao"%>
<%@page import="java.util.List"%>
<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
	crossorigin="anonymous"></script>
</head>
<body>
	<%
	String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath();
	String notification = request.getAttribute("notification") + "";
	User user = (User) request.getAttribute("user");
	String id = "";
	String password = "";
	String fullname = "";
	String email = "";
	boolean admin;
	String adminStr = "";
	if (user != null) {
		id = user.getId() + "";
		fullname = user.getFullname() + "";
		email = user.getEmail() + "";
		admin = user.getAdmin();
	}
	id = id.equals("null") ? "" : id;
	fullname = fullname.equals("null") ? "" : fullname;
	email = email.equals("null") ? "" : email;
	List<User> list = UserDao.getInstance().selectAll();
	%>
	
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
					User ud = (User) session.getAttribute("userSession");
					
					if (ud == null) {
					%>

					<a class="btn btn-primary" style="white-space: nowrap;"
						href="<%=url %>/login.jsp"> Đăng nhập </a>
					<%
					} else {
					%>
					
					<ul class="navbar-nav me-auto mb-2 mb-lg-0 bg-infor ">
						<li class="nav-item dropdown dropstart"><a
							class="nav-link dropdown-toggle" href="#" role="button"
							data-bs-toggle="dropdown" aria-expanded="false"> Tài khoản</a>
							<ul class="dropdown-menu">
								<li><a class="dropdown-item" href="#">Đơn hàng của tôi</a></li>
								<li><a class="dropdown-item" href="#">Thông báo</a></li>
								<li><a class="dropdown-item"
									href="<%=url %>/labs5-ctl?action=thay-doi-tt">Thay đổi thông tin</a></li>
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
					String message = request.getAttribute("message")+"";
					%>
				</form>
			</div>
		</div>
	</nav>
	<!-- Navbar end -->
	
	
	<div class="container">
	<h1><%= message%></h1>
		<h1 style="text-align: center;">Quản Lý Thông Tin Người Dùng</h1>
		<form action="labs5-ctl" method="post">
			<div class="mb-3">

				<label for="exampleInputEmail1" class="form-label">Username
				</label> <input name="id" type="text" class="form-control"
					id="exampleInputEmail1" aria-describedby="emailHelp"
					value="<%=id%>">
			</div>
			<div class="mb-3">
				<label for="exampleInputPassword1" class="form-label">Password</label>
				<input name="password" type="password" class="form-control"
					id="exampleInputPassword1">
			</div>

			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">Fullname</label>
				<input name="fullname" type="text" class="form-control"
					id="exampleInputEmail1" aria-describedby="emailHelp"
					value="<%=fullname%>">
			</div>
			<div class="mb-3">
				<label for="exampleInputPassword1" class="form-label">Email</label>
				<input name="email" type="email" class="form-control"
					id="exampleInputPassword1" value="<%=email%>">
			</div>
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">Role</label> <br>
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="radio" name="admin"
						id="inlineRadio1" value="true"> <label
						class="form-check-label" for="inlineRadio1">Admin</label>
				</div>
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="radio" name="admin"
						id="inlineRadio2" value="false"> <label
						class="form-check-label" for="inlineRadio2">User</label>
				</div>
			</div>
			<%
			if (!notification.equals("null")) {
			%>
			<label for="exampleInputEmail1" class="form-label"
				style="color: red;"><%=notification%></label>
			<%
			}
			%>
			<hr>

			<button type="submit" name="action" value="create"
				class="btn btn-primary">Create</button>
			<button type="submit" name="action" value="update"
				class="btn btn-warning">Update</button>
			<button type="submit" name="action" value="delete"
				class="btn btn-danger">Delete</button>
			<button type="reset" name="action" value="reset"
				class="btn btn-success">Reset</button>
		</form>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">Username</th>
					<th scope="col">Password</th>
					<th scope="col">Fullname</th>
					<th scope="col">Email</th>
					<th scope="col">Role</th>
					<th scope="col">Edit</th>
				</tr>
			</thead>
			<tbody>
				<%
				if (list != null) {
					for (User u : list) {
				%>
				<tr>
					<td><%=u.getId()%></td>
					<td><%=u.getPassword()%></td>
					<td><%=u.getFullname()%></td>
					<td><%=u.getEmail()%></td>
					<td><%=u.getAdmin() ? "Admin" : "User"%></td>
					<td><a href="<%=url%>/labs5-ctl?edit=<%=u.getId()%>">Edit</a>
						<a href="<%=url%>/labs5-ctl?delete=<%=u.getId()%>">Delete</a></td>
				</tr>
				<%
				}
				}
				%>
			</tbody>
		</table>
	</div>
</body>
</html>