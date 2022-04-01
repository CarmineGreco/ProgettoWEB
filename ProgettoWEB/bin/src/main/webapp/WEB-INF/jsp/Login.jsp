<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link href="../css/Login.css" rel="stylesheet" type="text/css"
	/ id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<script src="../js/login.js"></script>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
	integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"
	crossorigin="anonymous">

<!--Custom styles-->
<link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<div id="fb-root"></div>
<script async defer crossorigin="anonymous" src="https://connect.facebook.net/it_IT/sdk.js#xfbml=1&version=v13.0&appId=2147446885419343&autoLogAppEvents=1" nonce="gYFd7bsu"></script>
	<div class="container">
		<div class="d-flex justify-content-center h-100">
			<div class="card">
				<div class="card-header">
					<h3>Accedi</h3>
					<div class="d-flex justify-content-end social_icon">
						<span><i class="fab fa-facebook-square"></i></span> <span><i
							class="fab fa-google-plus-square"></i></span>
					</div>
				</div>
				<div class="card-body">
					<form method="post" action="loginService">
						<div class="input-group form-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fas fa-user"></i></span>
							</div>
							<input type="text" class="form-control" name="username" placeholder="Username" id="user"
								required>

						</div>
						<div class="input-group form-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fas fa-key"></i></span>
							</div>
							<input type="password" class="form-control" name="pass" id="password"
								placeholder="Password" required>
						</div>
						<div class="row align-items-center remember">
							<input type="checkbox">Ricordami
						</div>
						<div class="fb-login-button" data-width="" data-size="medium" data-button-type="continue_with" data-layout="rounded" data-auto-logout-link="false" data-use-continue-as="false"></div>
						<div class="g-signin2" data-onsuccess="onSignIn"></div>
						<div class="form-group">
							<input type="submit" value="Accedi"
								class="btn float-right login_btn">
						</div>
					</form>
				</div>
				<div class="card-footer">
					<div class="d-flex justify-content-center links">
						Non hai un account?<a href="Registrazione">Registrati</a>
					</div>
					<div class="d-flex justify-content-center">
						<a href="#">Hai dimenticato la password?</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>