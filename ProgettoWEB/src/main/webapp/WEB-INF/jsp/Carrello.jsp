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


	<div class="container2">
		<div class="row">
			<div class="col-7 col-3">
				<h2>Prodotti</h2>
				<!-- Item-->
				<c:forEach items="${prodCarrello}" var="prodCar">
					<c:forEach items="${prodotti}" var="prod">
						<c:if
							test="${(prod.id != $prodCarrello.idProdotto) and (prod.taglia == prodCar.tagliaProdotto)}">
							<div
								class="d-sm-flex justify-content-between my-4 pb-4 border-bottom">
								<div class="media d-block d-sm-flex text-center text-sm-left">
									<a class="cart-item-thumb mx-auto mr-sm-4" href="#"><img
										src="${prod.img}" alt="Product"></a>
									<div class="media-body pt-3">
										<form id="formSetContenuto" method="POST"
											action="PaginaProdotto">
											<input type="hidden" id="idProdotto" name="idProdotto"
												value="${prod.id}">
											<c:if test="${username != null}">
												<button type="submit" class="btn btn-sm btn-outline-info"
													style="float: left">
													<i class="icon-cog"></i>${prod.nome}
												</button>
											</c:if>
										</form>
										<div class="font-size-sm">
											<span class="text-muted mr-2">Taglia:
												${prodCar.tagliaProdotto}</span>
										</div>
										<div class="font-size-lg text-primary pt-2">Prezzo:
											${prod.prezzo}</div>
									</div>
								</div>
								<form id="formSetContenuto" method="GET"
									action="aggiornaQuantita">
									<div
										class="pt-2 pt-sm-0 pl-sm-3 mx-auto mx-sm-0 text-center text-sm-left"
										style="max-width: 10rem;">
										<div class="form-group mb-2">
											<label for="quantity1">Quantity</label> <input type="hidden"
												id="idProdotto" name="idProdotto"
												value="${prodCar.idProdotto}"> <input type="hidden"
												id="prezzo" name="prezzo" value="${prodCar.prezzo}">
											<input type="hidden" id="taglia" name="taglia"
												value="${prodCar.tagliaProdotto}"> <input
												type="number" id="quantita" name="quantita"
												value="${prodCar.quantita}">
											<button type="submit" class="btn btn-sm btn-outline-info"
												style="float: left">
												<i class="icon-cog"><svg
														xmlns="http://www.w3.org/2000/svg" width="24" height="24"
														viewBox="0 0 24 24" fill="none" stroke="currentColor"
														stroke-width="2" stroke-linecap="round"
														stroke-linejoin="round"
														class="feather feather-credit-card mr-2">
                        <svg xmlns="http://www.w3.org/2000/svg"
															width="24" height="24" viewBox="0 0 24 24" fill="none"
															stroke="currentColor" stroke-width="2"
															stroke-linecap="round" stroke-linejoin="round"
															class="feather feather-refresh-cw mr-1">
                            <polyline points="23 4 23 10 17 10"></polyline>
                            <polyline points="1 20 1 14 7 14"></polyline>
                            <path
																d="M3.51 9a9 9 0 0 1 14.85-3.36L23 10M1 14l4.64 4.36A9 9 0 0 0 20.49 15"></path>
                        </svg>Update cart
											</button>
								</form>
							</div>
							</form>
							<form id="formElimina" method="GET"
								action="eliminaProdottoCarrello">
								<input type="hidden" id="idProdotto" name="idProdotto"
									value="${prodCar.idProdotto}"> <input type="hidden"
									id="tagliaProdotto" name="tagliaProdotto"
									value="${prodCar.tagliaProdotto}">
								<button type="submit" class="btn btn-sm btn-outline-info"
									style="float: left">
									<i class="icon-cog"></i>Elimina
								</button>
								<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
									viewBox="0 0 24 24" fill="none" stroke="currentColor"
									stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
									class="feather feather-trash-2 mr-1">
<polyline points="3 6 5 6 21 6"></polyline>
<path
										d="M19 6v14a2 2 0 0 1-2 2H7a2 2 0 0 1-2-2V6m3 0V4a2 2 0 0 1 2-2h4a2 2 0 0 1 2 2v2"></path>
<line x1="10" y1="11" x2="10" y2="17"></line>
<line x1="14" y1="11" x2="14" y2="17"></line>
</svg>
								</button>
							</form>
			</div>

		</div>
		</c:if>
		</c:forEach>
		</c:forEach>
	</div>
	<div class="col-2 cont">
		<h2 class="h6 py-2 bg" style="background-color: red">Totale</h2>
		<h2>${sommaProdotti}</h2>
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