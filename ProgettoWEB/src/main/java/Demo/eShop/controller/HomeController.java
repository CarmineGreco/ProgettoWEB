package Demo.eShop.controller;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping("/navbar")
	public String navbar() {
		return "Navbar";
	}
	
	@GetMapping("/sidebar")
	public String sidebar() {
		return "Sidebar";
	}
	
	@GetMapping("/Carrello")
	public String vaiAlCarrello() {
		return "Carrello";
	}
	
	
	@GetMapping("/Profilo")
	public String vaiAlProfilo() {
		return "Profilo";
	}
	
	@GetMapping("/Preferiti")
	public String vaiAiPreferiti() {
		return "Preferiti";
	}

	@GetMapping("/Login")
	public String vaiAlLogin() {
		return "Login";
	}
	

	@GetMapping("/Registrazione")
	public String vaiAllaRegistrazione() {
		return "Registrazione";
	}
	
	@GetMapping("/Logout")
	public String logout(HttpSession s) {
		s.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/PaginaAdmin")
	public String vaiAllaPaginaAdmin() {
		return "PaginaAdmin";
	}
}
