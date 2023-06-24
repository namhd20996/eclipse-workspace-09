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
		String userName = (String)session.getAttribute("userName");
		
	%>
	<!-- Kiểm tra nếu userName trong session có tồn tại nó sẽ chuyển trang đến trang success.jsp -->
	<% if(userName != null) { %>
		<jsp:forward page="success.jsp"></jsp:forward>
	<% }%>

	<form action="login" method="GET">
	<table>
	<tr>
		<td colspan="2">LOGIN</td>
	</tr>
	<tr>
		<td>Username</td>
		<td><input type="text" name="username"/></td>
	</tr>
	<tr>
		<td>Password</td>
		<td><input type="password" name="password"/></td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" value="Login"/></td>
	</tr>
	</table>
</form>
</body>
</html>