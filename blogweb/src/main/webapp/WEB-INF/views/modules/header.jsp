<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav class="navbar navbar-expand-lg">
	<div class="container-fluid">
		<a class="navbar-brand" href="/blogweb/home"> <i class="fas fa-film mr-2"></i>
			BLOG
		</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<i class="fas fa-bars"></i>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav ml-auto mb-2 mb-lg-0">
				<c:choose>
					<c:when test="${ empty loginuser }">
						<li class="nav-item"><a class="nav-link nav-link-1"
							onclick="showLogin()">로그인</a></li>
					</c:when>
					<c:otherwise>
						<li class="nav-item"><a class="nav-link nav-link-2"
							href="/blogweb/board/write">글 작성</a></li>
						<li class="nav-item"><a class="nav-link nav-link-3"
							href="/blogweb/mypage/info?userNo=${ loginuser.userNo }">마이페이지</a></li>
						<li class="nav-item"><a class="nav-link nav-link-4"
							href="/blogweb/account/logout">로그아웃</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
	</div>

	<script type="text/javascript">
		function showLogin() {
			var url = '/blogweb/account/login';
			var size = 'height=550, width=500';
			var left = window.screen.width / 2 - 250;
			var top = window.screen.height / 5;
			window.open(url, 'login', size + ', left=' + left + ', top=' + top);
		}
	</script>
</nav>
