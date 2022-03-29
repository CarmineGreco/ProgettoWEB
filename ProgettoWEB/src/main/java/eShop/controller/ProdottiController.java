package eShop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import eShop.model.Prodotto;
import eShop.persistance.DBManager;

@Controller
public class ProdottiController {
	
	@GetMapping("/PaginaProdotto")
	public String vaiAllaPaginaProdotto(HttpSession session, int idProdotto) {
		
		Prodotto prodotto = DBManager.getInstance().prodottoDAO().findByPrimaryKey(idProdotto);
		session.setAttribute("prodotto", prodotto);
		return "PaginaProdotto";
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
	
	/*@GetMapping("/Preferiti")
	public String vaiAiPreferiti(HttpSession session) {
		//mettere metodo per prendere i preferiti
		List<Prodotto> prodotti = DBManager.getInstance().prodottoDAO().findByTipology("borsa");
		session.setAttribute("prodotti", prodotti);
		
		return "Collezione";
	}*/
}
