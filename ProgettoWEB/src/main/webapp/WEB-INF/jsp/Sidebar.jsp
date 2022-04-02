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
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/v4-shims.min.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/js/v4-shims.min.js">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	
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
<body style="background:#e9e4e2">
	
	<!-- Sidebar/menu -->
	
	<nav class="w3-sidebar w3-bar-block w3-collapse" style="background:#e9e4e2; padding-top: 50px" style=" width: fit-content;" id="mySidebar">
<!-- 	<nav class="w3-bar-block w3-collapse" style="background:#e9e4e2; padding-top: 50px; width: 100px; position: fixed!important; overflow:auto;" id="mySidebar"> -->
		<div class="w3-container w3-display-container w3-padding-16" style="background:#e9e4e2">
			<i onclick="w3_close()" class="fa fa-remove w3-hide-large w3-button w3-display-topright" style="background:#e9e4e2"></i>
		</div>
		<div class="w3-padding-64 w3-large w3-text-grey"
			style="font-weight: bold; background:#e9e4e2;">
			<a href="CollezioneMaglia" class="w3-bar-item w3-button" >Maglie</a> <a
				href="CollezioneVestiti" class="w3-bar-item w3-button">Vestiti</a> <a
				href="CollezionePantaloni" class="w3-bar-item w3-button">Pantaloni</a> <a
				href="CollezioneFelpe" class="w3-bar-item w3-button">Felpe</a> <a
				href="CollezioneCamicie" class="w3-bar-item w3-button">Camicie</a>
		</div>

	</nav>
	<!-- Overlay effect when opening sidebar on small screens -->
	<div class="w3-overlay w3-hide-large" onclick="w3_close()"
		style="cursor: pointer; z-index:0;" title="close side menu" style="background:#e9e4e2" id="myOverlay"></div>
</body>
</html>