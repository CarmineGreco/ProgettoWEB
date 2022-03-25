package eShop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import eShop.model.Utente;
import eShop.persistance.DBManager;


@Controller
public class LoginController {

	@PostMapping("loginService")
	public String failLogin(String username, String pass){
		if(DBManager.getInstance().utenteDAO().existsUser(username))
			System.out.println("Utente trovato nel db");
		else
			System.out.println("Utente non trovato nel db");
		return null;
	}
	
	
	@GetMapping("/Registrazione")
	public String vaiAllaRegistrazione() {
		return "Registrazione";
	}
}
