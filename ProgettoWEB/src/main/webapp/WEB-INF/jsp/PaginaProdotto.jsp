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
  <!-- Left Column / Headphones Image -->
  <div class="left-column">
    <img data-image="red" class="active" src="${prodotto.img}" width="300" height="500" align="left">
  </div>
 
 
  <!-- Right Column -->
  <div class="right-column">
 
<!--     Product Description -->
     <div class="product-description"> 
       <h1>${prodotto.nome}</h1> 
       <p>${prodotto.descrizione}</p>
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
       <span>${prodotto.prezzo}€</span> 
       <a href="#" class="cart-btn">Aggiungi al carrello</a>
     </div> 
   </div> 
</main>
</body>
</html>