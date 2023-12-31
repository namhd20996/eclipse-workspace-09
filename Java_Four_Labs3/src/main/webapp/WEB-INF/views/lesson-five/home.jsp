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
	<form action="<c:url value='/bai-5'/>" method="post">
		<input type="hidden" name="action" value="send-email">
		<div class="container">
			<h1 style="text-align: center;">Send Email</h1>
			<div class="mb-3">
				<label for="exampleFormControlInput1" class="form-label">From
					address</label> <input type="email" class="form-control"
					id="exampleFormControlInput1" placeholder="name@example.com"
					name="from">
			</div>
			<div class="mb-3">
				<label for="exampleFormControlInput1" class="form-label">To
					address</label> <input type="email" class="form-control"
					id="exampleFormControlInput1" placeholder="name@example.com"
					name="to">
			</div>
			<div class="mb-3">
				<label for="exampleFormControlInput1" class="form-label">Subject
					address</label> <input type="text" class="form-control"
					id="exampleFormControlInput1" placeholder="Sản phẩm tốt"
					name="subject">
			</div>
			<div class="mb-3">
				<label for="exampleFormControlTextarea1" class="form-label">Body
				</label>
				<textarea class="form-control" id="exampleFormControlTextarea1"
					rows="3" name="body"></textarea>
			</div>

			<button class="form-control btn btn-primary" type="submit">Send</button>
			<a href="<c:url value='/home-page'/>" class="form-control btn btn-warning mt-5">Index</a>
			<hr>
			<%
			String notification = request.getAttribute("notification") + "";
			if (!notification.equals("null")) {
			%>
			<h3 style="text-align: center;"><%=notification %></h3>
			<%
			}
			%>
		</div>
	</form>
	
</body>
</html>