package Demo.eShop.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Demo.eShop.model.Utente;
import Demo.eShop.persistance.DBManager;

@RestController
public class ProfiloController {
	
//	@PostMapping("modificaProfilo")
//	public String modificaProf(HttpSession session, String nome, String cognome, String email, String pass){
//		
//			Utente utOld = DBManager.getInstance().utenteDAO().findByPrimaryKey(session.getAttribute("username").toString());
//			Utente utNew = DBManager.getInstance().utenteDAO().findByPrimaryKey(session.getAttribute("username").toString());
//			utNew.setCognome(cognome);
//			utNew.setNome(nome);
//			utNew.setUsername(session.getAttribute("username").toString());
//			utNew.setEmail(email);
//			utNew.setPassword(pass);
//			DBManager.getInstance().utenteDAO().update(utOld, utNew);
//			session.setAttribute("nome", utNew.getNome());
//			session.setAttribute("cognome", utNew.getCognome());
//			session.setAttribute("email", utNew.getEmail());
//			session.setAttribute("username",utNew.getUsername());
//			session.setAttribute("password",utNew.getPassword());
//			return "Profilo";
//	}
	
	@PostMapping("modificaProfilo")
	public String modificaProf(HttpSession session, @ RequestBody Utente u){
		
			System.out.println(u.getNome());
			System.out.println(u.getCognome());
			System.out.println(u.getEmail());
			Utente utOld = DBManager.getInstance().utenteDAO().findByPrimaryKey(session.getAttribute("username").toString());;
			DBManager.getInstance().utenteDAO().update(utOld, u);
			session.setAttribute("nome", u.getNome());
			session.setAttribute("cognome", u.getCognome());
			session.setAttribute("email", u.getEmail());
			session.setAttribute("username",u.getUsername());
			session.setAttribute("password",u.getPassword());
			return "successo";
	}
}

