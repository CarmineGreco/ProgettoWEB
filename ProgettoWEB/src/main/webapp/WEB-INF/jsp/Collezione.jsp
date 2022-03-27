<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link href="../css/Collezione.css" rel="stylesheet" type="text/css"
	/ id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!DOCTYPE html>
<html>
<head>
<title>Collezione</title>
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
	
		<div class="container bootstrap snipets">
		<h1 class="text-center text-muted">Catalogo ${prodotti.categoria}</h1>
 <c:forEach items="${prodotti}" var="prod">
		<div class="row" style="display: flex; justify-content: center;">
			<div class="col-xs-12 col-md-6">
				<div class="product tumbnail" style="width: fit-content;">
					<a href="#"><img
						src="https://via.placeholder.com/350x280/87CEFA/000000"
						style="max-width: 500px" alt=""></a>
					<div class="caption">
						<h6>
							<a href="#">${prod.nome}</a>
						</h6>
						<span class="price"> <del>${prod.prezzo}</del></span>
					</div>
				</div>
			</div>
		</div>		
</c:forEach>
</body>
</html>