package eShop.dao;

import java.util.List;

import eShop.model.Prodotto;

public interface ListaPreferitiDAO {

	public boolean savePreferito(String username, int idProdotto);  
	public List<Prodotto> getPreferiti(String username);  
	public void deletePreferito(String username, Integer idProdotto);
	public boolean existPreferito(String username, Integer idProdotto);
}