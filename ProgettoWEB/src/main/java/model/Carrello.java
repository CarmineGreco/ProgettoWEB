package model;

public class Carrello {
	private String utente;
	private int idProdotto;
	private char tagliaProdotto;
	private int quantita;
	public Carrello(String utente, int idProdotto, char tagliaProdotto, int quantita) {
		super();
		this.utente = utente;
		this.idProdotto = idProdotto;
		this.tagliaProdotto = tagliaProdotto;
		this.quantita = quantita;
	}
	public String getUtente() {
		return utente;
	}
	public int getIdProdotto() {
		return idProdotto;
	}
	public char getTagliaProdotto() {
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
	public void setTagliaProdotto(char tagliaProdotto) {
		this.tagliaProdotto = tagliaProdotto;
	}
	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
	
	
}
