package Demo.eShop.controller;

import java.util.Collections;
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
		int quantita40=DBManager.getInstance().prodottoDAO().getQuantitaPerTaglia(idProdotto, 40);
		int quantita42=DBManager.getInstance().prodottoDAO().getQuantitaPerTaglia(idProdotto, 42);
		int quantita44=DBManager.getInstance().prodottoDAO().getQuantitaPerTaglia(idProdotto, 44);
		session.setAttribute("quantita40",quantita40);
		session.setAttribute("quantita42",quantita42);
		session.setAttribute("quantita44",quantita44);
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
		
		List<Prodotto> prodotti = DBManager.getInstance().prodottoDAO().findByTipology("Maglia");
		session.setAttribute("categoria", "Maglia");
		session.setAttribute("prodotti", prodotti);
		
		return "Collezione";
	}
	
	@GetMapping("/CollezioneVestiti")
	public String vaiAllaCollezioneVestiti(HttpSession session) {
		
		List<Prodotto> prodotti = DBManager.getInstance().prodottoDAO().findByTipology("Vestiti");
		session.setAttribute("categoria", "Vestiti");
		session.setAttribute("prodotti", prodotti);
		
		return "Collezione";
	}
	
	
	@GetMapping("/CollezionePantaloni")
	public String vaiAllaCollezionePantaloni(HttpSession session) {
		
		List<Prodotto> prodotti = DBManager.getInstance().prodottoDAO().findByTipology("Pantaloni");
		session.setAttribute("categoria", "Pantaloni");
		session.setAttribute("prodotti", prodotti);
		
		return "Collezione";
	}
	@GetMapping("/CollezioneFelpe")
	public String vaiAllaCollezioneFelpe(HttpSession session) {
		
		List<Prodotto> prodotti = DBManager.getInstance().prodottoDAO().findByTipology("Felpe");
		session.setAttribute("categoria", "Felpe");
		session.setAttribute("prodotti", prodotti);
		
		return "Collezione";
	}
	
	@GetMapping("/CollezioneCamicie")
	public String vaiAllaCollezioneCamicie(HttpSession session) {
		
		List<Prodotto> prodotti = DBManager.getInstance().prodottoDAO().findByTipology("Camicie");
		session.setAttribute("categoria", "Camicie");
		session.setAttribute("prodotti", prodotti);
		
		return "Collezione";
	}
	
	@PostMapping("/aggiungiCarrello")
	public String aggiungiAlCarrello(HttpSession session, @RequestParam Integer taglia, @RequestParam Integer idProdotto, @RequestParam Integer quantita, @RequestParam float prezzo) {
			int quantCarrello=DBManager.getInstance().carrelloDAO().getQuantita(session.getAttribute("username").toString(), idProdotto, taglia);
			Carrello c = new Carrello();		
			c.setIdProdotto(idProdotto);
			c.setQuantita(quantita+quantCarrello);
			c.setUtente(session.getAttribute("username").toString());
			c.setTagliaProdotto(taglia);
			c.setPrezzo(prezzo);
			DBManager.getInstance().carrelloDAO().save(c);
			session.setAttribute("carrello", c);
			int q=DBManager.getInstance().prodottoDAO().getQuantitaPerTaglia(idProdotto, taglia);
			DBManager.getInstance().prodottoDAO().modificaQuantita(idProdotto, taglia, q-quantita);
			return "PaginaProdotto";
	}
	
	@GetMapping("/PrezzoCrescente")
	public String prezzoCrescente(HttpSession session, @RequestParam String categoria) {
		List<Prodotto> prodotto=DBManager.getInstance().prodottoDAO().sortPrezzo(categoria);
		session.setAttribute("prodotti", prodotto);
		return "Collezione";
	}
	
	@GetMapping("/PrezzoDecrescente")
	public String prezzoDecrescente(HttpSession session, @RequestParam String categoria) {
		List<Prodotto> prodotto=DBManager.getInstance().prodottoDAO().sortPrezzo(categoria);
		Collections.reverse(prodotto);
		session.setAttribute("prodotti", prodotto);
		return "Collezione";
	}
}
