<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
						Sign In
					</span>
				</div>

				<form class="login100-form validate-form" id="formSubmit">
					

					<div class="wrap-input100 validate-input m-b-18" data-validate = "Password is required">
						<span class="label-input100">Old Password</span>
						<input class="input100" id="oPassword" type="password" name="oPassword" placeholder="Enter password">
						<span class="focus-input100"></span>
					</div>
					
					<div class="wrap-input100 validate-input m-b-18" data-validate = "Password is required">
						<span class="label-input100">New Password</span>
						<input class="input100" id="nPassword" type="password" name="nPassword" placeholder="Enter password">
						<span class="focus-input100"></span>
					</div>
					
					
				<div class="wrap-input100 validate-input m-b-18" data-validate = "Password is required">
						<span class="label-input100">Confirm Password</span>
						<input class="input100" id="cPassword" type="password" name="cPassword" placeholder="Enter password">
						<span class="focus-input100"></span>
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
	    	$.ajax({
	    		url : 'http://localhost:8080/Java_Four_Assign/login/change-pass',
	    		type : 'POST',
	    		data : data
	    	}).then(function(data){
	    		window.location.href = 'http://localhost:8080/Java_Four_Assign/trang-chu';
	    	}).fail(function(error){
	    		alert('Oop!!! Fail?');
	    	})
		})
	</script>
</body>
</html>