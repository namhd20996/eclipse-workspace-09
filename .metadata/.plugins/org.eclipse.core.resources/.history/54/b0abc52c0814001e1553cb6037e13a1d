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
	String baoLoi = request.getAttribute("baoLoi") + "";
	String canh_a = request.getAttribute("canh_a") + "";
	String canh_b = request.getAttribute("canh_b") + "";
	String canh_c = request.getAttribute("canh_c") + "";

	canh_a = canh_a.equals("null") ? "" : canh_a;
	canh_b = canh_b.equals("null") ? "" : canh_b;
	canh_c = canh_c.equals("null") ? "" : canh_c;

	String dienTich = request.getAttribute("dienTich") + "";
	String chuVi = request.getAttribute("chuVi") + "";

	dienTich = dienTich.equals("null") ? "" : dienTich;
	chuVi = chuVi.equals("null") ? "" : chuVi;
	%>
	<form action="labs2-ctl" method="post">
		<table>
			<tr>
				<td colspan="2">Thông Tin Hình Tam Giác</td>
			</tr>
			<tr>
				<td>Cạnh a</td>
				<td><input type="text" name="canha" value="<%=canh_a%>" /></td>
			</tr>
			<tr>
				<td>Cạnh b</td>
				<td><input type="text" name="canhb" value="<%=canh_b%>" /></td>
			</tr>


			<tr>
				<td>Cạnh c</td>
				<td><input type="text" name="canhc" value="<%=canh_c%>" /></td>
			</tr>
			<tr>
				<td colspan=""><input type="submit"  name="action"  value="tinhDienTich" /></td>
				<td colspan=""><input type="submit"  name="action" value="tinhChuVi" /></td>
			</tr>

			<tr>
				<td>Diện tích</td>
				<td><input type="text" name="canhc" value="<%=dienTich%>" /></td>
			</tr>

			<tr>
				<td>Chu vi</td>
				<td><input type="text" name="canhc" value="<%=chuVi%>" /></td>
			</tr>

			<%
			if (!baoLoi.equals("null")) {
			%>
			<tr>
				<td>Báo lỗi</td>
				<td><%=baoLoi%></td>
			</tr>
			<%
			}
			%>
		</table>
	</form>
</body>
</html>