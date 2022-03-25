var profile;

function accessoGoogle(googleUser){
   
		  profile = googleUser.getBasicProfile();	
}

 
function logoutSocial(){
	gapi.auth2.getAuthInstance().signOut().then(function(){
		console.log('user logout')
	})
}

function Utente (username, password, email, nome, cognome,){
	this.username=username;
	this.password=password;
	this.email=email;
	this.nome=nome;
	this.cognome=cognome;
}


function ricarica(){
    
    var username = profile.getGivenUsername();
    var nome= profile.getGivenName();
    var cognome= profile.getFamilyName();
    var email= profile.getEmail();
	
	var utente= new Utente(username, email, nome, cognome);
	
	$.ajax({
			  url: "loginSocial",  
	          method: "POST",	          
	          data: JSON.stringify(utente),	          
	          contentType: "application/json",	          
	          success: function(risposta){
	         	if(risposta=="success"){
					location.reload();
				}									        	          
			  },	          
	          fail: function( jqXHR, textStatus ) {
	  			alert( "Request failed: " + textStatus );
	          }        
	    });	

}
