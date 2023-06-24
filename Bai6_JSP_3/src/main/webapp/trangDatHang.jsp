<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String hoVaTen = request.getParameter("hoVaTen");
	String email = request.getParameter("email");
	String soLuong = request.getParameter("soLuong");
	int soLuongSp = 0;
	try{
		soLuongSp = Integer.parseInt(soLuong);
	}catch(Exception e){
		e.printStackTrace();
	}
	%>

	<h1>Xác nhận đặt hàng:</h1>
	<p>
		Xin cảm ơn bạn: <b> <%=hoVaTen%></b> Đã đặt:<b> <%=soLuongSp%>
		</b> sản phẩm <br> 
		Số tiền bạn cần thanh toán: <%= soLuongSp*5 %> $
		Bạn sẽ nhận được thông báo qua email: <%=email%>
	</p>
</body>
</html>