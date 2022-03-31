
function Utente (username, password, admin, email, nome, cognome){
	this.username=username;
	this.admin=admin;
	this.password=password;
	this.email=email;
	this.nome=nome;
	this.cognome=cognome;
}

$(document).ready(function(){
	
	$("#modificaProfilo").on("submit", function(e){

		e.preventDefault();		
		var nome = document.getElementById("nome").value;
		var cognome = document.getElementById("cognome").value;
		var username = document.getElementById("username").value;
		var email = document.getElementById("email").value;
		var password = document.getElementById("pass").value;
		var utente = new Utente(username ,password, false, email, nome, cognome);
		$.ajax({
				  url: "modificaProfilo",  
		          method: "POST",	         
		          data: JSON.stringify(utente),	       
		          contentType: "application/json",	         
		          success: function(risposta){				  									
					if(risposta=="successo"){
						location.reload();
					}													
		          },	            	  
		    });	
	});
})
