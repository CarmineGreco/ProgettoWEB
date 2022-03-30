package Demo.eShop.model;

public class Prodotto {

	private int id;
	private float prezzo;
	private String nome;
	private int taglia;
	private String descrizione;
	private int quantita;
	private String categoria;
	private String img;

	public Prodotto() {
		
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
	public int getTaglia() {
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
	public String getImg() {
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
	public void setTaglia(int taglia) {
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
	public void setImg(String img) {
		this.img = img;
	}
	
	
}
