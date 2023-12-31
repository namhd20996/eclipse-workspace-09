<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap demo</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
</head>
<body>

	<%
	String message = request.getAttribute("message") + "";
	%>
	<div class="container">
		<h1 style="text-align: center;">Login</h1>
		<form action="<c:url value='/login-servlet'/>" method="post">
			<input type="hidden" name="action" value="login">
			<%
			if (!message.equals("null")) {
			%>
			<label for="inputEmail3" class="col-sm-2 col-form-label"><%=message%></label>
			<%
			}
			%>
			<div class="row mb-3">

				<label for="inputEmail3" class="col-sm-2 col-form-label">User</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="user">
				</div>
			</div>
			<div class="row mb-3">
				<label for="inputPassword3" class="col-sm-2 col-form-label">Password</label>
				<div class="col-sm-10">
					<input type="password" class="form-control" name="password">
				</div>
			</div>
			<div class="row mb-3">
				<div class="col-sm-10 offset-sm-2">
					<div class="form-check">
						<input class="form-check-input" type="checkbox" name="remember">
						<label class="form-check-label">Rememberme?</label>
					</div>
				</div>
			</div>
			<button type="submit" class="btn btn-primary">Sign in</button>
			<a href="<c:url value='/home-page'/>" class="btn btn-outline-primary">Index</a>
		</form>
	</div>
</body>
</html>