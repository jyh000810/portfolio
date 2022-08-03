<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>BLOG</title>
<link rel="stylesheet" href="/blogweb/resources/css/bootstrap.min.css">
<link rel="stylesheet"
	href="/blogweb/resources/fontawesome/css/all.min.css">
<link rel="stylesheet"
	href="/blogweb/resources/css/templatemo-style.css">
<!--
TemplateMo 556 Catalog-Z
https://templatemo.com/tm-556-catalog-z
-->
</head>
<body>

	<jsp:include page="/WEB-INF/views/modules/header.jsp" />
	<div class="container-fluid tm-container-content tm-mt-60">
		<div class="row mb-4">
			<h2 class="col-6 tm-text-primary">게시판</h2>
		</div>
		<div class="row tm-mb-90 tm-gallery">
			<c:forEach var="board" items="${ boardList }">
				<div class="col-xl-3 col-lg-4 col-md-6 col-sm-6 col-12 mb-5">
					<figure class="effect-ming tm-video-item">
						<img src="/blogweb/resources/upload-files/${ board.thumbnail }" alt="Image" class="img-fluid">
						<figcaption
							class="d-flex align-items-center justify-content-center">
							<h2>CLICK</h2>
							<a href="board/detail?boardNo=${board.boardNo }">View more</a>
						</figcaption>
					</figure>
					<div class="d-flex justify-content-between" style="height: 50px">
						<span class="tm-text" style="font-size: 32px">${ board.title }</span>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>


</body>
</html>