function Utente (username, password, admin, email, nome, cognome){
	this.username=username;
	this.admin=admin;
	this.password=password;
	this.email=email;
	this.nome=nome;
	this.cognome=cognome;
}

$(document).ready(function(){
	var form = document.getElementById("modificaProfilo");
		document.getElementById("btnModifica").addEventListener("submit", function () {
 	 	form.submit();
	});
	
	$("#modificaProfilo").on("submit", function(e){
		alert("Bottone premuto");
		e.preventDefault();		
		var nome = document.getElementById("nome").value;
		alert(nome);
		var cognome = document.getElementById("cognome").value;
		alert(cognome);
		var username = document.getElementById("username").value;
		alert(username);
		var email = document.getElementById("email").value;
		alert(email)
		var password = document.getElementById("password").value;
		alert(password);
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
