<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
	integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js"
	integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz"
	crossorigin="anonymous"></script>
</head>
<body>
	<%
		double tongTien = 0;
	
		// Radio
		String processor = request.getParameter("processor");
		double processorPrice = 0;
		if (processor != null) {
			if (processor.equals("Core I9")) {
				processorPrice = 5000;
			} else if (processor.equals("Core I7")) {
				processorPrice = 4000;
			} else if (processor.equals("Core I5")) {
				processorPrice = 3000;
			}
			tongTien += processorPrice;
		}
	
		// Radio
		String ram = request.getParameter("ram");
		double ramPrice = 0;
		if (ram != null) {
			if (ram.equals("Ram 8GB")) {
				ramPrice = 500;
			} else if (ram.equals("Ram 16GB")) {
				ramPrice = 1000;
			}
			tongTien +=ramPrice;
		}
	
		// Checkbox
		String monitor = request.getParameter("monitor");
		double monitorPrice = 0;
		if (monitor != null) {
			monitorPrice = 1500;
		}
		tongTien+=monitorPrice;
	
		// Select
		String[] arr = request.getParameterValues("accessories");
		if(arr != null){
			for (String str : arr) {
				if (str.equals("Camera")) {
					tongTien+=1000;
				}
		
				if (str.equals("Printer")) {
					tongTien+=2000;
				}
		
				if (str.equals("Scanner")) {
					tongTien+=3000;
				}
			}
		}
	%>
	
	<h1>Hóa đơn:</h1>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">Tên sản phẩm</th>
				<th scope="col">Giá tiền</th>
			</tr>
		</thead>
		
		<tbody>
			<% if(processor!=null){ %>
			<tr>
				<td><%= processor %></td>
				<td><%= processorPrice %></td>
			</tr>
			<% } %>
			<% if(ram!=null){ %>
			<tr>
				<td><%= ram %></td>
				<td><%= ramPrice %></td>
			</tr>
			<%} %>
			<% if(monitor!=null){ %>
			<tr>
				<td><%= monitor %></td>
				<td><%= monitorPrice %></td>
			</tr>
			<%} %>
			<%
				if(arr != null){
					double price = 0;
					for (String str : arr) {
						if (str.equals("Camera")) {
							price=1000;
						}
				
						if (str.equals("Printer")) {
							price=2000;
						}
				
						if (str.equals("Scanner")) {
							price=3000;
						}
						%>
						<tr>
							<td><%= str %></td>
							<td><%= price %></td>
						</tr>
						<% 
					}
				}
			%>
			<tr>
				<td>Tổng tiền</td>
				<td><b><%=tongTien %></b></td>
			</tr>
		</tbody>
		
	</table>
</body>
</html>