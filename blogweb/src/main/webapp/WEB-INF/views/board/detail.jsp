<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Catalog-Z Contact page</title>
<link rel="stylesheet" href="/blogweb/resources/css/bootstrap.min.css">
<link rel="stylesheet"
	href="/blogweb/resources/fontawesome/css/all.min.css">
<link rel="stylesheet"
	href="/blogweb/resources/css/templatemo-style.css">
<style type="text/css">
.my-col-lg-4 {
	flex: 0 0 auto;
	margin: auto;
	width: 33.333333%;
}
</style>
</head>
<body>

	<jsp:include page="/WEB-INF/views/modules/header.jsp" />
	<div class="container-fluid tm-mt-60">
		<div class="row tm-mb-50">
			<div class="my-col-lg-4 col-12 mb-5">
				<div class="tm-address-col">
					<h2 class="tm-text-primary mb-5"
						style="background: rgba(0, 0, 0, 0.3);">${ board.title }</h2>
					<p class="tm-mb-20" style="background: rgba(0, 0, 0, 0.2);">
						작성 날짜 : ${ board.regdate } <br>작성자 : ${ board.name }
					</p>
					<p class="tm-mb-50">${ board.content }</p>

					<h3>이미지 박스</h3>
					<c:forEach var="attach" items="${ attachList }">
						<a href="/blogweb/resources/upload-files/${ attach.savedFileName }"	data-fancybox>
							<img src="/blogweb/resources/upload-files/${ attach.savedFileName }" alt="Image" class="img-fluid">
						</a>
					</c:forEach>
				</div>
				<br>
				<c:if test="${ loginuser.userNo eq board.writer }">
					<button class="btn btn-primary" onclick="editBoard()">수정</button>
					<button class="btn btn-primary" onclick="deleteBoard()">삭제</button>
				</c:if>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		function editBoard() {
			location.href = "/blogweb/board/edit?boardNo=${ board.boardNo }";
		}
		function deleteBoard() {
			var rs = confirm("삭제하시겠습니까?");
			if (rs == true) {
				location.href = "/blogweb/board/delete?boardNo=${ board.boardNo }";
			}
		}
	</script>
</body>
</html>