<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/js/v4-shims.min.js">
	<link rel="stylesheet"href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"crossorigin="anonymous">
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	
	
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	
	<!-- EMAIL -->
	<script src="https://smtpjs.com/v3/smtp.js"></script>
	<script src="../js/index.js"></script>
	
	<!-- 	file javascript -->
	<script src="/js/login.js"></script>  
  	<script src="./js/tornaSu.js"></script>
	
	<link rel="stylesheet" href="/css/Navbar.css">
	
	<style>
	.w3-sidebar a {
		font-family: "Roboto", sans-serif
	}
	
	body, h1, h2, h3, h4, h5, h6, .w3-wide {
		font-family: "Montserrat", sans-serif;
	}
	
	</style>
</head>
<body>
	<div id="search-bar"></div>
	<!-- Top header -->
	<header class="row" style="background:#e9e4e2 ">
		<!--  <img class="col-3" src="img/Logo.jpg" height="150" width="300" /> -->
		<div class="col-5" style="sfondo">
			<div id="contenitore_logo">
			 	<a id="logo" href="index" >
			 		<span class="col-3" style="font-size: 24px;">CARLA<br>FERRONI<br>REGGIO<br>CALABRIA </span>
			 	</a>
			 	
			</div>
		</div>
		<div class="col-5">
			<div class="mx-auto order-0">
				<div class="form-inline my-lg-0">
					<div class="input-group ">
						<input class="form-control mr-sm-1"  type="search" placeholder="Cerca"
							aria-label="Cerca" required>
						<div class="input-group-append">
							<button type="submit" class="btn btn-light"><i class="fa fa-search w3-margin-right"
								style="font-size: x-large"></i></button>
						</div>
					</div>
				</div>
			</div>
			</div>
			<div class="col-2" style="float: right">
				<div class="dropdown w3-right" style="background:#e9e4e2">
						<c:if test="${username == null}">  <!--  se non c'è un username loggato mostrami il login -->
			    			<i class="loginIcon fa fa-user-circle" style="font-size:36px"  data-toggle="modal" data-target="#loginForm" ></i>  <!-- icona login  -->   
			    		</c:if>
						<c:if test="${username != null}">
							<i class="loginIcon fa fa-user-circle" style="font-size:36px" ></i>  <!-- icona login  -->   
							<div class="dropdown-content" style="float: right;">
								<a id="text" href="VisualizzaCarrello">Carrello</a>
								<a id="text" href="Profilo">Profilo</a>
								<a id="text" href="PaginaPreferiti">Preferiti</a>
								<a id="text" href="ListaOrdini">I tuoi ordini</a>
								<a id="text" href="Logout">Logout</a>
							</div>
						</c:if>
					</div>
				</div>
			</div>
			
			
			
			
			
	 <!-- LOGIN -->
	 <div class="modal fade" id="loginForm">
	    <div class="modal-dialog">
	      <div class="modal-content">
              
	        <!-- Modal body -->
	        <div class="modal-body">
	         	
	         	<div id="first">
					<div class="myform form ">
						 <div class="logo mb-3">
							 <div class="col-md-12 text-center">
								<button type="button" class="close" data-dismiss="modal">×</button>
								<h1 class="titolo-loginForm">Login</h1>
							 </div>
						</div>
	                   <form method="post" action="#" id="loginForm">           
	                           <div class="form-group ">
	                              <label for="exampleInputEmail1">Username</label>
	                              <input type="text" name="usernameLogin"  class="form-control"  id="usernameLogin" aria-describedby="emailHelp" placeholder="Inserisci username"  required>
	                           </div>
	                           <div class="form-group">
	                              <label for="exampleInputEmail1">Password</label>
	                              <input type="password" name="passwordLogin" id="passwordLogin"  class="form-control" aria-describedby="emailHelp" placeholder="Inserisci Password" required>
	                           </div>
	                           <div class="form-group">
	                              <p class="text-center">Registrandoti accetti i nostri<button style="box-shadow: none;" id="btnMostraTermini" type="button" class="btn btn-link" data-toggle="modal" data-target="#apriTermini">Termini e Condizioni d'uso</button></p>
	                           </div>
	                           <div class="col-md-12 text-center ">
	                              <button type="submit" id="btnLogin" class=" btn btn-block mybtn btn-primary tx-tfm">Login</button>
	                           </div>
	                           <div class="col-md-12 ">
	                              <div class="login-or">
	                                 <hr class="hr-or">
	                                 <span class="span-or">oppure</span>
	                              </div>
	                           </div>
	                           </form>	 
	                            <div class="row" >								
	                                 <div style="padding-left:15%" class="g-signin2" id="logginGoogle" data-onsuccess="accessoGoogle" onclick="ricarica()" ></div>
	                           		<button style="margin-left:5%" onclick="accessofacebook()" class="loginBtn loginBtn--facebook" > Login con Facebook </button>
	                           </div>
	                           <br>
	                           <div class="form-group">
	                              <p class="text-center">Non hai un account? <a href="#" id="registrati">Registrati qui</a></p>
	                              <p class="text-center"> <button type="button" class="btn btn-sm btn-outline-success"  data-toggle="modal" data-target="#recuperaPassword" > Ho dimenticato la password  </button></p>
	                           </div>
           
					</div>
				</div>
				
			 	<div id="second">
			      <div class="myform form ">
                     <div class="logo mb-3">
                        <div class="col-md-12 text-center">
                           <button type="button" class="close" data-dismiss="modal">×</button>
                           <h1 class="titolo-loginForm">Registrati</h1>
                        </div>
                     </div>                        
                     <form method="post" action="#" id="formRegistrazione" >
                        <div class="form-group">
                           <label for="exampleInputEmail1">Nome</label>
                           <input type="text"  name="nome" class="form-control" id="nome" aria-describedby="emailHelp" placeholder="Inserisci Nome" required>
                        </div>
                        <div class="form-group">
                           <label for="exampleInputEmail1">Cognome</label>
                           <input type="text"  name="cognome" class="form-control" id="cognome" aria-describedby="emailHelp" placeholder="Inserisci Cognome" required>
                        </div>
                        <div class="form-group">
                           <label for="exampleInputEmail1">Username</label>
                           <input type="text"  name="username" class="form-control" id="username" aria-describedby="emailHelp" placeholder="Inserisci username" required>
                        </div>
                        <div class="form-group">
                           <label for="exampleInputEmail1">Email</label>
                           <input type="email" name="email"  class="form-control" id="email" aria-describedby="emailHelp" placeholder="Inserisci email" required>
                        </div>
                        <div class="form-group">
                           <label for="exampleInputEmail1">Password</label>                         
                        	<input type="password" name="password" id="password"  class="form-control" aria-describedby="emailHelp" placeholder="Inserisci Password" required pattern="^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$" >
                        	<p id="parametriPSW">Minimo otto caratteri, almeno una lettera maiuscola e un numero</p> 
                        </div>
                        <div class="col-md-12 text-center mb-3">
                           <button type="submit" id="btnIscriviti" class=" btn btn-block mybtn btn-primary tx-tfm">Iscriviti</button>                      
                        </div>                        
                        <div class="col-md-12 ">
                           <div class="form-group">
                              <p class="text-center"><a href="#" id="accedi">Hai gia' un account?</a></p>
                           </div>
                        </div>
                      </form>
           		   </div>
                </div>
			</div>
         </div>
      </div>
    </div>

	<button id="myBtn" title="Go to top">Top</button>
	 
	
	 <div class="modal fade" id="showErrorLogin">
	    <div class="modal-dialog">
	      <div class="modal-content">	            
	        <!-- Modal body -->
	        <div class="modal-body">	
				<div class="myform form ">
					<div class="logo mb-3">
						 <div class="col-md-12 text-center">
							<button type="button" class="close" data-dismiss="modal">×</button>
							 <br> <br>
							<h3>Password o Username errati</h3>
							 <br>
						 </div>
					</div>	                   	               
				</div>
			  </div>
			</div>
	     </div>
	 </div>  
	 
	 
	 <div class="modal fade" id="showErrorRegistrazione">
	    <div class="modal-dialog">
	      <div class="modal-content">	            
	        <!-- Modal body -->
	        <div class="modal-body">	
				<div class="myform form ">
					<div class="logo mb-3">
						 <div class="col-md-12 text-center">
							<button type="button" class="close" data-dismiss="modal">×</button>
							 <br> <br>
							<h3>email o username già in uso da un altro account</h3>
							 <br>
						 </div>
					</div>	                   	               
				</div>
			  </div>
			</div>
	     </div>
	 </div>  
	 
	 <div class="modal fade" id="showNonRegistrato">
	    <div class="modal-dialog">
	      <div class="modal-content">	            
	        <!-- Modal body -->
	        <div class="modal-body">	
				<div class="myform form ">
					<div class="logo mb-3">
						 <div class="col-md-12 text-center">
							<button type="button" class="close" data-dismiss="modal">×</button>
							 <br> <br>
							<h3>Non è stato trovato alcun utente con queste credenziali.</h3>
							 <br>
						 </div>
					</div>	                   	               
				</div>
			  </div>
			</div>
	     </div>
	 </div>
	 
	 
	  <div class="modal fade" id="recuperaPassword">
	    <div class="modal-dialog">
	      <div class="modal-content">	            
	        <!-- Modal body -->
	        <div class="modal-body">	
				<div class="myform form ">
					<div class="logo mb-3">
						 <div class="col-md-12 text-center">
							<button type="button" class="close" data-dismiss="modal">×</button>
							 <br> <br>
								<form id="recuperoPassword" action="#">
				                     <h4>inserisci la tua email per recuperare la password</h4> <br>
				                     <input style="font-size: 20px;" type="email" id="emailRecupero" name="emailrecupero" required><br><br>           
				                     <button type="submit" id="btnRecuperoPassword" class="btn btn-sm btn-outline-info" style="float:right"> recupera</button> 
				                 </form>
							 <br>
						 </div>
					</div>	                   	               
				</div>
			  </div>
			</div>
	     </div>
	 </div>  
	 
	 <div class="modal fade" id="invioNuovaPassword">
	    <div class="modal-dialog">
	      <div class="modal-content">	            
	        <!-- Modal body -->
	        <div class="modal-body">	
				<div class="myform form ">
					<div class="logo mb-3">
						 <div class="col-md-12 text-center">
							<button id="chiudi" type="button" class="close" data-dismiss="modal">×</button>
							 <br>							
				               <p>se la tua email è presente sul sistema ti è stata inviata una nuova password, controlla tra la posta in arrivo :)<p> 					              		                 
							 <br>
						 </div>
					</div>	                   	               
				</div>
			  </div>
			</div>
	     </div>
	 </div>  
	 
	 <div class="modal fade" id="apriTermini">
	    <div class="modal-dialog">
	      <div class="modal-content">
	             
			<!--  Modal body -->
	        <div class="modal-body">
	
				<div class="myform form ">
					<div class="logo mb-3">
						 <div class="col-md-12 text-center">
							<button type="button" class="close" data-dismiss="modal">×</button>
							 <br> <br>
							<h3 class="titolo-loginForm">Termini e Condizioni di utilizzo</h3>
							 <br>
						 </div>
					</div>
	                  <div class="row" style="padding: 10px 10px 10px">
		                  <p> Registrandoti al sito web Device Is It decidi di accettare i termini e le condizioni di utilizzo.</p><br>
		                  <p> Gli amministratori del sito avranno accesso a dati sensibili riguardanti il tuo profilo (ad esclusione della password, inserita al momento della registrazione) e potranno decidere 
		                  		di disattivarlo nel caso si ritenesse che tu abbia violato le regole di utilizzo. 
		                  		In particolare, è SEVERAMENTE VIETATO:</p>
		                  		<ul> 
		                  			<li> Ledere o danneggiare la sensibilità di altri utenti.</li>
		                  			<li> Utilizzare e divulgare impropriamente il materiale presente sul sito web per scopi personali.</li>
		                  		</ul>
					   </div>   	               
				   </div>
			   </div>
		   </div>
	     </div>
	 </div>
			
			
			
			
			
			
	</header>
	<!-- Top menu on small screens -->
	<header class="w3-bar w3-w3-top w3-hide-large w3-xlarge" style="background:#e9e4e2">
		<a href="javascript:void(0)"
			class="w3-bar-item w3-button w3-padding-24 w3-right" style="background:#e9e4e2"
			onclick="w3_open()"><i class="fa fa-bars"></i></a>
	</header>

</body>
</html>