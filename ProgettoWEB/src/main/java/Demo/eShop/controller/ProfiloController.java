package Demo.eShop.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import Demo.eShop.model.Utente;
import Demo.eShop.persistance.DBManager;

@Controller
public class ProfiloController {
	
	@PostMapping("modificaProfilo")
	public String modificaProf(HttpSession session, String nome, String cognome, String email, String pass){
		
			Utente utOld = DBManager.getInstance().utenteDAO().findByPrimaryKey(session.getAttribute("username").toString());
			Utente utNew = DBManager.getInstance().utenteDAO().findByPrimaryKey(session.getAttribute("username").toString());
			utNew.setCognome(cognome);
			utNew.setNome(nome);
			utNew.setUsername(session.getAttribute("username").toString());
			utNew.setEmail(email);
			utNew.setPassword(pass);
			DBManager.getInstance().utenteDAO().update(utOld, utNew);
			session.setAttribute("nome", utNew.getNome());
			session.setAttribute("cognome", utNew.getCognome());
			session.setAttribute("email", utNew.getEmail());
			session.setAttribute("username",utNew.getUsername());
			session.setAttribute("password",utNew.getPassword());
			return "Profilo";
	}
}
