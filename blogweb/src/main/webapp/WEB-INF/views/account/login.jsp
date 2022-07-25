<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>login</title>
<link rel="stylesheet" href="/blogweb/resources/css/bootstrap.min.css">
<link rel="stylesheet"
	href="/blogweb/resources/fontawesome/css/all.min.css">
<link rel="stylesheet"
	href="/blogweb/resources/css/templatemo-style.css">
<style type="text/css">
.my-col-lg-4 {
	flex: 0 0 auto;
	margin: auto;
	width: 66.6%;
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
				<h2 class="tm-text-primary mb-5">Login</h2>
				<form id="contact-form" action="login" method="POST"
					class="tm-contact-form mx-auto">
					<div class="form-group">
						<input type="text" name="userId" class="form-control rounded-0"
							placeholder="ID" required />
					</div>
					<div class="form-group">
						<input type="password" name="passwd"
							class="form-control rounded-0" placeholder="PW" required />
					</div>
					${ login_fail }
					<div class="form-group tm-text-right">
						<button type="submit" class="btn btn-primary">Login</button>
					</div>
				</form>
				<p>아직 회원이 아니신가요? <a onclick="showRegister()">회원가입</a></p>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
if(${ !empty loginuser }) {
	 window.close();
	 opener.location.reload();
}

function showRegister() {
	window.close();
	opener.location.href="/blogweb/account/register";
}
</script>
</html>