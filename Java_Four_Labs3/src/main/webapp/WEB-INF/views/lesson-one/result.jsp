<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String img = request.getAttribute("image") + "";
	String document = request.getAttribute("document") + "";
	String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath();
	%>
	Name:
	<%=img%>
	<br>
	<img alt="" src="uploads/<%=img%>" width="140px" height="100px">
	<br> Name document:
	<%=document%><br>
	<a href="D:/eclip-workspace-09/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/Java_Four_Labs3/uploads/<%=document%>">Dowload</a>
	<a href="<c:url value='/home-page'/>" class="btn btn-outline-primary">Index</a>
</body>
</html>