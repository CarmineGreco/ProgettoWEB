//alert("Sono nel file javascript!!");
window.addEventListener("load", function(){ //"load"-->al caricamento della pagina inizializziamo il form per effettuare login e sign up

	checklogin();
	$("#second").fadeOut("fast", function() {
			$("#first").fadeIn("fast");
			modalLogin=true;
		});
	
});

var modalLogin=true;

function  checklogin(){
	 

	$("#registrati").click(function() {	
		$("#first").fadeOut("fast", function() {
			$("#second").fadeIn("fast");
			modalLogin=false;
		});
	});
	
	$("#accedi").click(function() {
		$("#second").fadeOut("fast", function() {
			$("#first").fadeIn("fast");
			modalLogin=true;
		});
	});
}


function Utente (username, password, admin, email, nome, cognome){
	this.username=username;
	this.admin=admin;
	this.password=password;
	this.email=email;
	this.nome=nome;
	this.cognome=cognome;
}



$(document).ready(function(){ 
	
	var Login = document.getElementById("loginForm");
		document.getElementById("btnLogin").addEventListener("submit", function () {
 	 	Login.submit();
	});
	
	var Registrazione = document.getElementById("formRegistrazione");
		document.getElementById("btnIscriviti").addEventListener("submit", function () {
 	 	Registrazione.submit();
	});
	
	var recupPassword = document.getElementById("recuperoPassword");
		document.getElementById("btnRecuperoPassword").addEventListener("submit", function () {
 	 	recupPassword.submit();
	});
	

	
	$("#loginForm").on("submit", function(e){
		
		if(modalLogin){
			e.preventDefault();
			var username1 = document.getElementById("usernameLogin").value;
			var password1 = document.getElementById("passwordLogin").value;
			
			var utente1;
			
			if(username1=="admin"){
				var utente1= new Utente(username1,password1,true,null,null,null);
			}else{
				var utente1= new Utente(username1,password1,false,null,null,null);
			}
		
			$.ajax({
					  url: "loginService",  
			          method: "POST",	         
			          data: JSON.stringify(utente1),	       
			          contentType: "application/json",	         
			          success: function(risposta){				  									
						if(risposta=="successo"){
							location.reload();
						}					
						if(risposta=="errore"){
							$('#showErrorLogin').modal('show');						
						}
						if (risposta=="nonRegistrato"){
							$('#showNonRegistrato').modal('show');						
						}									
			          },	            	  
			    });	
		}
	});


	$("#formRegistrazione").on("submit", function(e){

		e.preventDefault();		
		var nome = document.getElementById("nome").value;
		var cognome = document.getElementById("cognome").value;
		var username2 = document.getElementById("username").value;
		var email = document.getElementById("email").value;
		var password2 = document.getElementById("password").value;
		var utente2= new Utente(username2,password2,false,email,nome,cognome);
		alert(username2+"  "+password2+" "+email+" "+nome+" "+cognome);
		$.ajax({
				  url: "registrationService",  
		          method: "POST",	         
		          data: JSON.stringify(utente2),	       
		          contentType: "application/json",	         
		          success: function(risposta){				  									
					if(risposta=="successo"){
						location.reload();
					}					
					if(risposta=="errore"){
						$('#showErrorRegistrazione').modal('show');						
					}									
		          },	            	  
		    });	
	});
	
	
//	$("#recuperoPassword").on("submit", function(e){
//		
//		$("#btnRecuperoPassword").prop("disabled", true);
//		$("#btnRecuperoPassword").html(`<span class="spinner-border spinner-border-sm" role="status" aria-hidden="true"></span> Loading...`);  
//
//		e.preventDefault();			
//		var email3 = document.getElementById("emailRecupero").value;
//		var utente3= new Utente(email3,null,null,null,null,null,null);
//		$.ajax({
//				  url: "RecuperoPassword",  
//		          method: "POST",	         
//		          data: JSON.stringify(utente3),	       
//		          contentType: "application/json",	         
//		          success: function(risposta){				  									
//					if(risposta=="success"){
//						$("#btnRecuperoPassword").prop("disabled", false);
//						$("#btnStartUploads i").removeAttr('class');						
//						$("#btnStartUploads i").addClass('class="btn btn-sm btn-outline-info"');
//						 $("#btnRecuperoPassword").html(`recupera`);
//						$('#invioNuovaPassword').modal('show');	
//					}														
//		          },	            	  
//		    });	
//	});	
//	
//	$("#chiudi").on("click", function(e){
//		$('#recuperaPassword').modal('hide');	
//	});
//	
	
});
