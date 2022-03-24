package eShop.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping("/Carrello")
	public String vaiAlCarrello() {
		return "Carrello";
	}
	
	@GetMapping("/Collezione")
	public String vaiAllaCollezione() {
		return "Collezione";
	}
	
	@GetMapping("/Profilo")
	public String vaiAlProfilo() {
		return "Profilo";
	}
	
	@GetMapping("/Preferiti")
	public String vaiAiPreferiti() {
		return "Preferiti";
	}

	@GetMapping("/ListaOrdini")
	public String vaiAllaListaOrdini() {
		return "ListaOrdini";
	}

	@GetMapping("/Login")
	public String vaiAlLogin() {
		return "Login";
	}
}
