<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
	<title>Profilo</title>

	<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"	rel="stylesheet" id="bootstrap-css">
	<link href="../css/Profilo.css" rel="stylesheet" type="text/css" id="bootstrap-css">
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="../js/modificaProfilo.js"></script>
	
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

	<div class="container">
		<div class="main-body">
			<div class="row centrale">
				<div class="col-4">
					<div class="card">
						<div class="card-body">
							<div class="d-flex flex-column align-items-center text-center">
								<img src="https://bootdey.com/img/Content/avatar/avatar6.png"
									alt="Admin" class="rounded-circle p-1 bg-primary" width="110">
								<div class="mt-3">
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="row centrale">
				<div class="col-8">
					<div class="card">
						<div class="card-body">
							<form method="post" action="#" id="modificaProfilo" >
	                        <div class="form-group">
	                           <label for="exampleInputEmail1">Username</label>
	                           <input type="text"  name="username" class="form-control" id="username" value= "${username}" aria-describedby="emailHelp" placeholder="Inserisci username" required>
	                        </div>
	                        <div class="form-group">
	                           <label for="exampleInputEmail1">Nome</label>
	                           <input type="text"  name="nome" class="form-control" id="nome" value="${nome}" aria-describedby="emailHelp" placeholder="Inserisci Nome" required>
	                        </div>
	                        <div class="form-group">
	                           <label for="exampleInputEmail1">Cognome</label>
	                           <input type="text"  name="cognome" class="form-control" id="cognome" value="${cognome}" aria-describedby="emailHelp" placeholder="Inserisci Cognome" required>
	                        </div>	                        
	                        <div class="form-group">
	                           <label for="exampleInputEmail1">Email</label>
	                           <input type="email" name="email"  class="form-control" id="email" value="${email}" aria-describedby="emailHelp" placeholder="Inserisci email" required>
	                        </div>
	                        <div class="form-group">
	                           <label for="exampleInputEmail1">Password</label>                         
	                        	<input type="password" name="password" id="password" value="${password}" class="form-control" aria-describedby="emailHelp" placeholder="Inserisci Password" required pattern="^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$" >
	                        	<p id="parametriPSW">Minimo otto caratteri, almeno una lettera maiuscola e un numero</p> 
	                        </div>
	                        <div class="col-md-12 text-center mb-3">
	                           <button type="submit" id="btModifica" class=" btn btn-block mybtn btn-primary tx-tfm">Iscriviti</button>                      
	                        </div>                        	                       
	                      </form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>