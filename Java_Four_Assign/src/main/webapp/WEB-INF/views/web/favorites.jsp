<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Catalog-Z Bootstrap 5.0 HTML Template</title>
</head>
<body>
	<div class="container-fluid tm-container-content tm-mt-60">
		<div class="row mb-4">
			<h2 class="col-6 tm-text-primary">${title}</h2>
			<div class="col-6 d-flex justify-content-end align-items-center">
				<form action="" class="tm-text-primary">
					Page <input type="text" value="1" size="1"
						class="tm-input-paging tm-text-primary"> of 200
				</form>
			</div>
		</div>
		<div class="row tm-mb-90 tm-gallery">
			<c:forEach var="item" items="${videos}">
				<div class="col-xl-3 col-lg-4 col-md-6 col-sm-6 col-12 mb-5">
					<h5 class="tm-text-secondary"
						style="white-space: nowrap; overflow: hidden;">${item.title }</h5>
					<figure class="effect-ming tm-video-item">
						<img src="https://img.youtube.com/vi/${item.href }/maxresdefault.jpg"
							alt="Image" class="img-fluid">
						<figcaption
							class="d-flex align-items-center justify-content-center">
							<h2>${item.description}</h2>
							<a href="<c:url value='/video?action=watch&id=${item.href }'/>">View more</a>
						</figcaption>
					</figure>
					<div class="d-flex justify-content-between tm-text-gray">
						<span id="hvn" class="tm-text-gray-light"></span> <span>${item.views }
							views</span>
					</div>
				</div>
			</c:forEach>
		</div>
		<div class="col d-flex justify-content-center">
				<ul class="pagination" id="pagination"></ul>
				<input type="hidden" value="" id="page" name="page"/>
				<input type="hidden" value="" id="limit" name="limit"/>
			</div>
		<!-- row -->
	</div>
	<script type="text/javascript">
	    var totalPages = ${model.totalPage};
		var currentPage = ${model.page};
	    $(function () {
	        window.pagObj = $('#pagination').twbsPagination({
	            totalPages: totalPages,
	            visiblePages: 10,
	            startPage: currentPage,
	            onPageClick: function (event, page) {
		            if(currentPage != page){
		            	$('#limit').val(4);
						$('#page').val(page);
						$('#formSubmit').submit();
		            }
	            }
	        })
	    });
	</script>
	<script>
	 var today = new Date();
	 var time = today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();
	 document.getElementById("hvn").innerHTML = time;
	</script>
</body>

</html>