<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link href="../css/Carrello.css" rel="stylesheet" type="text/css"
	/ id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!DOCTYPE html>
<html>
<head>
<title>Carrello</title>
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
<body style="background: #f5f3f2">

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


	<div class="container2" style="background: #f5f3f2">
		<div class="row">
			<div class="col-7 col-3">
				<h2>Prodotti</h2>
				<!-- Item-->
				<c:forEach items="${prodCarrello}" var="prodCar">
					<c:forEach items="${prodotti}" var="prod">
						<c:if
							test="${(prod.id == prodCar.idProdotto) && (prod.taglia == prodCar.tagliaProdotto)}">
							<div
								class="d-sm-flex justify-content-between my-4 pb-4 border-bottom">
								<div class="media d-block d-sm-flex text-center text-sm-left">
									<a class="cart-item-thumb mx-auto mr-sm-4" href="#"><img
										src="${prod.img}" alt="Product"></a>
									<div class="media-body pt-3">
										<form id="formSetContenuto" method="GET"
											action="PaginaProdotto">
											<input type="hidden" id="idProdotto" name="idProdotto"
												value="${prod.id}">
											<c:if test="${username != null}">
												<button type="submit" class="btn btn-outline-info" style="border:transparent;padding-bottom: 0px;padding-left: 0px;padding-top: 0px; float:"left">
													<i class="icon-cog"></i>${prod.nome}
												</button>
											</c:if>
										</form>
										<div class="font-size-sm">
											<span class="text-muted mr-2">Taglia:
												${prodCar.tagliaProdotto}</span>
										</div>
										<div class="font-size-lg text-primary pt-2">Prezzo:
											${prod.prezzo}&#8364</div>
											<div class="font-size-lg text-primary pt-2">Quantita: ${prodCar.quantita}</div>
									</div>
								</div>
								<form id="formElimina" method="GET"
								action="eliminaProdottoCarrello">
								<input type="hidden" id="idP" name="idP"
												value="${prod.id}">
											<input type="hidden" id="tagliaP" name="tagliaP"
												value="${prod.taglia}">
											
									<div
										class="pt-2 pt-sm-0 pl-sm-3 mx-auto mx-sm-0 text-center text-sm-left"
										style="max-width: 10rem;">
										<div class="form-group mb-2">
											<div class="row"></div>											
											<button type="submit" class="btn btn-sm btn-danger dim"
									style="float: left"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash3" viewBox="0 0 16 16">
  <path d="M6.5 1h3a.5.5 0 0 1 .5.5v1H6v-1a.5.5 0 0 1 .5-.5ZM11 2.5v-1A1.5 1.5 0 0 0 9.5 0h-3A1.5 1.5 0 0 0 5 1.5v1H2.506a.58.58 0 0 0-.01 0H1.5a.5.5 0 0 0 0 1h.538l.853 10.66A2 2 0 0 0 4.885 16h6.23a2 2 0 0 0 1.994-1.84l.853-10.66h.538a.5.5 0 0 0 0-1h-.995a.59.59 0 0 0-.01 0H11Zm1.958 1-.846 10.58a1 1 0 0 1-.997.92h-6.23a1 1 0 0 1-.997-.92L3.042 3.5h9.916Zm-7.487 1a.5.5 0 0 1 .528.47l.5 8.5a.5.5 0 0 1-.998.06L5 5.03a.5.5 0 0 1 .47-.53Zm5.058 0a.5.5 0 0 1 .47.53l-.5 8.5a.5.5 0 1 1-.998-.06l.5-8.5a.5.5 0 0 1 .528-.47ZM8 4.5a.5.5 0 0 1 .5.5v8.5a.5.5 0 0 1-1 0V5a.5.5 0 0 1 .5-.5Z"/>
</svg>
<polyline points="3 6 5 6 21 6"></polyline>Rimuovi prodotto
								</button>
											
								</form>
							</div>
							</form>
							
			</div>

		</div>
		</c:if>
		</c:forEach>
		</c:forEach>
	</div>
	<div class="col-2 cont">
		<h2>Totale</h2>
		<h2>${sommaProdotti}&#8364</h2>
		<hr>
		<form id="formSetContenuto" method="GET" action="Pagamento">
			<input type="hidden" id="totale" name="totale"
				value="${sommaProdotti}">
			<button type="submit" class="btn btn-sm btn-outline-info"
				style="float: left">
				<i class="icon-cog"><svg xmlns="http://www.w3.org/2000/svg"
						width="24" height="24" viewBox="0 0 24 24" fill="none"
						stroke="currentColor" stroke-width="2" stroke-linecap="round"
						stroke-linejoin="round" class="feather feather-credit-card mr-2">
                    <rect x="1" y="4" width="22" height="16" rx="2"
							ry="2"></rect>
                    <line x1="1" y1="10" x2="23" y2="10"></line>
                </svg>Pagamento</a>
			</button>
		</form>
	</div>
	</div>
	</div>