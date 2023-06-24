<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@include file="/common/taglib.jsp" %>
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

				<form action="j_spring_security_check" method="post"
					class="login100-form" id="formLogin">
					<div class="wrap-input100 validate-input m-b-26">
						<span class="label-input100">Username</span> <input
							class="input100" type="text" id="username" name="j_username"
							placeholder="Enter username"> <span
							class="focus-input100"></span> <span class="form-message"></span>
					</div>

					<div class="wrap-input100 validate-input m-b-18">
						<span class="label-input100">Password</span> <input
							class="input100" type="password" id="pass" name="j_password"
							placeholder="Enter password"> <span
							class="focus-input100"></span> <span class="form-message"></span>
					</div>

					<div class="flex-sb-m w-full p-b-30">
						<div class="contact100-form-checkbox">
							<input class="input-checkbox100" id="ckb1" type="checkbox"
								name="remember-me"> <label class="label-checkbox100"
								for="ckb1"> Remember me </label>
						</div>
						<div>
							<a href="<c:url value='/login/register'/>" class="txt1"> Register? </a>
						</div>
						<div>
							<a href="<c:url value='/login/forgot'/>" class="txt1"> Forgot Password? </a>
						</div>
					</div>

					<div class="container-login100-form-btn">
						<button type="submit" class="login100-form-btn">Login</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<script>
        document.addEventListener('DOMContentLoaded', function () {
          Validator({
            form: '#formLogin',
            formGroupSelector: '.wrap-input100',
            errorSelector: '.form-message',
            rules: [
			Validator.isRequired('#username', 'Vui lòng nhập username'),
              Validator.minLength('#pass', 6, 'Vui lòng nhập password'),
            ]
          });
        });
      </script>

</body>
</html>