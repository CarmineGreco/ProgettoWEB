package eShop.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import eShop.persistance.DBManager;


@RestController
public class LoginController {

	@PostMapping("/html/loginService")
	public String failLogin(String username, String pass){
		if(!DBManager.getInstance().utenteDAO().existsUser(username))
			System.out.println("Utente trovato nel db");
		else
			System.out.println("utente non trovato nel db");
		return null;
	}
}
