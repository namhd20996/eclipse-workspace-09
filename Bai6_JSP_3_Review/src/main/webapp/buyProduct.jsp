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
		String processor = request.getParameter("processor");
		String ram = request.getParameter("ram");
		String monitor = request.getParameter("monitor");
		String[] arr = request.getParameterValues("accessories");
		
		double processorPrice = 0;
		if(processor !=null){
			if(processor.equals("Core I9")){
				processorPrice = 1500;
			}
			if(processor.equals("Core I7")){
				processorPrice = 1000;
			}
			if(processor.equals("Core I5")){
				processorPrice = 500;
			}
			tongTien +=processorPrice;
		}
		
		double ramPrice = 0;
		if(ram!=null){
			if(ram.equals("Ram 16GB")){
				ramPrice = 1000;
			}
			if(ram.equals("Ram 8GB")){
				ramPrice = 500;
			}
			tongTien+= ramPrice;
		}
		
		double monitorPrice = 0;
		if(monitor != null){
			monitorPrice = 1000;
		}
		tongTien +=monitorPrice;
		
		if(arr != null){
			for(String str: arr){
				if(str.equals("Camera")){
					tongTien += 500;
				}
				if(str.equals("Printer")){
					tongTien += 500;
				}
				if(str.equals("Scanner")){
					tongTien += 500;
				}
			}
		}
	%>
	
	
	<h1>Xác nhận đơn hàng</h1>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">Tên sản phẩm</th>
				<th scope="col">Giá tiền</th>
			</tr>
		</thead>
		
		<tbody>
			<%if(processor != null){ %>
			<tr>
				<td><%=processor %></td>
				<td><%=processorPrice %></td>
				<td><%=request.getParameter("monitor")%></td>
			</tr>
			<%} %>
		
			<%if(ram !=null){ %>
			<tr>
				<td><%=ram %></td>
				<td><%=ramPrice %></td>
			</tr>
			<%} %>
			
			<%if(monitor != null){ %>
			<tr>
				<td><%=monitor %></td>
				<td><%=monitorPrice %></td>
			</tr>
			<%} %>
			
			<%
			if(arr != null){
				double price = 0;
				for(String str: arr){
					if(str.equals("Camera")){
						price= 500;
					}
					if(str.equals("Printer")){
						price= 500;
					}
					if(str.equals("Scanner")){
						price= 500;
					}
					%>
					<tr>
						<td><%=str %></td>
						<td><%=price %></td>
					</tr>
					
					<%
				}
			}
			%>
			
		</tbody>
	
	</table>
</body>
</html>