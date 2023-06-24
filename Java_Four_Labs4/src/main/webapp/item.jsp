<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="col-lg-4 col-md-6 mb-4">
	<div class="card h-100">
		<a href="#"><img class="card-img-top"
			src="image/${param.image}" alt="" height=""></a>
		<div class="card-body">
			<h4 class="card-title">
				<a href="#">${param.name }</a>
			</h4>
			<h5>${param.price }</h5>
			<p class="card-text">${param.description}</p>
		</div>
		<div class="card-footer">
			<small class="text-muted">&#9733; &#9733; &#9733; &#9733;
				&#9734;</small>
		</div>
	</div>
</div>