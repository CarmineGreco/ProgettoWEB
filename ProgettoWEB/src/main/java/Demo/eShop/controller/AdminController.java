package Demo.eShop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import Demo.eShop.model.Prodotto;
import Demo.eShop.persistance.DBManager;

@Controller
public class AdminController {
	
	@GetMapping("/PaginaAmministratore")
	public String vaiAllaPaginaAmministratore(HttpSession session) {
		List<Prodotto> p =DBManager.getInstance().prodottoDAO().findAll();
		session.setAttribute("prodAdmin", p);
		return "PaginaAdmin";
	}
	
	@GetMapping("/ModificaProdottoAdmin")
	public String modificaProdotto(HttpSession session) {
		List<Prodotto> p =DBManager.getInstance().prodottoDAO().findAll();
		session.setAttribute("prodAdmin", p);
		return "PaginaAdmin";
	}
}
