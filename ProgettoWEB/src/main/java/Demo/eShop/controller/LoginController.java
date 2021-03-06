package Demo.eShop.controller;

import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Demo.eShop.model.EmailSender;
import Demo.eShop.model.Utente;
import Demo.eShop.persistance.DBManager;

@RestController
public class LoginController {

	@PostMapping("loginService")
	public String failLogin(HttpSession session, @ RequestBody Utente u){
		if(DBManager.getInstance().utenteDAO().existsUser(u.getUsername())) {
			if(DBManager.getInstance().utenteDAO().checkPassword(u.getUsername(), u.getPassword())) {
				Utente utenteLoggato = DBManager.getInstance().utenteDAO().findByPrimaryKey(u.getUsername());
				session.setAttribute("nome", utenteLoggato.getNome());
				session.setAttribute("cognome", utenteLoggato.getCognome());
				session.setAttribute("email", utenteLoggato.getEmail());
				session.setAttribute("username", utenteLoggato.getUsername());
				session.setAttribute("password", utenteLoggato.getPassword());
				session.setAttribute("admin", utenteLoggato.isAdmin());
				return "successo";
			}
			else {
				System.out.println("Password errata");
				return "errore";
			}
		}
		else
			System.out.println("Utente non trovato nel db");
		return "nonRegistrato";
	}
	
	@PostMapping("registrationService")
	public String faiRegistration( HttpSession session, @RequestBody Utente u){
		if(DBManager.getInstance().utenteDAO().existsUser(u.getUsername())) {
			System.out.println("Username già presente!");
			return "errore";
		}
		else {
			DBManager.getInstance().utenteDAO().save(u);
			session.setAttribute("nome", u.getNome());
			session.setAttribute("cognome", u.getCognome());
			session.setAttribute("email", u.getEmail());
			session.setAttribute("username", u.getUsername());
			session.setAttribute("password", u.getPassword());		
			return "successo";
		}
	}
	
	@PostMapping("RecuperoPassword")
	public String recuperoPasswor(HttpSession session, @RequestBody Utente utente){
		
		if(DBManager.getInstance().utenteDAO().existsUserEmail(utente.getEmail())){
			try {			
				String nuovaPassword= EmailSender.getInstance().ResetPassword(utente.getEmail());
				DBManager.getInstance().utenteDAO().setPassword(utente.getEmail(), nuovaPassword);
			} catch (Exception e) {			
				e.printStackTrace();
			}
		}
		return "success";	
	}
}
