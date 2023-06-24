<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var='forgotURL' value='/login/forgot' />
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
				<div class="login100-form-title"
					style="background-image: url(templates/web/login/images/bg-01.jpg);">
					<span class="login100-form-title-1"> Sign In </span>
				</div>

				<form class="login100-form" id="formForgot">
					<div class="wrap-input100 validate-input m-b-26">
						<span class="label-input100">Username</span> <input
							class="input100" type="text" id="username" name="username"
							placeholder="Enter username"> <span
							class="focus-input100"></span> <span class="form-message"></span>
					</div>

					<div class="wrap-input100 validate-input m-b-18">
						<span class="label-input100">Email</span> <input class="input100"
							type="email" id="email" name="email" placeholder="Enter email">
						<span class="focus-input100"></span> <span class="form-message"></span>
					</div>

					<div class="flex-sb-m w-full p-b-30">
						<div class="contact100-form-checkbox">
							<input class="input-checkbox100" id="ckb1" type="checkbox"
								name="remember-me"> <label class="label-checkbox100"
								for="ckb1"> Remember me </label>
						</div>
						<div>
							<a href="<c:url value='/login'/>" class="txt1"> Login? </a>
						</div>
						<div>
							<a href="<c:url value='/login/register'/>" class="txt1">
								Register? </a>
						</div>

					</div>

					<div class="container-login100-form-btn">
						<button type="submit" class="login100-form-btn">Forgot</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<script>

		document.addEventListener('DOMContentLoaded', function () {

			Validator({
				form: '#formForgot',
				formGroupSelector: '.wrap-input100',
				errorSelector: '.form-message',
				rules: [
					Validator.isRequired('#username', 'Vui lòng nhập username'),
					Validator.isRequired('#email', 'Vui lòng nhập email'),
					Validator.isEmail('#email', 'Sai định dạng email')
				],
				onSubmit: function (formData) {
					// Call API
					console.log(formData);
					$.ajax({
						url: '${forgotURL}',
						type: 'POST',
						data: formData,
						success: function(result){
							alert('Success')
							window.location.href = 'http://localhost:8080/assign-front-end/login/verify'
						},
						error: function(error){
							alert('Oop! Fail')
						}
					});
				}
			});
		});

	</script>

</body>

</html>