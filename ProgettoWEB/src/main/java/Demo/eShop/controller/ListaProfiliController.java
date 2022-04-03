package Demo.eShop.controller;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Demo.eShop.model.EmailSender;
import Demo.eShop.model.Utente;
import Demo.eShop.persistance.DBManager;

@Controller
public class ListaProfiliController {
	
	@GetMapping("/VisualizzaLista")
	public String visualizzaLista(HttpSession session) {
		List<Utente> profili=DBManager.getInstance().utenteDAO().findAll();
		session.setAttribute("profili", profili);
		System.out.println(profili.size());
		return "ListaProfili";
	}
	
	@GetMapping("/eliminaProfilo")
	public String eliminaProfilo(HttpSession session, @RequestParam String username, @RequestParam String email){
		try {
			EmailSender.getInstance().eliminazioneProfiloEmail(email);
			DBManager.getInstance().utenteDAO().delete(username);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/VisualizzaLista";
	}
}
