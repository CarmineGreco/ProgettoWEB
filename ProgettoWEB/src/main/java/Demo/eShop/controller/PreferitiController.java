package Demo.eShop.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import Demo.eShop.model.Prodotto;
import Demo.eShop.persistance.DBManager;

@Controller
public class PreferitiController {

	@GetMapping("/PaginaPreferiti")
	public String vaiAllaPaginaProdotto(HttpSession session) {
		List<Prodotto> prodPreferiti=DBManager.getInstance().listaPreferitiDAO().getPreferiti(session.getAttribute("username").toString());
		session.setAttribute("prodPreferiti", prodPreferiti);
		return "Preferiti";
	}
	
}