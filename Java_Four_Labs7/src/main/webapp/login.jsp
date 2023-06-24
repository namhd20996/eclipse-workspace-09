<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.7/dist/umd/popper.min.js"
	integrity="sha384-zYPOMqeu1DAVkHiLqWBUTcbYfZ8osu1Nd6Z89ify25QV9guujx43ITvfi12/QExE"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.min.js"
	integrity="sha384-Y4oOpwW3duJdCWv5ly8SCFYWqFDsfob/3GkgExXKV4idmbt98QcxXYs9UoXAB7BZ"
	crossorigin="anonymous"></script>
</head>
<body>
	<div class="">
		<section class="vh-100" style="background-color: #9A616D;">
			<div class="container py-5 h-100">
				<div
					class="row d-flex justify-content-center align-items-center h-100">
					<div class="col col-xl-10">
						<div class="card" style="border-radius: 1rem;">
							<div class="row g-0">
								<div class="col-md-6 col-lg-5 d-none d-md-block">
									<img
										src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/img1.webp"
										alt="login form" class="img-fluid"
										style="border-radius: 1rem 0 0 1rem;" />
								</div>
								<div class="col-md-6 col-lg-7 d-flex align-items-center">
									<div class="card-body p-4 p-lg-5 text-black">

										<form action="<c:url value='/login'/>" method="post">

											<div class="d-flex align-items-center mb-3 pb-1">
												<i class="fas fa-cubes fa-2x me-3" style="color: #ff6219;"></i>
												<span class="h1 fw-bold mb-0">Logo</span>
											</div>

											<h5 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">Sign
												into your account</h5>

											<div class="form-outline mb-4">
												<c:if test="${message != null}">
													<div class="alert alert-danger">
														<strong>Success!</strong> Đăng nhập thất bại
													</div>
												</c:if>
											</div>
											<div class="form-outline mb-4">
												<input type="text" id="form2Example17"
													class="form-control form-control-lg" name="id" /> <label
													class="form-label" for="form2Example17">Username </label>
											</div>

											<div class="form-outline mb-4">
												<input type="password" id="form2Example27"
													class="form-control form-control-lg" name="password" /> <label
													class="form-label" for="form2Example27">Password</label>
											</div>

											<div class="pt-1 mb-4">
												<button class="btn btn-dark btn-lg btn-block" type="submit">Login</button>
											</div>

											<a class="small text-muted" href="#!">Forgot password?</a>
											<p class="mb-5 pb-lg-2" style="color: #393f81;">
												Don't have an account? <a href="#!" style="color: #393f81;">Register
													here</a>
											</p>
											<a href="#!" class="small text-muted">Terms of use.</a> <a
												href="#!" class="small text-muted">Privacy policy</a>
										</form>

									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
	</div>
</body>
</html>