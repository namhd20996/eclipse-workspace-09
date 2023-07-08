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
					<div class="wrap-input100 validate-input m-b-26" data-validate="Username is required">
						<span class="label-input100">Username</span>
						<input class="input100" type="text" id="username" name="username" placeholder="Enter username">
						<span class="focus-input100"></span>
					</div>

					<div class="wrap-input100 validate-input m-b-18" data-validate = "Password is required">
						<span class="label-input100">Email</span>
						<input class="input100" type="email" id="email" name="email" placeholder="Enter email">
						<span class="focus-input100"></span>
					</div>

					<div class="flex-sb-m w-full p-b-30">
						<div class="contact100-form-checkbox">
							<input class="input-checkbox100" id="ckb1" type="checkbox" name="remember-me">
							<label class="label-checkbox100" for="ckb1">
								Remember me
							</label>
						</div>

						<div>
							<a href="<c:url value='/login/register'/>" class="txt1">
								Register?
							</a>
						</div>
						
						<div>
							<a href="<c:url value='/login'/>" class="txt1">
								Log In?
							</a>
						</div>
					</div>

					<div class="container-login100-form-btn">
						<button id="btnForgot" type="button" class="login100-form-btn">
							Forgot
						</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<script>
		$('#btnForgot').click(function (e) {
			$('#messageReturn').text('');
	   		var username = $('#username').val();
	   		var email = $('#email').val();
	   		var formData = {'username': username, 'email': email};
	   		$.ajax({
	   			url : 'http://localhost:8080/Java_Four_Assign/login/forgot',
	   			type : 'POST',
	   			data: formData
	   		}).then(function(data){
	   			$('#messageReturn').text('Check email!!!');
	   			setTimeout(function(){
	   				window.location.href = 'http://localhost:8080/Java_Four_Assign/login/verify';
	   			}, 5*1000);
	   		}).fail(function(e){
	   			alert('Oop!..')
	   		})
		});
	</script>
</body>
</html>