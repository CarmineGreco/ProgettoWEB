package Demo.eShop.persistance.dao.jdbc;

import java.util.List;

import Demo.eShop.model.Commento;
import Demo.eShop.persistance.DBSource;
import Demo.eShop.persistance.dao.CommentoDAO;

public class CommentoDAOJDBC implements CommentoDAO{

	DBSource dbSource;

	public CommentoDAOJDBC(DBSource dbSource) {
	this.dbSource = dbSource;
	}

	@Override
	public void save(Commento c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Commento findByPrimaryKey(int idcommento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Commento> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Commento> findByContenuto(int idcontenuto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Commento> findByUser(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Commento c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int idcommento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addmipiace(int idcommento) {
		// TODO Auto-generated method stub
		
	}
}
