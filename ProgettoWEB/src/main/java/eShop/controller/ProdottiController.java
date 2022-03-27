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
		
		for(Prodotto i : prodotti) {
			System.out.println(i.getId());
			System.out.println(i.getNome());
			System.out.println(i.getPrezzo());
			System.out.println(i.getDescrizione());
			System.out.println(i.getCategoria());
		}
		session.setAttribute("prodotti", prodotti);
		
		return "PaginaProdotto";
	}
}
