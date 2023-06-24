<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
		String hoVaTen = request.getParameter("hoVaTen");
		String email = request.getParameter("email");
		int soLuong = 0;
		try{
			soLuong = Integer.valueOf(request.getParameter("soLuong"));
		}catch(Exception e){
			e.printStackTrace();
		}
	%>
	
	<h1>Cảm ơn bạn đã đặt hàng:</h1> <br>
	<h2>Họ tên: <%=hoVaTen %></h2>
	<h2>Số lượng hàng là : <%=soLuong %></h2> <br>
	<h2>Thành tiền: <%=soLuong*5%></h2> <br>
	<h2>Bạn sẽ nhận được thông báo qua email: <%=email %></h2>
</body>
</html>