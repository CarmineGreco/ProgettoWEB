package Demo.eShop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		session.setAttribute("sommaProdotti", DBManager.getInstance().carrelloDAO().sommaTotale(session.getAttribute("username").toString()));
		return "Carrello";
	}
	
	@GetMapping("/Pagamento")
	public String vaiAlPagamento(HttpSession session, @RequestParam float totale) {
		session.setAttribute("totale", totale);
		return "Pagamento";
	}

	@GetMapping("/aggiornaQuantita")
	public String aggiornaQuantita(HttpSession session, @RequestParam Integer idProdotto, @RequestParam float prezzo, @RequestParam Integer taglia, @RequestParam Integer quantita) {
		Carrello c=new Carrello();
		c.setIdProdotto(idProdotto);
		c.setPrezzo(prezzo);
		c.setQuantita(quantita);
		c.setTagliaProdotto(taglia);
		c.setUtente(session.getAttribute("username").toString());
		DBManager.getInstance().carrelloDAO().update(c);
		return "Carrello";
	}
	
	@GetMapping("/eliminaProdottoCarrello")
	public String eliminaCarrello(HttpSession session, @RequestParam Integer idProdotto, @RequestParam Integer tagliaProdotto) {
		Carrello c = new Carrello();
		c.setIdProdotto(idProdotto);
		c.setTagliaProdotto(tagliaProdotto);
		c.setUtente(session.getAttribute("username").toString());
		DBManager.getInstance().carrelloDAO().delete(c);
		return "redirect:/Carrello";
	}
}
