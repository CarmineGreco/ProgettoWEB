<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Carla Ferroni Reggio Calabria</title>
<link rel="stylesheet" href="/css/style.css">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/v4-shims.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/js/v4-shims.min.js">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
	integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"
	crossorigin="anonymous">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!-- EMAIL -->
<script src="https://smtpjs.com/v3/smtp.js"></script>
<script src="../js/index.js"></script>
<style>
.w3-sidebar a {
	font-family: "Roboto", sans-serif
}

body, h1, h2, h3, h4, h5, h6, .w3-wide {
	font-family: "Montserrat", sans-serif;
}
</style>
</head>
<body>
	<!-- Top header -->
	<header class="row">
			<!--  <img class="col-3" src="img/Logo.jpg" height="150" width="300" /> -->
			<a href="/"class="w3-bar-item w3-button"><span class="col-3" style="font-size: 24px;">CARLA<br>FERRONI<br>REGGIO<br>CALABRIA</span></a>
		<div class="col-10" style="float: right">
		<div class="dropdown w3-right">
			<button class="dropbtn btn" type="button"">
				<i class="fas fa-user" style="font-size: x-large;"></i>
			</button>
			<div class="dropdown-content" style="float: right;">
				<c:if test="${username==null}">
					<a id="text" href="Login">Login</a>
				</c:if>
				<c:if test="${username!=null}">
					<a id="text" href="Carrello">Carrello</a>
					<a id="text" href="Profilo">Profilo</a>
					<a id="text" href="Preferiti">Preferiti</a>
					<a id="text" href="ListaOrdini">I tuoi ordini</a>
					<a id="text" href="Logout">Logout</a>
				</c:if>
			</div>
		</div>
		<p class="w3-right">
			<a href="#"><button class="btn">
					<i class="fa fa-search w3-margin-right" style="font-size: x-large"></i>
				</button>
		</p>
		</div>
	</header>
	<!-- Top menu on small screens -->
	<header class="w3-bar w3-w3-top w3-hide-large w3-white w3-xlarge">
		<a href="javascript:void(0)"
			class="w3-bar-item w3-button w3-white w3-padding-24 w3-right"
			onclick="w3_open()"><i class="fa fa-bars"></i></a>
	</header>

</body>
</html>