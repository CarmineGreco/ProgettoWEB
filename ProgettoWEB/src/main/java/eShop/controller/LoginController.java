package eShop.controller;

import javax.servlet.http.HttpSession;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import eShop.model.Utente;
import eShop.persistance.DBManager;


@Controller
public class LoginController {

	@PostMapping("loginService")
	public String failLogin(HttpSession session, String username, String pass){
		if(DBManager.getInstance().utenteDAO().existsUser(username)) {
			Utente u = DBManager.getInstance().utenteDAO().findByPrimaryKey(username);
			if(DBManager.getInstance().utenteDAO().checkPassword(username, pass)) {
				session.setAttribute("nome", u.getNome());
				session.setAttribute("cognome", u.getCognome());
				session.setAttribute("email", u.getEmail());
				session.setAttribute("password", pass);
				session.setAttribute("username", username);
				return "index";
			}
			else {
				System.out.println("Password errata");
				return "Login";
			}
		}
		else
			System.out.println("Utente non trovato nel db");
		return "Login";
	}
	@PostMapping("registrationService")
	public String faiRegistration(String username, String nome, String cognome, String email, String pass){
		if(DBManager.getInstance().utenteDAO().existsUser(username)) {
			System.out.println("Username già presente!");
			return "Login";
		}
		else {
			Utente ut = new Utente();
			ut.setUsername(username);
			ut.setNome(nome);
			ut.setCognome(cognome);
			ut.setEmail(email);
			ut.setPassword(pass);
			ut.setAdmin(false);
			DBManager.getInstance().utenteDAO().save(ut);
			return "index";
		}
	}
	
}
