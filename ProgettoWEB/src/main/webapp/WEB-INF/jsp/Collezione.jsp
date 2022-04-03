<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link href="../css/Collezione.css" rel="stylesheet" type="text/css"
	/ id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="../js/collezione.js"></script>
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
<body style="background:#f5f3f2">
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
	</div>
	
	<div>
				<div class="dropdown w3-right" style="background:#e9e4e2; margin-top:20px; margin-right:50px;">
				<button style="background:#e9e4e2;"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-caret-down-fill" viewBox="0 0 16 16">
  <path d="M7.247 11.14 2.451 5.658C1.885 5.013 2.345 4 3.204 4h9.592a1 1 0 0 1 .753 1.659l-4.796 5.48a1 1 0 0 1-1.506 0z"/>
</svg>Ordina</button> 
							<div class="dropdown-content" style="float: right;background:#e9e4e2;">
							
							<form id="formSetContenuto" method="GET" action="PrezzoCrescente">
							<input type="hidden" id="categoria" name="categoria" value="${categoria}">
								<button class="btnSort" type="submit">Prezzo crescente</button>
								</form>
								
							<form id="form" method="GET" action="PrezzoDecrescente">
							<input type="hidden" id="categoria" name="categoria" value="${categoria}">
								<button class="btnSort" type="submit">Prezzo decrescente</button>
								</form>
							</div>
				</div>
	<div class="container bootstrap snipets" style="float:right;">
		<h1 class="text-center text-muted">Catalogo</h1>
		<div class="row" style="display: flex; justify-content: center;">
			<c:forEach items="${prodotti}" var="prod">
				<div class="col-xs-12 col-md-6">
					<div class="product tumbnail" style="width: fit-content;">
						<img src="${prod.img}" width="250" height="300" alt="">
						<div class="caption">
							<form id="formSetContenuto" method="GET" action="PaginaProdotto">
								<input type="hidden" id="idProdotto" name="idProdotto" value="${prod.id}">
								<c:if test="${username != null}">
								<button type="submit" class="btn" style="border:transparent;padding-bottom: 0px;padding-left: 0px;padding-top: 0px;">${prod.nome}</button>
								</c:if>
								<br>
							<span class="price">Prezzo: ${prod.prezzo}&#8364</span>
							</form>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
</body>
</html>