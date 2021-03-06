<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<link rel="stylesheet"href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/js/v4-shims.min.js">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"crossorigin="anonymous">
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
	<div id="nav-placeholder" ></div>
	<script>
		$(function() {
			$("#nav-placeholder").load("http://localhost:8080/navbar");
		});
	</script>
	<div id="side-bar"></div>
	<script>
		$(function() {
			$("#side-bar").load("http://localhost:8080/sidebar");
		});
	</script>

	<!-- !PAGE CONTENT! -->
	<div class="w3-main" style="margin-left: 250px">

		<!-- Push down content on small screens -->
		<div class="w3-hide-large" style="margin-top: 83px"></div>

		<!-- Image header -->
		<div class="w3-display-container w3-container">
			<img
				src="https://www.carlaferroni.it/wp-content/uploads/2022/02/CF-lookbook-ss-22_19-1200x841.jpg"
				alt="Jeans" style="width: 102%">
			<div class="w3-display-topleft w3-text-white"
				style="padding: 50px 80px">
				<h1 class="riga w3-jumbo w3-hide-small" id="NuoviArrivi">Nuovi
					Arrivi</h1>

				<h1 class="riga w3-hide-small">COLLECTION 2022</h1>
				<p>
					<a href="#jeans"
						class="w3-button w3-black w3-padding-large w3-large">Dove
						Siamo</a>
				</p>
			</div>
		</div>

		<div class="w3-container w3-text-grey" id="jeans"></div>

		<!-- Product grid -->
		<div class="w3-row w3-grayscale">
			<div class="w3-col l3 s6">
				<div class="w3-container"></div>
				<div class="w3-container"></div>
			</div>
			<div class="w3-col l3 s6">
				<div class="w3-container">
					<div class="w3-display-container">
						<div class="w3-display-middle w3-display-hover"></div>
					</div>
				</div>
				<div class="w3-container"></div>
			</div>
			<div class="w3-col l3 s6">
				<div class="w3-container"></div>
				<div class="w3-container">
					<div class="w3-display-container">
						<div class="w3-display-middle w3-display-hover"></div>
					</div>
				</div>
			</div>
			<div class="w3-col l3 s6">
				<div class="w3-container"></div>
				<div class="w3-container"></div>
			</div>
		</div>

		<!-- Subscribe section -->
		<div class="colore sfond w3-container w3-padding-32">
			<h2>La Nostra Storia</h2>
			<h5>Su iniziativa di un piccolo imprenditore calabrese e con
				l'approvazione dell'azienda CARLA FERRONI, nel Gennaio del 2007 in
				Via Santa Caterina d'Alessandria, nasce il primo negozio Carla
				Ferroni shop in Italia. Grazie alla professionalit?? trovata in
				negozio e alla diretta collaborazione con l'azienda, i nostri punti
				vendita diventeranno nel tempo tre, che attualmente si trovano in
				Via Santa Caterina d'Alessandria n.165, Via Osanna n.37 e in Via
				Vico Furnari n.24.</h5>
		</div>

		<!-- Footer -->
		<footer class="sfondo" id="footer">
			<div class="w3-row-padding wrapper">
				<div class="w3-col s4 wrapper">
					<h4>Contattaci</h4>
					<p>Inviaci la tua domanda.</p>
					<form action="/action_page.php" target="_blank">
						<p>
							<input class="w3-input w3-border" type="text" id="nome"
								placeholder="Nome" name="Nome" required>
						</p>
						<p>
							<input class="w3-input w3-border" type="text" id="email"
								placeholder="Email" name="Email" required>
						</p>
						<p>
							<input class="w3-input w3-border" id="oggetto" type="text"
								placeholder="Oggetto" name="Oggetto" required>
						</p>
						<p>
							<input class="w3-input w3-border" type="text" id="messaggio"
								placeholder="Messaggio" name="Messaggio" required>
						</p>
						<input type="button" class="w3-button w3-block w3-black"
							value="Invia"
							onClick="sendEmail(document.getElementById('nome').value, document.getElementById('email').value, document.getElementById('oggetto').value, document.getElementById('messaggio').value)" />
					</form>
				</div>


				<div class="w3-justify wrapper">
					<h4>I nostri contatti</h4>
					<p></p>
					<p id="text">
						<i class="fa fa-fw fa-phone w3-large"></i> 0965-810807
					</p>
					<p id="text">
						<a href="mailto:carlaferronirc@gmail.com"> <i
							class="fa fa-fw fa-envelope w3-large"></i>
							carlaferronirc@gmail.com
						</a>
					</p>
					<p id="text">
						<a href="https://www.facebook.com/CarlaFerroniReggioCalabria"><i
							class="fa fa-facebook-official w3-hover-opacity w3-large">
								Carla Ferroni Reggio Calabria</i></a>
					</p>
					<p id="text">
						<a href="https://www.instagram.com/carlaferronirc/"> <i
							class="fa fa-instagram w3-hover-opacity w3-large">
								carlaferronirc</i></a>
					</p>
				</div>
				<div class="w3-row-padding">
					<p></p>
					<h4>Dove siamo</h4>
					<div class="row">
						<div class="col"">
							<iframe
								src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3138.775801901945!2d15.65122731561849!3d38.122149979697795!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x131450ed85c5d1bb%3A0x70ad78ad83515cc3!2sVia%20Santa%20Caterina%20d'Alessandria%2C%20165%2C%2089122%20Reggio%20Calabria%20RC!5e0!3m2!1sit!2sit!4v1646214236091!5m2!1sit!2sit"
								width="300" height="300" style="border: 0;" allowfullscreen=""
								loading="lazy"></iframe>
						</div>
						<div class="col"">
							<iframe
								src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3139.3446314488638!2d15.64343991561822!3d38.10891597970007!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x131450861633f7af%3A0x4826e06d4fded933!2sVia%20Osanna%2C%2037%2C%2089125%20Reggio%20di%20Calabria%20RC!5e0!3m2!1sit!2sit!4v1646214917346!5m2!1sit!2sit"
								width="300" height="300" style="border: 0;" allowfullscreen=""
								loading="lazy"></iframe>
						</div>
						<div class="col"">
							<iframe
								src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3139.7815802613095!2d15.634956015617947!3d38.09874757970182!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x13145a81bcbeda8f%3A0xeb055a35415e27bb!2sVia%20Nicola%20Furnari%2C%2024%2C%2089129%20Reggio%20Calabria%20RC!5e0!3m2!1sit!2sit!4v1646214947075!5m2!1sit!2sit"
								width="300" height="300" style="border: 0;" allowfullscreen=""
								loading="lazy"></iframe>
						</div>
					</div>
				</div>
			</div>
		</footer>

		<div class="w3-black w3-center w3-padding-24">Carla Ferroni
			Reggio Calabria</div>

		<!-- End page content -->
	</div>

	<!-- Newsletter Modal -->
	<div id="newsletter" class="w3-modal">
		<div class="w3-modal-content w3-animate-zoom" style="padding: 32px">
			<div class="w3-container w3-white w3-center">
				<i
					onclick="document.getElementById('newsletter').style.display='none'"
					class="fa fa-remove w3-right w3-button w3-transparent w3-xxlarge"></i>
				<h2 class="w3-wide">NEWSLETTER</h2>
				<p>Join our mailing list to receive updates on new arrivals and
					special offers.</p>
				<p>
					<input class="w3-input w3-border" type="text"
						placeholder="Enter e-mail">
				</p>
				<button type="button"
					class="w3-button w3-padding-large w3-red w3-margin-bottom"
					onclick="document.getElementById('newsletter').style.display='none'">Subscribe</button>
			</div>
		</div>
	</div>

	<script>
		/*
		 // Accordion 
		 function myAccFunc() {
		 var x = document.getElementById("demoAcc");
		 if (x.className.indexOf("w3-show") == -1) {
		 x.className += " w3-show";
		 } else {
		 x.className = x.className.replace(" w3-show", "");
		 }
		 }

		 // Click on the "Jeans" link on page load to open the accordion for demo purposes
		 document.getElementById("myBtn").click();
		 */

		// Open and close sidebar
		function w3_open() {
			document.getElementById("mySidebar").style.display = "block";
			document.getElementById("myOverlay").style.display = "block";
		}

		function w3_close() {
			document.getElementById("mySidebar").style.display = "none";
			document.getElementById("myOverlay").style.display = "none";
		}
	</script>

</body>
</html>