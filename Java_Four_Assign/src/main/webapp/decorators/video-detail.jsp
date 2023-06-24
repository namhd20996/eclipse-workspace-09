<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="/common/include.jsp"%>
</head>
<body>
	<%@include file="/common/web/navbar.jsp" %>
	<dec:body/>
	<%@include file="/common/web/footer.jsp" %>
</body>
<script src="<c:url value='/templates/web/js/bootstrap.bundle.min.js'/>"></script>
	<script type="text/javascript">
        $(window).on("load", function() {
            $('body').addClass('loaded');
        });
    </script>
</html>