package Demo.eShop.controller;

import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import Demo.eShop.model.Utente;
import Demo.eShop.persistance.DBManager;

@RestController
public class LoginController {

	@PostMapping("loginService")
	public String failLogin(HttpSession session, @ RequestBody Utente u){
		System.out.println(u.getUsername());
		System.out.println(u.getPassword());
		if(DBManager.getInstance().utenteDAO().existsUser(u.getUsername())) {
			if(DBManager.getInstance().utenteDAO().checkPassword(u.getUsername(), u.getPassword())) {
				Utente utenteLoggato = DBManager.getInstance().utenteDAO().findByPrimaryKey(u.getUsername());
				session.setAttribute("nome", utenteLoggato.getNome());
				session.setAttribute("cognome", utenteLoggato.getCognome());
				session.setAttribute("email", utenteLoggato.getEmail());
				session.setAttribute("username", utenteLoggato.getUsername());
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
			return "successo";
		}
	}
	
	/*public boolean checkDati(String username, String nome, String cognome, String email, String pass, String confermaPass) {
		if (!Pattern.matches("([a-zA-Z]+|[0-9]*|[\\.|_|-|]*)+@([a-zA-Z]+\\.)+(com|gov|it)", email)) {
			System.out.println("errore email");
			return false;
		}
		if(!Pattern.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()�[{}]:;',?/*~$^+=<>\\.]).{8,20}$",pass)) {
			System.out.println("errore password");
			return false;
		}
		if(!pass.equals(confermaPass)) {
			System.out.println("errore conferma password");
			return false;
		}
	return true;
	}*/
}
