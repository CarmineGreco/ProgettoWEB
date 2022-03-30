package Demo.eShop.persistance.dao.jdbc;

import java.util.List;

import Demo.eShop.model.Prodotto;
import Demo.eShop.persistance.DBSource;
import Demo.eShop.persistance.dao.ListaPreferitiDAO;

public class ListaPreferitiDAOJDBC implements ListaPreferitiDAO{
	
	DBSource dbSource;

	public ListaPreferitiDAOJDBC(DBSource dbSource) {
	this.dbSource = dbSource;
	}

	@Override
	public boolean savePreferito(String username, int idProdotto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Prodotto> getPreferiti(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePreferito(String username, Integer idProdotto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean existPreferito(String username, Integer idProdotto) {
		// TODO Auto-generated method stub
		return false;
	}

}
