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

	@GetMapping("/VisualizzaCarrello")
	public String carrello(HttpSession session) {
		System.out.println(session.getAttribute("username").toString());
		List<Prodotto> prodotti = DBManager.getInstance().carrelloDAO().getProdotti(session.getAttribute("username").toString());
		session.setAttribute("prodotti", prodotti);
		List<Carrello> prodCarrello=DBManager.getInstance().carrelloDAO().getCarrelliUtente(session.getAttribute("username").toString());
		session.setAttribute("prodCarrello", prodCarrello);
		return "Carrello";
	}
	
}
