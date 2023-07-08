<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url var='sendMail' value="/send-mail" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container-fluid tm-container-content tm-mt-60">
		<div class="row mb-4">
			<h2 class="col-12 tm-text-primary">${video.title }</h2>
		</div>
		<div class="row tm-mb-90">
			<div class="col-xl-8 col-lg-7 col-md-6 col-sm-12">
				<iframe style="height: 589px" id="tm-video"
					src="https://www.youtube.com/embed/${video.href }"
					title="YouTube video player" frameborder="0"
					allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
					allowfullscreen></iframe>
			</div>
			<div class="col-xl-4 col-lg-5 col-md-6 col-sm-12">
				<div class="tm-bg-gray tm-video-details">
					<p class="mb-4">${video.description }</p>
					<c:if test="${not empty sessionScope.currentUser}">
						<div class="text-center mb-5">
							<button class="btn btn-primary tm-btn-big" id="likeOrUnLikeBtn">
								<c:choose>
									<c:when test="${flagLikeBtn==true }">UnLike</c:when>
									<c:otherwise>
	                        			Like
	                        		</c:otherwise>
								</c:choose>
							</button>
						</div>
						<div class="text-center mb-5">
							<a href="#" data-toggle="modal" data-target="#exampleModal"
								class="btn btn-primary tm-btn-big">Share</a>
						</div>
					</c:if>
					<div class="mb-4 d-flex flex-wrap">
						<div class="mr-4 mb-2">
							<span class="tm-text-gray-dark">Resolution: </span><span
								class="tm-text-primary">1920x1080</span>
						</div>
						<div class="mr-4 mb-2">
							<span class="tm-text-gray-dark">Format: </span><span
								class="tm-text-primary">MP4</span>
						</div>
						<div>
							<span class="tm-text-gray-dark">Duration: </span><span
								class="tm-text-primary">00:00:20</span>
						</div>
					</div>
					<div class="mb-4">
						<h3 class="tm-text-gray-dark mb-3">License</h3>
						<p>Free for both personal and commercial use. No need to pay
							anything. No need to make any attribution.</p>
					</div>
				</div>
			</div>
		</div>
		<div class="row mb-4">
			<h2 class="col-12 tm-text-primary">Related Videos</h2>
		</div>
		<div class="row mb-3 tm-gallery">
			<div class="col-xl-3 col-lg-4 col-md-6 col-sm-6 col-12 mb-5">
				<figure class="effect-ming tm-video-item">
					<img src="<c:url value='/templates/web/img/img-01.jpg'/>"
						alt="Image" class="img-fluid">
					<figcaption
						class="d-flex align-items-center justify-content-center">
						<h2>Hangers</h2>
						<a href="#">View more</a>
					</figcaption>
				</figure>
				<div class="d-flex justify-content-between tm-text-gray">
					<span class="tm-text-gray-light">12 Oct 2020</span> <span>12,460
						views</span>
				</div>
			</div>
			<input type="hidden" value="${video.href}" id="videoIdHdn" />
		</div>
		<!-- row -->
	</div>
	<!-- container-fluid, tm-container-content -->
	<!-- Modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Share video
						with email</h5>
				</div>
				<div class="modal-body">
			<input type="hidden" id="hrefVideo" value="${video.href}"/>
					<div class="form-group">
						<label>Subject</label> <input id="subject" name="subject"
							class="form-control" />
					</div>
					<div class="form-group">
						<label>To</label> <input id="to" name="to" class="form-control" />
					</div>
					<div class="form-group">
						<label>Content</label> <input id="content" name="content"
							class="form-control" />
					</div>
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					<button id="sendMail" type="button" class="btn btn-primary">Send</button>

				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$('#likeOrUnLikeBtn').click(
				function() {
					var videoId = $('#videoIdHdn').val();
					$.ajax({
						url : 'video?action=like&id=' + videoId,
						type : 'GET'
					}).done(
							function(data) {
								var text = $('#likeOrUnLikeBtn').text();
								text == 'Like' ? $('#likeOrUnLikeBtn').text(
										'UnLike') : $('#likeOrUnLikeBtn').text(
										'Like');
							}).fail(function(error) {
						alert('Oop!!');
					})
				});
		
		$('#sendMail').click(
				function() {
					const to = $('#to').val()
					const subject = $('#subject').val()
					const href = $('#hrefVideo').val()
					
					const data = {
						to,subject,href
					}
					$.ajax({
						url: '${sendMail}',
						type: 'POST',
						data: data,
						success: function (result) {
							const Toast = Swal.mixin({
								  toast: true,
								  position: 'top-end',
								  showConfirmButton: false,
								  timer: 3000,
								  timerProgressBar: true,
								  didOpen: (toast) => {
								    toast.addEventListener('mouseenter', Swal.stopTimer)
								    toast.addEventListener('mouseleave', Swal.resumeTimer)
								  }
								})
								Toast.fire({
								  icon: 'success',
								  title: 'Send mail successfully'
								})
			            },
			            error: function (error) {
			            	const Toast = Swal.mixin({
								  toast: true,
								  position: 'top-end',
								  showConfirmButton: false,
								  timer: 3000,
								  timerProgressBar: true,
								  didOpen: (toast) => {
								    toast.addEventListener('mouseenter', Swal.stopTimer)
								    toast.addEventListener('mouseleave', Swal.resumeTimer)
								  }
								})
								Toast.fire({
								  icon: 'error',
								  title: 'Send mail error'
								})
			            }
					})
				});
	</script>
</body>
</html>