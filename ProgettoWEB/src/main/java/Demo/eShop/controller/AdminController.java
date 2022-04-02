package Demo.eShop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String modificaProdotto(HttpSession session, @RequestParam Integer idProdotto, @RequestParam String nome, @RequestParam float prezzo, @RequestParam Integer taglia, @RequestParam Integer qntProd) {
		Prodotto p = new Prodotto();
		p.setNome(nome);
		p.setId(idProdotto);
		p.setPrezzo(prezzo);
		p.setQuantita(qntProd);
		p.setTaglia(taglia);
		DBManager.getInstance().prodottoDAO().update(p);
		return "redirect:/PaginaAdmin";
	}
}
