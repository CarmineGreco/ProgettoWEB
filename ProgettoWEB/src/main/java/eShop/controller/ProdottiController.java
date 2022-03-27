package eShop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import eShop.model.Prodotto;
import eShop.persistance.DBManager;

@Controller
public class ProdottiController {
	
	@GetMapping("/PaginaProdotto")
	public String vaiAllaPaginaProdotto(HttpSession session) {
		
		List<Prodotto> prodotti = DBManager.getInstance().prodottoDAO().findAll();
		session.setAttribute("prodotti", prodotti);
		
		return "PaginaProdotto";
	}
	
	@GetMapping("/CollezioneMaglia")
	public String vaiAllaCollezioneMaglia(HttpSession session) {
		
		List<Prodotto> prodotti = DBManager.getInstance().prodottoDAO().findByTipology("Maglie");
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
		
		List<Prodotto> prodotti = DBManager.getInstance().prodottoDAO().findByTipology("pantalone");
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
}
