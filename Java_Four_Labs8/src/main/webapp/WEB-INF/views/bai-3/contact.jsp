<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<fmt:setLocale value="${sessionScope.lang }"/>
	<fmt:setBundle basename="com.example.i18n.lang"/>
	<h1>FPT Polytechnic</h1>
	<hr>
	<c:url var="home" value="/home"/>
	<a href="${home }/bai-3"><fmt:message key="menu.home"/></a>
	<a href="${home }/new"><fmt:message key="menu.news"/></a>
	<a href="${home }/contact/bai-3"><fmt:message key="menu.contact"/></a> ||
	<a href="?lang=en_US"><fmt:message key="menu.english"/></a>
	<a href="?lang=vi_VN"><fmt:message key="menu.vietnamese"/></a>
	<hr>
	<div><fmt:message key="contact.content"/></div>
</body>
</html>