package Demo.eShop.persistance.dao.jdbc;

import java.util.ArrayList;

import Demo.eShop.model.Carrello;
import Demo.eShop.model.Prodotto;
import Demo.eShop.persistance.DBSource;
import Demo.eShop.persistance.dao.CarrelloDAO;

public class CarrelloDAOJDBC implements CarrelloDAO {
	
	DBSource dbSource;

	public CarrelloDAOJDBC(DBSource dbSource) {
	this.dbSource = dbSource;
	}

	@Override
	public void save(Carrello c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Carrello findByPrimaryKey(String username, int idProdotto, int taglia) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Carrello c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Carrello c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Prodotto> findProdottiByUser(Carrello c) {
		// TODO Auto-generated method stub
		return null;
	}

}
