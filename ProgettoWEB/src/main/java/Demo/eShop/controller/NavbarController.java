package Demo.eShop.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Demo.eShop.model.Prodotto;
import Demo.eShop.persistance.DBManager;

@Controller
public class NavbarController {
	
	@GetMapping("/index")	
	public String getHome(HttpSession session, Model model) {
		
		return "index";
	}
	
	@PostMapping("cerca")	
	public String risultatiRicerca(HttpSession session, Model model, @RequestParam String daCercare) {
		
		String cerca="%"+daCercare+"%";
		
		List<Prodotto> prodotti= new ArrayList<Prodotto>();
		
		prodotti=DBManager.getInstance().prodottoDAO().risultatiProdotto(cerca);
		model.addAttribute("prodotti",prodotti);	

		return "Collezione";			
	}

}
