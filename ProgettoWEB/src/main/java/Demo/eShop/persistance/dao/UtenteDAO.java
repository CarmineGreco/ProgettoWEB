package Demo.eShop.persistance.dao;

import java.util.List;

import Demo.eShop.model.Utente;

public interface UtenteDAO {

	public boolean save(Utente utente);  // Create  == insert/store
	public Utente findByPrimaryKey(String username);     // Retrieve  == select stud
	public List<Utente> findAll();     //  select*
	public List<Utente> findAllOtherUsers(String username);     //  select*
	public boolean update(Utente old, Utente newu); //Update
	public void updateWithoutPsw(Utente old, Utente newu);
	public void delete(String username); //Delete	
	public String findUsername(String email);
	public boolean checkPassword(String username, String password);
	public String getUsername(String email);
	public boolean existsUser(String username);
	public boolean existsUsername (String username);
	public void setPassword(String username, String password); //Update
	public List<Utente> findByName(String cercaNome);     // Retrieve  == select stud
	public Utente getUtente(String username);
	public String getEmail(String username);
}
