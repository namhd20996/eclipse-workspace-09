<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url var="urlChange" value="/login/change-information"/>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Login V15</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<div class="login100-form-title" style="background-image: url(<c:url value='/templates/login/images/bg-01.jpg'/>);">
					<span class="login100-form-title-1">
						Change information
					</span>
				</div>
				<form class="login100-form validate-form" id="formSubmit">
					<div class="wrap-input100 validate-input m-b-26" data-validate="Full name is required">
						<span class="label-input100">Full name</span>
						<input class="input100" type="text" name="fullName" placeholder="Enter full name">
						<span class="focus-input100"></span>
					</div>
					
					<div class="wrap-input100 validate-input m-b-26" data-validate="Email is required">
						<span class="label-input100">Email</span>
						<input class="input100" type="email" name="email" placeholder="Enter email">
						<span class="focus-input100"></span>
					</div>
					
					<div class="">
					<span class="" style="margin-left: 100px">Gender</span>
						<input value="male" type="radio" name="gender"/>
						<input value="female" type="radio" name="gender"/>
					</div>
					<div class="flex-sb-m w-full p-b-30">
					<div class="contact100-form-checkbox">
							<input class="input-checkbox100" id="ckb1" type="checkbox" name="remember-me">
							<label class="label-checkbox100" for="ckb1">
								Accept Terms
							</label>
						</div>
						
						<div>
							<a href="<c:url value='/login'/>" class="txt1">
								Log In?
							</a>
						</div>
					
						<div>
							<a href="<c:url value='/login/forgot'/>" class="txt1">
								Forgot Password?
							</a>
						</div>
					</div>

					<div class="container-login100-form-btn">
						<button id="changeBtn" type="button" class="login100-form-btn">
							Change Password
						</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$('#changeBtn').click(function(e){
			e.preventDefault();
		    var data = {};
		    var formData = $('#formSubmit').serializeArray();
		    $.each(formData, function (i, v) {
	            data[""+v.name+""] = v.value;
	        });
		    console.log(data)
	    	$.ajax({
	    		url : '${urlChange}',
	    		type : 'POST',
	    		data : data
	    	}).then(function(data){
	    		alert('Oop!!! Success?');
	    	}).fail(function(error){
	    		alert('Oop!!! Fail?');
	    	}) 
		})
	</script>
</body>
</html>