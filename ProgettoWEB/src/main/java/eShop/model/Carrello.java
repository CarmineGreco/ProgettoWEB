package eShop.model;

import java.util.ArrayList;


public class Carrello {
	
	private String utente;
	private int idProdotto;
	private int tagliaProdotto;
	private int quantita;
	
	public Carrello() {
	}

	public String getUtente() {
		return utente;
	}

	public int getIdProdotto() {
		return idProdotto;
	}

	public int getTagliaProdotto() {
		return tagliaProdotto;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setUtente(String utente) {
		this.utente = utente;
	}

	public void setIdProdotto(int idProdotto) {
		this.idProdotto = idProdotto;
	}

	public void setTagliaProdotto(int tagliaProdotto) {
		this.tagliaProdotto = tagliaProdotto;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
	
	
}
