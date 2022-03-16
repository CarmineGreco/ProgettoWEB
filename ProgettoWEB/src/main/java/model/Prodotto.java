package model;

import java.io.InputStream;

public class Prodotto {

	private int id;
	private float prezzo;
	private String nome;
	private char taglia;
	private String descrizione;
	private int quantita;
	private String categoria;
	private InputStream img;
	public Prodotto(int id, float prezzo, String nome, char taglia, String descrizione, int quantita, String categoria,
			InputStream img) {
		super();
		this.id = id;
		this.prezzo = prezzo;
		this.nome = nome;
		this.taglia = taglia;
		this.descrizione = descrizione;
		this.quantita = quantita;
		this.categoria = categoria;
		this.img = img;
	}
	public int getId() {
		return id;
	}
	public float getPrezzo() {
		return prezzo;
	}
	public String getNome() {
		return nome;
	}
	public char getTaglia() {
		return taglia;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public int getQuantita() {
		return quantita;
	}
	public String getCategoria() {
		return categoria;
	}
	public InputStream getImg() {
		return img;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setTaglia(char taglia) {
		this.taglia = taglia;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public void setImg(InputStream img) {
		this.img = img;
	}
	
	
}
