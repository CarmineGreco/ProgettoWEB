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
</body>
</html>