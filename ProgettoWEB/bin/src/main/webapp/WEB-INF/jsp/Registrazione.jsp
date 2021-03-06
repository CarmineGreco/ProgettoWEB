<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link href="../css/Registrazione.css" rel="stylesheet" type="text/css"
	/ id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="../js/Registrazione.js"></script>
<!------ Include the above in your HEAD tag ---------->

<!DOCTYPE html>
<html>
<head>
<meta name="google-signin-client_id" content="31963347470-bo3c78afmlhpmgm28tjh0rqp2239d06u.apps.googleusercontent.com">
<title>Registrazione</title>

<!--Bootsrap 4 CDN-->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">

<!--Fontawesome CDN-->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
	integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"
	crossorigin="anonymous">

<!--Custom styles-->
<link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
	<div class="container">
		<div class="d-flex justify-content-center h-100">
			<div class="card">
				<div class="card-header">
					<h3>Crea il tuo account</h3>
				</div>
				<div class="card-body">
					<form method="post" action="registrationService">
						<div class="input-group form-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fas fa-user"></i></span>
							</div>
							<input type="text" class="form-control" placeholder="Username" name="username"
								required>
						</div>
						<div class="input-group form-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i
									class="fas fa-signature"></i></span>
							</div>
							<input type="text" class="form-control" placeholder="Nome" name="nome"
								required>
						</div>
						<div class="input-group form-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i
									class="fas fa-signature"></i></span>
							</div>
							<input type="text" class="form-control" placeholder="Cognome" name="cognome"
								required>
						</div>
						<div class="input-group form-group">
							<div class="input-group-prepend">

								<span class="input-group-text"><i class="fas fa-envelope"></i></span>
							</div>
							<input type="text" class="form-control" placeholder="Email" name="email"
								required>
						</div>
						<div class="input-group form-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fas fa-key"></i></span>
							</div>
							<input type="password" class="form-control" name="pass" id="password"
								placeholder="Password" required>
						</div>
						<div class="input-group form-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fas fa-key"></i></span>
							</div>
							<input type="password" class="form-control" name="confermaPass" id="password"
								placeholder="Password" required>
						</div>
						<div class="form-group">
							<input type="submit" value="Registrati"
								class="btn float-right registrazione_btn">
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>