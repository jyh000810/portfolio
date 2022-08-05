<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>마이페이지</title>
<link rel="stylesheet" href="/blogweb/resources/css/bootstrap.min.css">
<link rel="stylesheet"
	href="/blogweb/resources/fontawesome/css/all.min.css">
<link rel="stylesheet" href="/blogweb/resources/css/templatemo-style.css">
</head>
<body>

	<jsp:include page="/WEB-INF/views/modules/header.jsp" />
	<div
		style="flex: 0 0 auto; margin: 150px auto; width: 700px; padding: 30px; border-style: solid; border-color: #9ec2e6;">
		<form action="edit" method="POST" enctype="multipart/form-data">
			<div class="row tm-mb-74 tm-people-row">
				<div class="col-lg-4">
					<c:choose>
						<c:when test="${ empty user.savedFileName }">
							<img src="/endb/resources/img/user.jpg" alt="Image"
								class="mb-4 img-fluid"
								style="float: left; width: 175px; height: 175px;">
						</c:when>
						<c:otherwise>
							<img src="/blogweb/resources/upload-files/${ user.savedFileName }"
								alt="Image" class="mb-4 img-fluid"
								style="float: left; width: 175px; height: 175px;">
						</c:otherwise>
					</c:choose>
					<input type="file" name="attach" enctype="multipart/form-data">
					<input type="hidden" name="savedFileName"
						value="${ user.savedFileName }"> <input type="hidden"
						name="userFileName" value="${ user.userFileName }">
				</div>
				<div class="col-lg-8">
					<input type="hidden" name="userNo" value="${ user.userNo }">
					<h3 class="form-control rounded-0">${ user.userId }</h3>
					<hr>
					<input type="text" name="name" class="form-control rounded-0"
						value="${ user.name }">
					<hr>
					<input type="email" name="email" class="form-control rounded-0"
						value="${ user.email }">
					<hr>
				</div>
				<hr>
				<div class="form-group tm-text-right">
					<button type="submit" class="btn btn-primary" style="float: right;">회원 수정</button>
					<button type="button" id="delete-btn" class="btn btn-primary"
						style="float: left;">계정 삭제</button>
				</div>
			</div>
		</form>
		<h3>작성한 글</h3>
		<table border="1" class="form-control rounded-0" style="width: 100%">
			<tr>
				<th style="width: 100px">글 제목</th>
				<th style="width: 100px">작성날짜</th>
			</tr>
			<c:forEach var="board" items="${ boardList }">
				<tr onclick="location.href = '/blogweb/board/detail?boardNo=${ board.boardNo }';">
					<td style="width: 100px">${ board.title }</td>
					<td style="width: 100px">${ board.regdate }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script type="text/javascript">
		$('#delete-btn').on('click', function(event) {
			var ok = confirm("계정을 삭제하시곘습니까?");
			if (ok) {
				location.href = 'userDelete?userNo=${ user.userNo }';
			}
		});
		
	</script>

</body>
</html>