window.addEventListener("load", function(){ //"load"-->al caricamento della pagina inizializziamo il form per effettuare login e sign up
	checklogin();
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


function Utente (username, password, email, nome, cognome){
	
	this.username=username;
	this.password=password;
	this.email=email;
	this.nome=nome;
	this.cognome=cognome;
}

$(document).ready(function(){ 
	
	var Login = document.getElementById("loginForm");
		document.getElementById("user").addEventListener("submit", function () {
 	 	Login.submit();
	});
	

	
	$("#loginForm").on("submit", function(e){
		
		if(modalLogin){
			e.preventDefault();
			var email1 = document.getElementById("username").value;
			var password1 = document.getElementById("password").value;
			
			var utente1= new Utente(email1,password1, null, null, null);
		
			$.ajax({
					  url: "Serviziologin",  
			          method: "POST",	         
			          data: JSON.stringify(utente1),	       
			          contentType: "application/json",	         
			          success: function(risposta){				  									
						if(risposta=="success"){
							location.reload();
						}					
						if(risposta=="error"){
							$('#showErrorLogin').modal('show');						
						}								
			          },	            	  
			    });	
		}
	});
});