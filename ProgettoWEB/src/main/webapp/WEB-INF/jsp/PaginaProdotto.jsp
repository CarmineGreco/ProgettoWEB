<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link href="../css/PaginaProdotto.css" rel="stylesheet" type="text/css"
	/ id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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

	

<main class="container">
 <c:forEach items="${prodotti}" var="prod">
  <!-- Left Column / Headphones Image -->
  <div class="left-column">
    <img data-image="black" src="images/black.png" alt="">
    <img data-image="blue" src="images/blue.png" alt="">
    <img data-image="red" class="active" src="images/red.png" alt="">
  </div>
 
 
  <!-- Right Column -->
  <div class="right-column">
 
<!--     Product Description -->
     <div class="product-description"> 
       <span>Headphones</span>
       <h1>${prod.nome}</h1> 
       <p>${prod.descrizione}</p>
     </div> 
 
<!--     Product Configuration -->
     <div class="product-configuration"> 
 
<!--       Product Color -->
       <div class="product-color"> 
         <span>Aggiungi ai Preferiti</span> 
 
         <div class="color-choose"> 
           <div> 
             <input data-image="red" type="radio" id="red" name="color" value="red" checked>
             <label for="red"><span></span></label>
           </div> 
          
 
       </div> 
 
<!--       Cable Configuration -->
       <div class="cable-config"> 
         <span>Seleziona una taglia</span> 
 
         <div class="cable-choose"> 
           <button>S</button> 
           <button>M</button> 
           <button>L</button> 
         </div> 
 
        
       </div> 
     </div> 
 
<!--     Product Pricing -->
     <div class="product-price"> 
       <span>${prod.prezzo}€</span> 
       <a href="#" class="cart-btn">Aggiungi al carrello</a>
     </div> 
   </div> 
</c:forEach>

	<table>
<!--		<thead>
			<tr>
				<th>Prezzo</th>
				<th>Nome</th>
				<th>taglia</th>
				<th>Descrizione</th>
				<th>Categoria</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${prodotti}" var="prod">
				<tr>
					<td>${prod.prezzo}</td>
					<td>${prod.nome}</td>
					<td>${prod.taglia}</td>
					<td>${prod.descrizione}</td>
					<td>${prod.categoria}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	  -->
</main>
</body>
</html>