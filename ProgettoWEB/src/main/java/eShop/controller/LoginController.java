package eShop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import eShop.model.Utente;
import eShop.persistance.DBManager;


@RestController
public class LoginController {

	@PostMapping("/html/loginService")
	public String failLogin(String username, String pass){
		System.out.println("Username: " + username + " Password: " + pass);
		return null;
	}
}
