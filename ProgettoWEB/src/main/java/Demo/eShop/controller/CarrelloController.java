package Demo.eShop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import Demo.eShop.model.Carrello;
import Demo.eShop.model.Prodotto;
import Demo.eShop.persistance.DBManager;

@Controller
public class CarrelloController {

	@GetMapping("/Carrello")
	public String carrello(HttpSession session) {
		List<Prodotto> prodotti = DBManager.getInstance().carrelloDAO().getProdotti(session.getAttribute("username").toString());
		session.setAttribute("prodotti", prodotti);
		return "Carrello";
	}
	
}
