package eShop.dao;

import java.util.ArrayList;
import java.util.List;

import eShop.model.Carrello;
import eShop.model.Prodotto;

public interface CarrelloDAO {
	public void save(Carrello c);  // Create
	public Carrello findByPrimaryKey(String username, int idProdotto, int taglia); 
	public void update(Carrello c); //Update
	public void delete(Carrello c); //Delete	
	public ArrayList<Prodotto> findProdottiByUser(Carrello c);
}
