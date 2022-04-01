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
public class ProdottiController {
	
	@GetMapping("/PaginaProdotto")
	public String vaiAllaPaginaProdotto(HttpSession session, @RequestParam Integer idProdotto) {

		Prodotto prodotto = DBManager.getInstance().prodottoDAO().findByPrimaryKey(idProdotto);
		session.setAttribute("prodotto", prodotto);
		List<Prodotto> prod=DBManager.getInstance().listaPreferitiDAO().getPreferiti(session.getAttribute("username").toString());
		boolean trovato=false;
		for(Prodotto p:prod) {
			if(p.getId()==prodotto.getId()) {
				session.setAttribute("prodPreferito", "OK");
				trovato=true;
			}
		}
		if(!trovato) {
			session.removeAttribute("prodPreferito");
		}
		return "PaginaProdotto";
	}
	
	@PostMapping("/AggiungiPreferiti")
	public String aggiungiAiPreferiti(HttpSession session, @RequestParam Integer idProdotto) {
		DBManager.getInstance().listaPreferitiDAO().savePreferito(session.getAttribute("username").toString(), idProdotto);
		return "redirect:/PaginaProdotto?idProdotto="+idProdotto;
	}
	@PostMapping("/RimuoviPreferiti")
	public String rimuoviDaiPreferiti(HttpSession session, @RequestParam Integer idProdotto) {
		DBManager.getInstance().listaPreferitiDAO().deletePreferito(session.getAttribute("username").toString(), idProdotto);
		return "redirect:/PaginaProdotto?idProdotto="+idProdotto;
	}
	
	
	@GetMapping("/CollezioneMaglia")
	public String vaiAllaCollezioneMaglia(HttpSession session) {
		
		List<Prodotto> prodotti = DBManager.getInstance().prodottoDAO().findByTipology("maglia");
		session.setAttribute("prodotti", prodotti);
		
		return "Collezione";
	}
	
	@GetMapping("/CollezioneVestiti")
	public String vaiAllaCollezioneVestiti(HttpSession session) {
		
		List<Prodotto> prodotti = DBManager.getInstance().prodottoDAO().findByTipology("vestito");
		session.setAttribute("prodotti", prodotti);
		
		return "Collezione";
	}
	
	
	@GetMapping("/CollezionePantaloni")
	public String vaiAllaCollezionePantaloni(HttpSession session) {
		
		List<Prodotto> prodotti = DBManager.getInstance().prodottoDAO().findByTipology("pantaloni");
		session.setAttribute("prodotti", prodotti);
		
		return "Collezione";
	}
	@GetMapping("/CollezioneFelpe")
	public String vaiAllaCollezioneFelpe(HttpSession session) {
		
		List<Prodotto> prodotti = DBManager.getInstance().prodottoDAO().findByTipology("felpe");
		session.setAttribute("prodotti", prodotti);
		
		return "Collezione";
	}
	
	@GetMapping("/CollezioneCamicie")
	public String vaiAllaCollezioneCamicie(HttpSession session) {
		
		List<Prodotto> prodotti = DBManager.getInstance().prodottoDAO().findByTipology("camicia");
		session.setAttribute("prodotti", prodotti);
		
		return "Collezione";
	}
	
	@GetMapping("/CollezioneBorse")
	public String vaiAllaCollezioneBorse(HttpSession session) {
		
		List<Prodotto> prodotti = DBManager.getInstance().prodottoDAO().findByTipology("borsa");
		session.setAttribute("prodotti", prodotti);
		
		return "Collezione";
	}
	
	@PostMapping("/aggiungiCarrello")
	public String aggiungiAlCarrello(HttpSession session, @RequestParam Integer taglia, @RequestParam Integer idProdotto, @RequestParam Integer quantita) {
		Carrello c = new Carrello();		
		c.setIdProdotto(idProdotto);
		c.setQuantita(quantita);
		c.setUtente(session.getAttribute("username").toString());
		c.setTagliaProdotto(taglia);
		DBManager.getInstance().carrelloDAO().save(c);
		
		session.setAttribute("carrello", c);
		return "PaginaProdotto";
	}
}
