<%@page import="java.security.Principal"%>
<%@page import="com.assign.util.SecurityUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="userAPI" value='/api/user' />
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- SEO Meta Tags -->
<meta name="description" content="Your description">
<meta name="author" content="Your name">

<!-- OG Meta Tags to improve the way the post looks when you share the page on Facebook, Twitter, LinkedIn -->
<meta property="og:site_name" content="" />
<!-- website name -->
<meta property="og:site" content="" />
<!-- website link -->
<meta property="og:title" content="" />
<!-- title shown in the actual shared post -->
<meta property="og:description" content="" />
<!-- description shown in the actual shared post -->
<meta property="og:image" content="" />
<!-- image link, make sure it's jpg -->
<meta property="og:url" content="" />
<!-- where do you want your post to link to -->
<meta name="twitter:card" content="summary_large_image">
<!-- to have large image post format in Twitter -->

<!-- Webpage Title -->
<title>Mirko - Broadband Company</title>

<!-- Styles -->
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;700&display=swap"
	rel="stylesheet">
<link href="<c:url value='/templates/web/css/bootstrap.min.css'/>"
	rel="stylesheet">
<link href="<c:url value='/templates/web/css/fontawesome-all.min.css'/>"
	rel="stylesheet">
<link href="<c:url value='/templates/web/css/aos.min.css'/>"
	rel="stylesheet">
<link href="<c:url value='/templates/web/css/swiper.css'/>"
	rel="stylesheet">
<link href="<c:url value='/templates/web/css/style.css'/>"
	rel="stylesheet">
<link rel="stylesheet"
	href="<c:url value='/templates/web/assets/css/style.css'/>">

<script src="<c:url value='/templates/web/assets/js/angular.min.js'/>"></script>
<script
	src="<c:url value='/templates/web/assets/js/angular-route.min.js'/>"></script>
<script src="<c:url value='/templates/web/assets/js/app.js'/>"></script>
<script
	src="<c:url value='/templates/web/login/vendor/jquery/jquery-3.2.1.min.js'/>"></script>

<!-- Favicon -->
<link rel="icon"
	href="<c:url value='/templates/web/assets/images/favicon.png'/>">
</head>
<body ng-app="myApp">

	<!-- Navigation -->
	<nav id="navbar" class="navbar navbar-expand-lg fixed-top navbar-dark"
		aria-label="Main navigation">
		<div class="container">
			<a class="navbar-brand logo-text" href="<c:url value='/trang-chu'/>">Hoàng
				Duy Nam</a>

			<button class="navbar-toggler p-0 border-0" type="button"
				id="navbarSideCollapse" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="navbar-collapse offcanvas-collapse"
				id="navbarsExampleDefault">
				<ul class="navbar-nav ms-auto navbar-nav-scroll">
					<security:authorize access="isAuthenticated()">
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="#">Hello: <%=SecurityUtils.getPrincipal().getFullname()%></a>
						</li>
					</security:authorize>

					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="<c:url value='/trang-chu'/>">Home</a></li>
					<security:authorize access="isAuthenticated()">
						<li class="nav-item"><a class="nav-link"
							href="#!subjects#services">Course</a></li>
					</security:authorize>
					<li class="nav-item"><a class="nav-link" href="#about">About</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="#plans">Plans</a>
					</li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" id="dropdown01"
						data-bs-toggle="dropdown" aria-expanded="false" href="#">Drop</a>

						<ul class="dropdown-menu" aria-labelledby="dropdown01">
							<li><a class="dropdown-item"
								href="<c:url value='/templates/web/article.html'/>">Article
									Details</a></li>
							<li><div class="dropdown-divider"></div></li>
							<li><a class="dropdown-item"
								href="<c:url value='/templates/web/terms.html'/>">Terms
									Conditions</a></li>
							<li><div class="dropdown-divider"></div></li>
							<li><a class="dropdown-item"
								href="<c:url value='/templates/web/privacy.html'/>">Privacy
									Policy</a></li>
						</ul></li>
					<security:authorize access="isAnonymous()">
						<li class="nav-item"><a class="dropdown-item"
							href="<c:url value='/login'/>">Login</a></li>
					</security:authorize>
					<li class="nav-item"><a class="nav-link" href="#contact">Contact</a>
					</li>
					<security:authorize access="isAuthenticated()">
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" id="dropdown01"
							data-bs-toggle="dropdown" aria-expanded="false" href="#">Account</a>
							<ul class="dropdown-menu" aria-labelledby="dropdown01">
								<li><a class="dropdown-item" data-bs-toggle="modal"
									data-bs-target="#exampleModal1">Change Password</a></li>
								<li><div class="dropdown-divider"></div></li>
								<li><a class="dropdown-item" data-bs-toggle="modal"
									data-bs-target="#exampleModal">Change Infomation</a></li>
								<li><div class="dropdown-divider"></div></li>
								<li><a class="dropdown-item"
									href="<c:url value='/templates/web/privacy.html'/>">History
										Quiz</a></li>
								<li><a class="dropdown-item"
									href="<c:url value='/logoff'/>">Log Out</a></li>
							</ul></li>
					</security:authorize>
				</ul>
				<span class="nav-item social-icons"> <span class="fa-stack">
						<a href="#your-link"> <i class="fas fa-circle fa-stack-2x"></i>
							<i class="fab fa-facebook-f fa-stack-1x"></i>
					</a>
				</span> <span class="fa-stack"> <a href="#your-link"> <i
							class="fas fa-circle fa-stack-2x"></i> <i
							class="fab fa-twitter fa-stack-1x"></i>
					</a>
				</span>
				</span>
			</div>
			<!-- end of navbar-collapse -->
		</div>
		<!-- end of container -->
	</nav>
	<!-- end of navbar -->
	<!-- end of navigation -->

	<!-- Home -->
	<section class="home py-5 d-flex align-items-center" id="header">
		<div class="container text-light py-5" data-aos="fade-right">
			<h1 class="headline">
				Best <span class="home_text">Online Quiz</span><br>Try On Me
			</h1>
			<p class="para para-light py-3">Khi bạn khao khát một điều gì đó
				cả vũ trụ sẽ hợp lực giúp bạn đạt được điều đó! -Nhà giả kim-</p>
			<div class="d-flex align-items-center">
				<p class="p-2">
					<i class="fas fa-laptop-house fa-lg"></i>
				</p>
				<p>Luôn luôn lắng nghe.</p>
			</div>
			<div class="d-flex align-items-center">
				<p class="p-2">
					<i class="fas fa-wifi fa-lg"></i>
				</p>
				<p>Mọi lúc mọi nơi khi bạn cần chúng tôi.</p>
			</div>
			<div class="my-3">
				<a class="btn" href="#plans">View Plans</a>
			</div>
		</div>
		<!-- end of container -->
	</section>
	<!-- end of home -->

	<!-- Modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Change
						Information</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form id="formChange">
						<div class="form-group">
							<label class="">Full Name</label> <input type="text"
								id="fullname" name="fullname" class="form-control" /> <span
								class="form-message"></span>
						</div>
						<div class="form-group">
							<label class="">Email</label> <input type="email" id="email"
								name="email" class="form-control" /> <span class="form-message"></span>
						</div>
						<div class="form-group">
							<label class="">BirthDay</label> <input type="date" id="birthDay"
								name="birthDay" class="form-control" /> <span
								class="form-message"></span>
						</div>
						<div class="form-group">
							<security:authorize access="isAuthenticated()">
								<input type="hidden" id="newId"
									value="<%=SecurityUtils.getPrincipal().getId()%>" name="id"
									class="form-control" />
							</security:authorize>
						</div>
						<div class="form-group">
						<label>Gender</label>
							<select id="gender" name="gender" class="form-control">
								<option value="" disabled="disabled" selected="selected">Gender</option>
								<option value="male">Male</option>
								<option value="female">Female</option>
								<option value="other">Other</option>
							</select> <span class="form-message"></span>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-primary-gradient"
								data-bs-dismiss="modal">Close</button>
							<button type="submit" class="btn btn-primary-gradient">Save
								changes</button>
						</div>
					</form>
				</div>

			</div>
		</div>
	</div>
	<!-- End modal  -->

	<!-- Modal -->
	<div class="modal fade" id="exampleModal1" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Change Password
						</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form id="formChangeP">
						<div class="form-group">
							<label>Password old</label> <input type="password"
								id="passwordOld" name="passwordOld" class="form-control" /> <span
								class="form-message"></span>
						</div>
						<div class="form-group">
							<label>Password New</label> <input type="password" id="password"
								name="password" class="form-control" /> <span
								class="form-message"></span>
						</div>
						<div class="form-group">
							<label>Password Confirm</label> <input type="password"
								id="passwordC" name="passwordC" class="form-control" /> <span
								class="form-message"></span>
						</div>
						<div class="form-group">
							<security:authorize access="isAuthenticated()">
								<input type="hidden" id="newId"
									value="<%=SecurityUtils.getPrincipal().getId()%>" name="id"
									class="form-control" />
							</security:authorize>
						</div>

						<div class="modal-footer">
							<button type="button" class="btn btn-primary-gradient"
								data-bs-dismiss="modal">Close</button>
							<button type="submit" class="btn btn-primary-gradient">Save
								changes</button>
						</div>
					</form>
				</div>

			</div>
		</div>
	</div>
	<!-- End modal  -->

	<!-- Information -->
	<section class="information">
		<div class="container-fluid">
			<div class="row text-light">
				<div class="col-lg-4 text-center p-5" data-aos="zoom-in">
					<i class="fas fa-tachometer-alt fa-3x p-2"></i>
					<h4 class="py-3">Download 1 GBPS</h4>
					<p class="para-light">Lorem ipsum dolor sit amet, consectetur
						adipisicing elit. Magnam odit consequatur doloribus natus in
						suscipit!</p>
				</div>
				<div class="col-lg-4 text-center p-5" data-aos="zoom-in">
					<i class="fas fa-clock fa-3x p-2"></i>
					<h4 class="py-3">99% Internet Uptime</h4>
					<p class="para-light">Lorem ipsum dolor sit amet, consectetur
						adipisicing elit. Magnam odit consequatur doloribus natus in
						suscipit!</p>
				</div>
				<div class="col-lg-4 text-center p-5 text-dark" data-aos="zoom-in">
					<i class="fas fa-headset fa-3x p-2"></i>
					<h4 class="py-3">24/7 Support</h4>
					<p class="para-light">Lorem ipsum dolor sit amet, consectetur
						adipisicing elit. Magnam odit consequatur doloribus natus in
						suscipit!</p>
				</div>
			</div>
		</div>
		<!-- end of container -->
	</section>
	<!-- end of information -->


	<!-- About -->
	<section class="about d-flex align-items-center text-light py-5"
		id="about">
		<div class="container">
			<div class="row d-flex align-items-center">
				<div class="col-lg-7" data-aos="fade-right">
					<p>ABOUT US</p>
					<h1>
						We are top internet <br> service company
					</h1>
					<p class="py-2 para-light">Lorem ipsum dolor sit amet
						consectetur adipisicing elit. Non sed accusantium aut dolores
						inventore architecto modi cupiditate eligendi corporis, illum illo
						culpa. Reiciendis, molestias. Illum voluptatum quisquam ad
						veritatis dolorem.</p>
					<p class="py-2 para-light">Lorem ipsum dolor sit amet
						consectetur adipisicing elit. Non sed accusantium aut dolores
						inventore architecto modi cupiditate eligendi corporis, illum illo
						culpa. Reiciendis, molestias. Illum voluptatum quisquam ad
						veritatis dolorem.</p>

					<div class="my-3">
						<a class="btn" href="#your-link">Learn More</a>
					</div>
				</div>
				<div class="col-lg-5 text-center py-4 py-sm-0" data-aos="fade-down">
					<img class="img-fluid"
						src="<c:url value='/templates/web/assets/images/about.jpg'/>"
						alt="about">
				</div>
			</div>
			<!-- end of row -->
		</div>
		<!-- end of container -->
	</section>
	<!-- end of about -->


	<!-- Services -->
	<section class="d-flex align-items-center py-5" id="services">
		<div class="container">
			<div class="text-center pb-4">
				<p>OUR COURSE</p>
				<h2 class="py-2">Explore unlimited possibilities</h2>
				<!-- <p class="para-light">Lorem ipsum dolor sit amet consectetur adipisicing elit. Vitae asperiores, quia accusantium sunt corporis optio recusandae? Nostrum libero pariatur cumque, ipsa dolores voluptatibus voluptate alias sit fuga. Itaque, ea quo.</p> -->
			</div>
			<div ng-view></div>
		</div>
		<!-- end of container -->
	</section>
	<!-- end of services -->


	<!-- Plans -->
	<section class="plans d-flex align-items-center py-5" id="plans">
		<div class="container text-light">
			<div class="text-center pb-4">
				<p>OUR PLANS</p>
				<h2 class="py-2">Explore unlimited possibilities</h2>
				<p class="para-light">Lorem ipsum dolor sit amet consectetur
					adipisicing elit. Vitae asperiores, quia accusantium sunt corporis
					optio recusandae? Nostrum libero pariatur cumque, ipsa dolores
					voluptatibus voluptate alias sit fuga. Itaque, ea quo.</p>
			</div>
			<div class="row gy-4" data-aos="zoom-in">
				<div class="col-lg-4">
					<div class="card bg-transparent px-4">
						<h4 class="py-2">BASIC BUNDLE</h4>
						<p class="py-3">Lorem ipsum dolor sit amet consectetur
							adipisicing elit.</p>
						<div class="block d-flex align-items-center">
							<p class="pe-2">
								<i class="far fa-check-circle fa-1x"></i>
							</p>
							<p>Lorem ipsum dolor sit amet.</p>
						</div>
						<div class="block d-flex align-items-center">
							<p class="pe-2">
								<i class="far fa-check-circle fa-1x"></i>
							</p>
							<p>Lorem ipsum dolor sit amet.</p>
						</div>
						<div class="block d-flex align-items-center">
							<p class="pe-2">
								<i class="far fa-check-circle fa-1x"></i>
							</p>
							<p>Lorem ipsum dolor sit amet.</p>
						</div>
						<div class="block d-flex align-items-center">
							<p class="pe-2">
								<i class="far fa-check-circle fa-1x"></i>
							</p>
							<p>Lorem ipsum dolor sit amet.</p>
						</div>
						<h4 class="py-3">$24/Month</h4>
						<div class="my-3">
							<a class="btn" href="#your-link">View Plans</a>
						</div>
					</div>
				</div>

				<div class="col-lg-4">
					<div class="card bg-transparent px-4">
						<h4 class="py-2">BUSINESS BUNDLE</h4>
						<p class="py-3">Lorem ipsum dolor sit amet consectetur
							adipisicing elit.</p>
						<div class="block d-flex align-items-center">
							<p class="pe-2">
								<i class="far fa-check-circle fa-1x"></i>
							</p>
							<p>Lorem ipsum dolor sit amet.</p>
						</div>
						<div class="block d-flex align-items-center">
							<p class="pe-2">
								<i class="far fa-check-circle fa-1x"></i>
							</p>
							<p>Lorem ipsum dolor sit amet.</p>
						</div>
						<div class="block d-flex align-items-center">
							<p class="pe-2">
								<i class="far fa-check-circle fa-1x"></i>
							</p>
							<p>Lorem ipsum dolor sit amet.</p>
						</div>
						<div class="block d-flex align-items-center">
							<p class="pe-2">
								<i class="far fa-check-circle fa-1x"></i>
							</p>
							<p>Lorem ipsum dolor sit amet.</p>
						</div>
						<h4 class="py-3">$99/Month</h4>
						<div class="my-3">
							<a class="btn" href="#your-link">View Plans</a>
						</div>
					</div>
				</div>

				<div class="col-lg-4">
					<div class="card bg-transparent px-4">
						<h4 class="py-2">PREMIUM BUNDLE</h4>
						<p class="py-3">Lorem ipsum dolor sit amet consectetur
							adipisicing elit.</p>
						<div class="block d-flex align-items-center">
							<p class="pe-2">
								<i class="far fa-check-circle fa-1x"></i>
							</p>
							<p>Lorem ipsum dolor sit amet.</p>
						</div>
						<div class="block d-flex align-items-center">
							<p class="pe-2">
								<i class="far fa-check-circle fa-1x"></i>
							</p>
							<p>Lorem ipsum dolor sit amet.</p>
						</div>
						<div class="block d-flex align-items-center">
							<p class="pe-2">
								<i class="far fa-check-circle fa-1x"></i>
							</p>
							<p>Lorem ipsum dolor sit amet.</p>
						</div>
						<div class="block d-flex align-items-center">
							<p class="pe-2">
								<i class="far fa-check-circle fa-1x"></i>
							</p>
							<p>Lorem ipsum dolor sit amet.</p>
						</div>
						<h4 class="py-3">$199/Month</h4>
						<div class="my-3">
							<a class="btn" href="#your-link">View Plans</a>
						</div>
					</div>
				</div>
			</div>
			<!-- end of row -->
		</div>
		<!-- end of container -->
	</section>
	<!-- end of plans -->


	<!-- Work -->
	<section class="work d-flex align-items-center py-5">
		<div class="container-fluid text-light">
			<div class="row">
				<div class="col-lg-6 d-flex align-items-center"
					data-aos="fade-right">
					<img class="img-fluid"
						src="<c:url value='/templates/web/assets/images/work.jpg'/>"
						alt="work">
				</div>
				<div class="col-lg-5 d-flex align-items-center px-4 py-3"
					data-aos="">
					<div class="row">
						<div class="text-center text-lg-start py-4 pt-lg-0">
							<p>OUR WORK</p>
							<h2 class="py-2">Explore unlimited possibilities</h2>
							<p class="para-light">Lorem ipsum dolor sit amet consectetur,
								adipisicing elit. Dignissimos dicta mollitia totam explicabo
								obcaecati quia laudantium repudiandae.</p>
						</div>
						<div class="container" data-aos="fade-up">
							<div class="row g-5">
								<div class="col-6 text-start">
									<i class="fas fa-briefcase fa-2x text-start"></i>
									<h2 class="purecounter" data-purecounter-start="0"
										data-purecounter-end="1258" data-purecounter-duration="3">1</h2>
									<p>PROJECTS COMPLETED</p>
								</div>
								<div class="col-6">
									<i class="fas fa-award fa-2x"></i>
									<h2 class="purecounter" data-purecounter-start="0"
										data-purecounter-end="150" data-purecounter-duration="3">1</h2>
									<p>AWARDS</p>
								</div>
								<div class="col-6">
									<i class="fas fa-users fa-2x"></i>
									<h2 class="purecounter" data-purecounter-start="0"
										data-purecounter-end="1255" data-purecounter-duration="3">1</h2>
									<p>CUSTOMER ACTIVE</p>
								</div>
								<div class="col-6">
									<i class="fas fa-clock fa-2x"></i>
									<h2 class="purecounter" data-purecounter-start="0"
										data-purecounter-end="1157" data-purecounter-duration="3">1</h2>
									<p>GOOD REVIEWS</p>
								</div>
							</div>
						</div>
						<!-- end of container -->
					</div>
					<!-- end of row -->
				</div>
				<!-- end of col-lg-5 -->
			</div>
			<!-- end of row -->
		</div>
		<!-- end of container -->
	</section>
	<!-- end of work -->


	<!-- Testimonials -->
	<div class="slider-1 testimonial text-light d-flex align-items-center">
		<div class="container">
			<div class="row">
				<div class="text-center w-lg-75 m-auto pb-4">
					<p>TESTIMONIALS</p>
					<h2 class="py-2">What Our Clients Says</h2>
					<p class="para-light">Lorem ipsum dolor sit, amet consectetur
						adipisicing elit. Adipisci esse facilis vel, neque ipsa mollitia
						impedit, commodi ab illo dignissimos, voluptatum quae amet sed
						tenetur dolores reprehenderit laudantium quo sint.</p>
				</div>
			</div>
			<!-- end of row -->
			<div class="row p-2" data-aos="zoom-in">
				<div class="col-lg-12">

					<!-- Card Slider -->
					<div class="slider-container">
						<div class="swiper-container card-slider">
							<div class="swiper-wrapper">

								<!-- Slide -->
								<div class="swiper-slide">
									<div class="testimonial-card p-4">
										<p>Lorem ipsum dolor, sit amet consectetur adipisicing
											elit. Laboriosam commodi officia laborum qui iste quidem!</p>

										<div class="d-flex pt-4">
											<div>
												<img class="avatar"
													src="<c:url value='/templates/web/assets/images/testimonial-1.jpg'/>"
													alt="testimonial">
											</div>
											<div class="ms-3 pt-2">
												<h6>Marlene Visconte</h6>
												<p>General Manager - Scouter</p>
											</div>
										</div>
									</div>
								</div>
								<!-- end of swiper-slide -->
								<!-- end of slide -->

								<!-- Slide -->
								<div class="swiper-slide">
									<div class="testimonial-card p-4">
										<p>Lorem ipsum dolor, sit amet consectetur adipisicing
											elit. Laboriosam commodi officia laborum qui iste quidem!</p>
										<div class="d-flex pt-4">
											<div>
												<img class="avatar"
													src="<c:url value='/templates/web/assets/images/testimonial-2.jpg'/>"
													alt="testimonial">
											</div>
											<div class="ms-3 pt-2">
												<h6>John Spiker</h6>
												<p>Team Leader - Vanquish</p>
											</div>
										</div>
									</div>
								</div>
								<!-- end of swiper-slide -->
								<!-- end of slide -->

								<!-- Slide -->
								<div class="swiper-slide">
									<div class="testimonial-card p-4">
										<p>Lorem ipsum dolor, sit amet consectetur adipisicing
											elit. Laboriosam commodi officia laborum qui iste quidem!</p>
										<div class="d-flex pt-4">
											<div>
												<img class="avatar"
													src="<c:url value='/templates/web/assets/images/testimonial-3.jpg'/>"
													alt="testimonial">
											</div>
											<div class="ms-3 pt-2">
												<h6>Stella Virtuoso</h6>
												<p>Design Chief - Upscale</p>
											</div>
										</div>
									</div>
								</div>
								<!-- end of swiper-slide -->
								<!-- end of slide -->

								<!-- Slide -->
								<div class="swiper-slide">
									<div class="testimonial-card p-4">
										<p>Lorem ipsum dolor, sit amet consectetur adipisicing
											elit. Laboriosam commodi officia laborum qui iste quidem!</p>
										<div class="d-flex pt-4">
											<div>
												<img class="avatar"
													src="<c:url value='/templates/web/assets/images/testimonial-4.jpg" alt="testimonial'/>">
											</div>
											<div class="ms-3 pt-2">
												<p>Mike tim</p>
												<p>Investor - TechGroww</p>
											</div>
										</div>
									</div>
								</div>
								<!-- end of swiper-slide -->
								<!-- end of slide -->

							</div>
							<!-- end of swiper-wrapper -->

							<!-- Add Arrows -->
							<div class="swiper-button-next"></div>
							<div class="swiper-button-prev"></div>
							<!-- end of add arrows -->

						</div>
						<!-- end of swiper-container -->
					</div>
					<!-- end of slider-container -->
					<!-- end of card slider -->

				</div>
				<!-- end of col -->
			</div>
			<!-- end of row -->
		</div>
		<!-- end of container -->
	</div>
	<!-- end of testimonials -->


	<!-- Newsletter -->
	<section class="newsletter text-light py-5">
		<div class="container">
			<div class="row">
				<div class="col-lg-6 text-center text-lg-start"
					data-aos="fade-right">
					<h4 class="py-1">Subscribe to our Newsletter</h4>
					<p class="para-light">Lorem ipsum, dolor sit amet consectetur
						adipisicing elit. Dolor deleniti nobis amet accusamus debitis
						facilis quibusdam officia laborum nesciunt. Nihil.</p>
				</div>
				<div class="col-lg-6 d-flex align-items-center" data-aos="fade-down">
					<div class="input-group my-3">
						<input type="text" class="form-control p-2"
							placeholder="Enter your email address"
							aria-label="Recipient's email">
						<button class="btn-secondary text-light" type="button">Subscribe</button>
					</div>
				</div>
			</div>
			<!-- end of row -->
		</div>
		<!-- end of container -->
	</section>
	<!-- end of newsletter -->


	<!-- Contact -->
	<section class="contact d-flex align-items-center py-5" id="contact">
		<div class="container-fluid text-light">
			<div class="row">
				<div
					class="col-lg-6 d-flex justify-content-center justify-content-lg-end align-items-center px-lg-5"
					data-aos="fade-right">
					<div style="width: 90%">
						<div class="text-center text-lg-start py-4 pt-lg-0">
							<p>CONTACT</p>
							<h2 class="py-2">Send your query</h2>
							<p class="para-light">Lorem ipsum dolor sit amet consectetur,
								adipisicing elit. Dignissimos dicta mollitia totam explicabo
								obcaecati quia laudantium repudiandae.</p>
						</div>
						<div>
							<div class="row">
								<div class="col-lg-6">
									<div class="form-group py-2">
										<input type="text" class="form-control form-control-input"
											id="exampleFormControlInput1" placeholder="Enter name">
									</div>
								</div>
								<div class="col-lg-6">
									<div class="form-group py-2">
										<input type="email" class="form-control form-control-input"
											id="exampleFormControlInput2"
											placeholder="Enter phone number">
									</div>
								</div>
							</div>
							<div class="form-group py-1">
								<input type="email" class="form-control form-control-input"
									id="exampleFormControlInput3" placeholder="Enter email">
							</div>
							<div class="form-group py-2">
								<textarea class="form-control form-control-input"
									id="exampleFormControlTextarea1" rows="6" placeholder="Message"></textarea>
							</div>
						</div>
						<div class="my-3">
							<a class="btn form-control-submit-button" href="#your-link">Submit</a>
						</div>
					</div>
					<!-- end of div -->
				</div>
				<!-- end of col -->
				<div class="col-lg-6 d-flex align-items-center" data-aos="fade-down">
					<img class="img-fluid d-none d-lg-block"
						src="<c:url value='/templates/web/assets/images/contact.jpg'/>"
						alt="contact">
				</div>
				<!-- end of col -->
			</div>
			<!-- end of row -->
		</div>
		<!-- end of container -->
	</section>
	<!-- end of contact -->


	<!-- Location -->
	<section class="location text-light py-5">
		<div class="container" data-aos="zoom-in">
			<div class="row">
				<div class="col-lg-3 d-flex align-items-center">
					<div class="p-2">
						<i class="far fa-map fa-3x"></i>
					</div>
					<div class="ms-2">
						<h6>ADDRESS</h6>
						<p>Teuku Umar ST. 1919</p>
					</div>
				</div>
				<div class="col-lg-3 d-flex align-items-center">
					<div class="p-2">
						<i class="fas fa-mobile-alt fa-3x"></i>
					</div>
					<div class="ms-2">
						<h6>CALL FOR QUERY</h6>
						<p>(800) 265 216 2020</p>
					</div>
				</div>
				<div class="col-lg-3 d-flex align-items-center">
					<div class="p-2">
						<i class="far fa-envelope fa-3x"></i>
					</div>
					<div class="ms-2">
						<h6>SEND US MESSAGE</h6>
						<p>infodemofile@example.com</p>
					</div>
				</div>
				<div class="col-lg-3 d-flex align-items-center">
					<div class="p-2">
						<i class="far fa-clock fa-3x"></i>
					</div>
					<div class="ms-2">
						<h6>OPENING HOURS</h6>
						<p>09:00 AM - 18:00 PM</p>
					</div>
				</div>
			</div>
			<!-- end of row -->
		</div>
		<!-- end of container -->
	</section>
	<!-- end of location -->


	<!-- Footer -->
	<section class="footer text-light">
		<div class="container">
			<div class="row" data-aos="fade-right">
				<div class="col-lg-3 py-4 py-md-5">
					<div class="d-flex align-items-center">
						<h4 class="">Mirko</h4>
					</div>
					<p class="py-3 para-light">Lorem ipsum dolor sit amet
						consectetur adipisicing elit. Minus animi repudiandae explicabo
						esse maxime, impedit rem voluptatibus amet error quas.</p>
					<div class="d-flex">
						<div class="me-3">
							<a href="#your-link"> <i class="fab fa-facebook-f fa-2x py-2"></i>
							</a>
						</div>
						<div class="me-3">
							<a href="#your-link"> <i class="fab fa-twitter fa-2x py-2"></i>
							</a>
						</div>
						<div class="me-3">
							<a href="#your-link"> <i class="fab fa-instagram fa-2x py-2"></i>
							</a>
						</div>
					</div>
				</div>
				<!-- end of col -->

				<div class="col-lg-3 py-4 py-md-5">
					<div>
						<h4 class="py-2">Quick Links</h4>
						<div class="d-flex align-items-center py-2">
							<i class="fas fa-caret-right"></i> <a href="#about"><p
									class="ms-3">About</p></a>
						</div>
						<div class="d-flex align-items-center py-2">
							<i class="fas fa-caret-right"></i> <a href="#"><p
									class="ms-3">Services</p></a>
						</div>
						<div class="d-flex align-items-center py-2">
							<i class="fas fa-caret-right"></i> <a href="#"><p
									class="ms-3">Plans</p></a>
						</div>
						<div class="d-flex align-items-center py-2">
							<i class="fas fa-caret-right"></i> <a href="#"><p
									class="ms-3">Contact</p></a>
						</div>
					</div>
				</div>
				<!-- end of col -->

				<div class="col-lg-3 py-4 py-md-5">
					<div>
						<h4 class="py-2">Useful Links</h4>
						<div class="d-flex align-items-center py-2">
							<i class="fas fa-caret-right"></i> <a href="privacy.html"><p
									class="ms-3">Privacy</p></a>

						</div>
						<div class="d-flex align-items-center py-2">
							<i class="fas fa-caret-right"></i> <a href="terms.html"><p
									class="ms-3">Terms</p></a>
						</div>
						<div class="d-flex align-items-center py-2">
							<i class="fas fa-caret-right"></i> <a href="#your-link"><p
									class="ms-3">Disclaimer</p></a>
						</div>
						<div class="d-flex align-items-center py-2">
							<i class="fas fa-caret-right"></i> <a href="#your-link"><p
									class="ms-3">FAQ</p></a>
						</div>
					</div>
				</div>
				<!-- end of col -->

				<div class="col-lg-3 py-4 py-md-5">
					<div class="d-flex align-items-center">
						<h4>Newsletter</h4>
					</div>
					<p class="py-3 para-light">Lorem ipsum dolor sit amet,
						consectetur adipisicing elit. Laboriosam, ab.</p>
					<div class="d-flex align-items-center">
						<div class="input-group mb-3">
							<input type="text" class="form-control p-2"
								placeholder="Enter Email" aria-label="Recipient's email">
							<button class="btn-secondary text-light">
								<i class="fas fa-envelope fa-lg"></i>
							</button>
						</div>
					</div>
				</div>
				<!-- end of col -->
			</div>
			<!-- end of row -->
		</div>
		<!-- end of container -->
	</section>
	<!-- end of footer -->


	<!-- Bottom -->
	<div class="bottom py-2 text-light">
		<div class="container d-flex justify-content-between">
			<div>
				<p>Copyright © Your name</p>
				<br>
				<p>
					Distributed by: <a href="https://themewagon.com/">Themewagon</a>
				</p>
			</div>
			<div>
				<i class="fab fa-cc-visa fa-lg p-1"></i> <i
					class="fab fa-cc-mastercard fa-lg p-1"></i> <i
					class="fab fa-cc-paypal fa-lg p-1"></i> <i
					class="fab fa-cc-amazon-pay fa-lg p-1"></i>
			</div>
		</div>
		<!-- end of container -->
	</div>
	<!-- end of bottom -->


	<!-- Back To Top Button -->
	<button onclick="topFunction()" id="myBtn">
		<img src="<c:url value='/templates/web/assets/images/up-arrow.png'/>"
			alt="alternative">
	</button>
	<!-- end of back to top button -->


	<!-- Scripts -->
	<script src="<c:url value='/templates/web/js/bootstrap.min.js'/>"></script>
	<!-- Bootstrap framework -->
	<script src="<c:url value='/templates/web/js/purecounter.min.js'/>"></script>
	<!-- Purecounter counter for statistics numbers -->
	<script src="<c:url value='/templates/web/js/swiper.min.js'/>"></script>
	<!-- Swiper for image and text sliders -->
	<script src="<c:url value='/templates/web/js/aos.js'/>"></script>
	<!-- AOS on Animation Scroll -->
	<script src="<c:url value='/templates/web/js/script.js'/>"></script>
	<!-- Custom scripts -->
	<script src="<c:url value='/templates/web/js/validation.js'/>"></script>
	<script>

		document.addEventListener('DOMContentLoaded', function () {

			Validator({
				form: '#formChange',
				formGroupSelector: '.form-group',
				errorSelector: '.form-message',
				rules: [
					Validator.isRequired('#fullname', 'Vui lòng nhập fullname'),
					Validator.isRequired('#email', 'Vui lòng nhập email'),
					Validator.isEmail('#email', 'Sai định dạng email'),
					Validator.isRequired('#gender', "Vui lòng chọn giới tính."),
					Validator.isRequired('#birthDay', "Vui lòng chọn ngày sinh.")
				],
				onSubmit: function (data) {
					// Call API
					console.log(data);
					$.ajax({
						url: '${userAPI}',
						type: 'PUT',
						contentType: 'application/json',
						data: JSON.stringify(data),
            			dataType: 'json',
						success: function(result){
							alert('Success')
						},
						error: function(error){
							alert('Faill')
						}
					})
				}
			});
			
			
			Validator({
				form: '#formChangeP',
				formGroupSelector: '.form-group',
				errorSelector: '.form-message',
				rules: [
					Validator.isRequired('#passwordOld', 'Vui lòng nhập password old'),
					Validator.isRequired('#password', 'Vui lòng nhập password new'),
					Validator.isRequired('#passwordC', "Vui lòng nhập password confirm."),
					Validator.minLength('#passwordOld', 6),
					Validator.minLength('#password', 6),
					Validator.minLength('#passwordC', 6)
				],
				onSubmit: function (data) {
					// Call API
					console.log(data);
					$.ajax({	
						url: '${userAPI}',
						type: 'PUT',
						contentType: 'application/json',
						data: JSON.stringify(data),
            			dataType: 'json',
						success: function(result){
							alert('Success')
						},
						error: function(error){
							alert('Faill')
						}
					})
				}
			});
			
		});

	</script>
</body>
</html>