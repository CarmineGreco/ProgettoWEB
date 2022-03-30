package Demo.eShop.controller;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavbarController {
	
	@GetMapping("/index")	//Metodo che intercetta un href su index e carica la pagina
	public String getHome(HttpSession session, Model model) {
		
		return "index";
	}

}
