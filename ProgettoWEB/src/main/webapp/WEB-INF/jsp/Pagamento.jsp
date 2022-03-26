<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link href="../css/Pagamento.css" rel="stylesheet" type="text/css"
	/ id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!DOCTYPE html>
<html>
<head>
<title>Pagamento</title>
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
<body style="background: #f5f3f2;">

	<div id="nav-placeholder"></div>
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

	<div class="card" style="border-color: #f5f3f2;">
		<div class="card-body">
			<div class="row">
				<div class="col-7">
					<div class="left border">
						<div class="row">
							<span class="header" style="margin-left: 15px">Le mie
								informazioni</span>
						</div>
						<form>
							<span>Email</span> <input placeholder="LindaAllen@gmail.com">
							<span>Nome</span> <input placeholder="Linda"> <span>Cognome</span><input
								placeholder="Allen">
						</form>
						<div class="row">
							<span class="header" style="margin-left: 15px">Indirizzo
								di fatturazione</span>
						</div>
						<form>
							<span>Indirizzo</span> <input
								placeholder="Via Leonardo Da Vinci, 17"> <span>Città</span>
							<input placeholder="Roma"> <span>Cap</span> <input
								placeholder="00118">
					</form>
					<div class="row">
						<span class="header" style="margin-left: 15px">Pagamento</span>
					</div>
					<form>
						<span>Nome:</span> <input placeholder="Linda"> <span>Cognome:</span>
						<input placeholder="Allen"> <span>Numero carta:</span> <input
							placeholder="0125 6780 4567 9909">
						<div class="row" style="margin-left: 0px">
							<div class="col-4">
								<span>Data di scadenza:</span> <input placeholder="YY/MM">
							</div>
							<div class="col-4">
								<span>CVV/CVC:</span> <input id="cvv">
							</div>
						</div>
					</form>
				</div>
			</div>
			<div class="col-md-5">
				<div class="right border">
					<div class="header">Riepilogo ordine</div>
					<div class="row item">
						<div class="col-4 align-self-center">
							<img class="img-fluid" src="https://i.imgur.com/79M6pU0.png">
						</div>
						<div class="col-8">
							<div class="row">
								<b>$ 26.99</b>
							</div>
							<div class="row text-muted">Be Legandary Lipstick-Nude rose</div>
							<div class="row">Qty:1</div>
						</div>
					</div>
					<div class="row item">
						<div class="col-4 align-self-center">
							<img class="img-fluid" src="https://i.imgur.com/Ew8NzKr.jpg">
						</div>
						<div class="col-8">
							<div class="row">
								<b>$ 19.99</b>
							</div>
							<div class="row text-muted">Be Legandary Lipstick-Sheer
								Navy Cream</div>
							<div class="row">Qty:1</div>
						</div>
					</div>
					<hr>
					<div class="row lower">
						<div class="col text-left">
							<b>Totale:</b>
						</div>
						<div class="col text-right">
							<b>$ 46.98</b>
						</div>
					</div>
					<button class="btn">Effettua l'ordine</button>
					<p class="text-muted text-center">Continua con lo shopping</p>
				</div>
			</div>
		</div>
	</div>
	<div></div>
	</div>
</body>
</html>