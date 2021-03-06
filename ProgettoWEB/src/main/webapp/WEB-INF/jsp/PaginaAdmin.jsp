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
<title>PaginaAdmin</title>
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

	<div class="container2">
		<div class="row">
			<div class="col-7 col-3">
				<h2>Prodotti</h2>
				<!-- Item-->
					<c:forEach items="${prodAdmin}" var="prod">
							<div
								class="d-sm-flex justify-content-between my-4 pb-4 border-bottom">
								<div class="media d-block d-sm-flex text-center text-sm-left">
									<a class="cart-item-thumb mx-auto mr-sm-4" href="#"><img
										src="${prod.img}" alt="Product"></a>
									<div class="media-body pt-3">
										<form id="formSetContenuto" method="GET"
											action="ModificaProdottoAdmin">
											<input type="hidden" id="idProdotto" name="idProdotto"
												value="${prod.id}">
											<a>Nome</a><input type="text" id="nome" name="nome" value=" ${prod.nome}">
											
											
								           <p>  </p>
										
										
										<div class="font-size-sm">
											<a>Taglia</a><input type="text" id="taglia" name="taglia" value="${prod.taglia}" readonly>
										</div>
										
										 <p>  </p>
										<a>Prezzo</a><input type="number" id="prezzo" name="prezzo" value="${prod.prezzo}">
									</div>
								</div>
									<div
										class="pt-2 pt-sm-0 pl-sm-3 mx-auto mx-sm-0 text-center text-sm-left"
										style="max-width: 10rem;">
										<div class="form-group mb-2">
											<label for="quantity1">Quantit?</label>
											
											
											
											<input type="number" id="qntProd" name="qntProd" value="${prod.quantita}"> 
											
											 <p>  </p>
											 <label for="quantity1">Aggiorna quantit?</label>
											<button type="submit" class="btn btn-sm btn-outline-info"
												 id="relative">
												
												
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
                        </svg>Modifica prodotto
											</button>
								</form>
							</div>
			</div>

		</div>
		</c:forEach>
	</div>
	</div>
	</div>