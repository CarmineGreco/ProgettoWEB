package Demo.eShop.persistance.dao.jdbc;

import java.util.List;

import Demo.eShop.model.Utente;
import Demo.eShop.persistance.DBSource;
import Demo.eShop.persistance.dao.UtenteDAO;

public class UtenteDAOJDBC implements UtenteDAO{
	
	DBSource dbSource;

	public UtenteDAOJDBC(DBSource dbSource) {
	this.dbSource = dbSource;
	}

	@Override
	public boolean save(Utente utente) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Utente findByPrimaryKey(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Utente> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Utente> findAllOtherUsers(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Utente old, Utente newu) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateWithoutPsw(Utente old, Utente newu) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String email) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String findUsername(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkPassword(String email, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getUsername(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsUser(String username) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existsUsername(String username) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setPassword(String email, String password) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Utente> findByName(String cercaNome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utente getUtente(String username) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
