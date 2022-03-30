package Demo.eShop.persistance.dao;

import java.util.ArrayList;

import Demo.eShop.model.Carrello;
import Demo.eShop.model.Prodotto;

public interface CarrelloDAO {
	public void save(Carrello c);  // Create
	public Carrello findByPrimaryKey(String username, int idProdotto, int taglia); 
	public void update(Carrello c); //Update
	public void delete(Carrello c); //Delete	
	public ArrayList<Prodotto> findProdottiByUser(Carrello c);
}
