<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>작성페이지</title>
<link rel="stylesheet" href="/blogweb/resources/css/bootstrap.min.css">
<link rel="stylesheet"
	href="/blogweb/resources/fontawesome/css/all.min.css">
<link rel="stylesheet"
	href="/blogweb/resources/css/templatemo-style.css">
</head>

<body style="padding: 50px">
	<form id="contact-form" action="edit" method="POST" enctype="multipart/form-data"
		class="tm-contact-form mx-auto">
		<!-- 제목 작성 -->
		<div class="form-group" style="width: 500px">
			<input type="text" name="title" class="form-control rounded-0" placeholder="제목" value="${ board.title }" required /> 
		</div>
		<!-- 파일 첨부 -->
		<input type="file" name="attach" id="image" accept=".jpg" onchange="setThumbnail(event);" multiple/><br>
		<c:forEach var="file" items="${ attachList }">
		${ file.userFileName }<br>
		</c:forEach>
		<!-- 내용 작성 -->
		<div class="form-group" style="width: 500px;">
			<textarea rows="20" name="content" class="form-control rounded-0" placeholder="내용" style="resize: none;" required>${ board.content }</textarea> 
		</div>
		<!-- 작성 버튼 및 취소 버튼 -->
		<div class="form-group tm-text-right">
			<button type="submit" class="btn btn-primary">작성</button>
			<button type="button" class="btn btn-primary" onclick="history.back()">취소</button>
		</div>
	</form>
	<h3>이미지 미리보기</h3>
	<div id="image_container"></div>
	<script>
      function setThumbnail(event) {
        for (var image of event.target.files) {
          var reader = new FileReader();
          reader.onload = function(event) {
            var img = document.createElement("img");
            img.setAttribute("src", event.target.result);
            img.setAttribute("style", "height : 200px; width : 300px;")
            document.querySelector("#image_container").appendChild(img);
          };
          reader.readAsDataURL(image);
        }
      }
    </script>
</body>
</html>