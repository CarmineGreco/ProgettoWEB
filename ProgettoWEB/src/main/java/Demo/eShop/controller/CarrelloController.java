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
		for (Prodotto p: prodotti) {
			for(Carrello c:prodCarrello) {
				if(c.getIdProdotto()==p.getId()) {
					int q=DBManager.getInstance().prodottoDAO().getQuantitaPerTaglia(p.getId(), c.getTagliaProdotto());
					session.setAttribute("quantita"+p.getId()+p.getTaglia(), q);
				}
			}
		}
		session.setAttribute("sommaProdotti", DBManager.getInstance().carrelloDAO().sommaTotale(session.getAttribute("username").toString()));
		return "Carrello";
	}
	
	@GetMapping("/Pagamento")
	public String vaiAlPagamento(HttpSession session, @RequestParam float totale) {
		session.setAttribute("totale", totale);
		return "Pagamento";
	}
	
	@GetMapping("/eliminaProdottoCarrello")
	public String eliminaCarrello(HttpSession session, @RequestParam Integer idP, @RequestParam Integer tagliaP) {
		Carrello c = new Carrello();
		c.setIdProdotto(idP);
		c.setTagliaProdotto(tagliaP);
		c.setUtente(session.getAttribute("username").toString());
		int quantCarr=DBManager.getInstance().carrelloDAO().getQuantita(session.getAttribute("username").toString(), idP, tagliaP);
		DBManager.getInstance().carrelloDAO().delete(c);
		int q=DBManager.getInstance().prodottoDAO().getQuantitaPerTaglia(idP, tagliaP);
		int q1=q+quantCarr;
		DBManager.getInstance().prodottoDAO().modificaQuantita(idP, tagliaP, q1);
		return "redirect:/VisualizzaCarrello";
	}
	

}
