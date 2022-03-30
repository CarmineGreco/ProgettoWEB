package Demo.eShop.persistance.dao.jdbc;

import java.util.List;

import Demo.eShop.model.Prodotto;
import Demo.eShop.persistance.DBSource;
import Demo.eShop.persistance.dao.ProdottoDAO;

public class ProdottoDAOJDBC implements ProdottoDAO{
	
	DBSource dbSource;

	public ProdottoDAOJDBC(DBSource dbSource) {
	this.dbSource = dbSource;
	}

	@Override
	public void save(Prodotto prodotto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Prodotto findByPrimaryKey(Integer idProdotto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Prodotto findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Prodotto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Prodotto prodotto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int idProdotto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Prodotto> findByTipology(String categoria) {
		// TODO Auto-generated method stub
		return null;
	}

}
