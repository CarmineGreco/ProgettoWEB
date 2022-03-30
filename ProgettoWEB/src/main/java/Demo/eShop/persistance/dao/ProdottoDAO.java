package Demo.eShop.persistance.dao;

import java.util.List;

import Demo.eShop.model.Prodotto;

public interface ProdottoDAO {
	public void save(Prodotto prodotto);	// Create
	public Prodotto findByPrimaryKey(Integer idProdotto);	// Retrieve
	public Prodotto findByName(String name);
	public List<Prodotto> findAll();       
	public void update(Prodotto prodotto);	//Update
	public void delete(int  idProdotto);	//Delete	
	public List<Prodotto> findByTipology(String categoria);
	public List<Prodotto> findByBorse();
	public List<Prodotto> findByFelpe();
	public List<Prodotto> findByMaglioni();
	public List<Prodotto> findByCamicie();
	public List<Prodotto> findByidPantaloni();
	public List<Prodotto> findByidVestiti();
	
	
}
