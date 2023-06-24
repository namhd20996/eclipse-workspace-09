<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
        <div class="container">
            <a class="navbar-brand" href="<c:url value='/trang-chu'/>">Online Entertaiment</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive"
                aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav ms-auto">
               		<c:if test="${not empty sessionScope.currentUser }">
	               		<li class="nav-item active">
	                        <a class="nav-link" href="#">Well come: ${sessionScope.currentUser.username}</a>
	                    </li>
               		</c:if>
                    <li class="nav-item active">
                        <a class="nav-link" href="#">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">About</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Services</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Contact</a>
                    </li>
                    <c:choose>
                    	<c:when test="${empty sessionScope.currentUser}">
	                     <li class="nav-item">
	                        <a class="nav-link" href="<c:url value='/login'/>">Log In</a>
	                    </li>
                   	 	</c:when>
	                   	 <c:otherwise>
		                    <li class="nav-item">
		                        <div class="dropdown show">
								  <a class="nav-link dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
								    Account
								  </a>
								  <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
								    <a class="dropdown-item" href="<c:url value='/login/change-pass'/>">Change Password</a>
								    <a class="dropdown-item" href="#">Change Information</a>
								    <a class="dropdown-item" href="<c:url value='/history'/>">History</a>
								    <a class="dropdown-item" href="<c:url value='/favorites'/>">Favorite</a>
								    <a class="dropdown-item" href="<c:url value='/logout'/>">Log Out</a>
								  </div>
								</div>
		                    </li>
	                    </c:otherwise>
                    </c:choose>
                </ul>
            </div>
        </div>
    </nav>
