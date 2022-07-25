<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Register</title>
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
<!--
    
TemplateMo 556 Catalog-Z
https://templatemo.com/tm-556-catalog-z
-->
</head>
<body>
	<div class="container-fluid tm-mt-60">
		<div class="row tm-mb-50">
			<div class="my-col-lg-4 col-12 mb-5">
				<h2 class="tm-text-primary mb-5">REGISTER</h2>
				<form onsubmit="return Check()" id="contact-form" action="register"
					method="POST" class="tm-contact-form mx-auto">
					<div class="form-group">
						<input type="text" id="userId" name="userId"
							class="form-control rounded-0" placeholder="아이디 (영문포함 4~12자 이상)"
							required /> 
						<p id="msgId"></p>
						<input type="button" id="checkId" value="중복검사">
					</div>
					<div id="ms"></div>
					<div class="form-group">
						<input type="password" id="passwd" name="passwd"
							class="form-control rounded-0"
							placeholder="비밀번호 (영 대/소문자, 숫자 조합 8~16자 이상)" required />
						<p id="msgPw"></p>
					</div>
					<div class="form-group">
						<input type="password" id="confirm" name="confirm"
							class="form-control rounded-0" placeholder="비밀번호를 확인해주세요."
							required />
					</div>
					<div class="form-group">
						<input type="text" id="name" name="name"
							class="form-control rounded-0" placeholder="이름을 입력하세요." required />
						<p id="msgName"></p>
					</div>
					<div class="form-group">
						<input type="email" id="email" name="email"
							class="form-control rounded-0" placeholder="이메일" required />
					</div>
					<div class="form-group tm-text-right">
						<button type="submit" class="btn btn-primary">REGISTER</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script type="text/javascript">
		var userIdCheck = RegExp(/^[A-Za-z0-9]{4,12}$/);
		var passwdCheck = RegExp(/^(?=.*[a-zA-Z])(?=.*\d).{8,16}$/);
		var nameCheck = RegExp(/^[가-힣]+$/);
		function Check() {
			if (!userIdCheck.test($("#userId").val())) {
				$("#msgId").html("아이디 형식에 맞게 입력해주세요");
				$("#userId").val("");
				$("#userId").focus();
				return false;
			}
			if ($("#userId").attr("readonly") != 'readonly') {
				$('#msgId').html("중복 검사를 해야합니다.");
				return false
			}
			if ($('#passwd').val() != $('#confirm').val()) {
				$("#msgPw").html("비밀번호를 확인해주세요");
				$("#passwd").val("");
				$('#confirm').val("");
				$("#passwd").focus();
				return false;
			}
			if (!passwdCheck.test($('#passwd').val())) {
				$("#msgPw").html("비밀번호 형식에 맞게 입력해주세요");
				$("#passwd").val("");
				$('#confirm').val("");
				$("#passwd").focus();
				return false;
			}
			if (!nameCheck.test($('#name').val())) {
				$('#msgName').html("한글 이름을 작성해주세요");
				$("#name").val("");
				$("#name").focus();
				return false;
			}
		}
		$('#checkId').on('click', function() {
			checkId = $('#userId').val()
			if (!userIdCheck.test($("#userId").val())) {
				$("#msgId").html("아이디 형식에 맞게 입력해주세요.");
				$("#userId").val("");
				$("#userId").focus();
				return false;
			}
			$.ajax({
				"url" : "checkId",
				"method" : "post",
				"async" : true,
				"data" : "checkId=" + checkId, // boardno=1&writer=imauser1&content=test
				"dataType" : "text",
				"success" : function(data, status, xhr) {
					if (data === "success") {
						$("#userId").attr("readonly", true);
						$("#msgId").html("사용가능한 아이디 입니다.");
					} else {
						$("#msgId").html("중복된 아이디입니다.");
						$('#userId').val("")
					}
				},
				"error" : function(xhr, status, err) {
				}
			});
		});
	</script>
</body>

</html>