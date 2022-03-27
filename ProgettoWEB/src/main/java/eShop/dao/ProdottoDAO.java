package eShop.dao;

import java.util.List;

import eShop.model.Prodotto;

public interface ProdottoDAO {
	public void save(Prodotto prodotto);	// Create
	public Prodotto findByPrimaryKey(Integer idProdotto);	// Retrieve
	public List<Prodotto> findAll();       
	public void update(Prodotto prodotto);	//Update
	public void delete(int  idProdotto);	//Delete	
	public List<Prodotto> findByTipology(String categoria);
}
