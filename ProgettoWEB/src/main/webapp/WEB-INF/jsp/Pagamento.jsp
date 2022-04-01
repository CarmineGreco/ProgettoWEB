
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link href="css/pag2.css" rel="stylesheet" type="text/css"
	/ id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pagamento</title>
    <script src="https://www.paypal.com/sdk/js?currency=EUR&client-id=AVTpbeGQa7-4WbeK2p0TPATh3T5rsoavzqsYM49CHKLYbJ0xD6B5krktKyLHMRTM_LbJ77mRUSqplmF7"></script>
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
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
    <div class="wrapper">
        <h2>Pagamento</h2>
        <form action="" method="post">
            <!--Account Information Start-->
            <h4>Account</h4>
            <div class="input_group">
                <div class="input_box">
                    <input type="text" placeholder="Nome completo" required class="name">
                    <i class="fa fa-user icon"></i>
                </div>
                <div class="input_box">
                    <input type="text" placeholder="Nome sulla carta" required class="name">
                    <i class="fa fa-user icon"></i>
                </div>
            </div>
            <div class="input_group">
                <div class="input_box">
                    <input type="email" placeholder="Email" required class="name">
                    <i class="fa fa-envelope icon"></i>
                </div>
            </div>
            <div class="input_group">
                <div class="input_box">
                    <input type="text" placeholder="Indirizzo" required class="name">
                    <i class="fa fa-map-marker icon" aria-hidden="true"></i>
                </div>
            </div>
            <div class="input_group">
                <div class="input_box">
                    <input type="text" placeholder="Città" required class="name">
                    <i class="fa fa-institution icon"></i>
                </div>
            </div>
            <!--Account Information End-->


            <!--DOB & Gender Start-->
            <div class="input_group">
                <div class="input_box">
                    <h4>Data di nascita</h4>
                    <input type="text" placeholder="DD" required class="dob">
                    <input type="text" placeholder="MM" required class="dob">
                    <input type="text" placeholder="YYYY" required class="dob">
                </div>
                <div class="input_box">
                    <h4>Gender</h4>
                    <input type="radio" name="gender" class="radio" id="b1" checked>
                    <label for="b1">Uomo</label>
                    <input type="radio" name="gender" class="radio" id="b2">
                    <label for="b2">Donna</label>
                </div>
            </div>
            <!--DOB & Gender End-->


            <!--Payment Details Start-->
            <div class="input_group">
                <div class="input_box">
                    <h4>Dettagli pagamento</h4>
                    
                    
                            
                    
                  
                           
                </div>
            </div>
            <div class="input_group">
                <div class="input_box">
                    <input type="tel" name="" class="name" placeholder="Numero carta" required>
                    <i class="fa fa-credit-card icon"></i>
                </div>
            </div>
            <div class="input_group">
                <div class="input_box">
                    <input type="tel" name="" class="name" placeholder="CVC" required>
                    <i class="fa fa-user icon"></i>
                </div>
            </div>
            <div class="input_group">
                <div class="input_box">
                    <div class="input_box">
                        <input type="number" placeholder="Mese di scadenza" required class="name">
                        <i class="fa fa-calendar icon" aria-hidden="true"></i>
                    </div>
                </div>
                <div class="input_box">
                    <input type="number" placeholder="Anno di scadenza" required class="name">
                    <i class="fa fa-calendar-o icon" aria-hidden="true"></i>
                </div>
            </div>
            
            <!--Payment Details End-->


			<div style="background-color: green; display: none" id="transition">GRAZIE PER IL TUO PAGAMENTO</div>
    <input type="text" id="payInput" /><button onClick="generatePayment(document.getElementById('payInput').value)">paga</button>
	<div id="paypal-button-container"></div>
	
	<script>
	function generatePayment(value){
		if(value==""){
			alert("NESSUN IMPORTO");
			return;
		}
		
		paypal.Buttons({
			createOrder: function(data, actions){
				return actions.order.create({
					purchase_units: [{
						amount: {
							value: value
					}
				}]
			});
		},
	onApprove: function(data, actions){
		return actions.order.capture().then(function(details) {
			document.getElementById("transition").style.display= "block"; 
		});
	   }
	}).render('#paypal-button-container');
   }
	</script>
           
        </form>
        
        
        
    </div>
    
    
	
	
</body>

</html>
        