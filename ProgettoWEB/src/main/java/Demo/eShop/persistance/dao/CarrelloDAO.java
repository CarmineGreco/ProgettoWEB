package Demo.eShop.persistance.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Demo.eShop.model.Carrello;
import Demo.eShop.model.Prodotto;
import Demo.eShop.model.Utente;

public interface CarrelloDAO {
	public void save(Carrello c);  // Create
	public Carrello findByPrimaryKey(String username, int idProdotto, int taglia); 
	public void update(Carrello c); //Update
	public void delete(Carrello c); //Delete	
	public ArrayList<Prodotto> findProdottiByUser(Carrello c);
	public boolean existsCarrello(String username, int idProdotto, int taglia);
	
}
