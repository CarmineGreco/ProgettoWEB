package Demo.eShop.persistance.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Demo.eShop.model.Carrello;
import Demo.eShop.model.Prodotto;
import Demo.eShop.model.Utente;
import Demo.eShop.persistance.DBSource;
import Demo.eShop.persistance.dao.CarrelloDAO;


public class CarrelloDAOJDBC implements CarrelloDAO {
DBSource dbSource;
	
	public CarrelloDAOJDBC(DBSource dbSource) {
		this.dbSource= dbSource;
	}
	
	@Override
	public void save(Carrello c) {
		Connection conn;
		try {
			if(!existsCarrello(c.getUtente(), c.getIdProdotto(), c.getTagliaProdotto())){
				conn = dbSource.getConnection();
				String query = "insert into carrello values(?,?,?,?,?);";
				PreparedStatement st = conn.prepareStatement(query);
				st.setString(1, c.getUtente());
				st.setInt(2, c.getIdProdotto());
				st.setInt(3, c.getTagliaProdotto());
				st.setInt(4, c.getQuantita());
				st.setFloat(5, c.getPrezzo());
				st.executeUpdate();
				st.close();
			}
			else {
				update(c);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Carrello findByPrimaryKey(String username, int idProdotto, int taglia) {
		Carrello carrello = new Carrello();
		try {
			
			Connection con = dbSource.getConnection();
			String query = "select * from carrello where utente=? and id_prodotto=? and taglia_prodotto=?;";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, username);
			st.setInt(2, idProdotto);
			st.setInt(3, taglia);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {				
				carrello.setUtente(rs.getString("utente"));				
				carrello.setIdProdotto(rs.getInt("id_prodotto"));
				carrello.setTagliaProdotto(rs.getInt("taglia_prodotto"));
				carrello.setQuantita(rs.getInt("quantita"));
				carrello.setPrezzo(rs.getFloat("prezzo"));
			st.close();
			
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return carrello;
	}

	@Override
	public void update(Carrello c) {
		Connection connection = null;
		try {
			connection = this.dbSource.getConnection();
			String update = "update carrello SET quantita = ? WHERE utente=? and id_prodotto=? and taglia_prodotto=? and prezzo=?;";
			PreparedStatement st = connection.prepareStatement(update);			
			st.setInt(1, c.getQuantita());
			st.setString(2, c.getUtente());
			st.setInt(3, c.getIdProdotto());
			st.setInt(4, c.getTagliaProdotto());
			st.setFloat(5, c.getPrezzo());
			st.executeUpdate();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();			
		}
	}

	@Override
	public void delete(Carrello c) {
		Connection connection = null;
		try {
			connection = this.dbSource.getConnection();
			String delete = "delete FROM carrello WHERE utente = ? and id_prodotto=? and taglia_prodotto=?;";
			PreparedStatement st = connection.prepareStatement(delete);
			st.setString(1, c.getUtente());
			st.setInt(2, c.getIdProdotto());
			st.setInt(3, c.getTagliaProdotto());
			st.executeUpdate();
			st.close();
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		
	}

	@Override
	public ArrayList<Prodotto> findProdottiByUser(Carrello c) {
		ArrayList<Prodotto> prodotti = new ArrayList<Prodotto>();
		try {
			
			Connection con = dbSource.getConnection();
			String query = "select * from (prodotto inner join carrello (prodotto.id = carrello.id_prodotto)) where utente=?;";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, c.getUtente());
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				Prodotto prodotto = new Prodotto();
				prodotto.setId(rs.getInt("id"));				
				prodotto.setPrezzo(rs.getFloat("prezzo"));
				prodotto.setNome(rs.getString("nome"));
				prodotto.setTaglia(rs.getInt("taglia"));
				prodotto.setDescrizione(rs.getString("descrizione"));
				prodotto.setQuantita(rs.getInt("quantita"));
				prodotto.setCategoria(rs.getString("categoria"));
				prodotto.setImg(rs.getString("img"));
				prodotti.add(prodotto);	
			st.close();
			
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return prodotti;
	}

	@Override
	public boolean existsCarrello(String username, int idProdotto, int taglia) {
			Carrello c = new Carrello();
				
				try {
					Connection conn = dbSource.getConnection();
					String query = "select * from carrello where utente=? and taglia_prodotto=? and id_prodotto=?";
					PreparedStatement st = conn.prepareStatement(query);
					st.setString(1, username);
					st.setInt(2, taglia);
					st.setInt(3, idProdotto);
					ResultSet rs = st.executeQuery();
					while (rs.next()) {
						c.setUtente(rs.getString("utente"));
						c.setIdProdotto(rs.getInt("id_prodotto"));
						c.setTagliaProdotto(rs.getInt("taglia_prodotto"));
						c.setQuantita(rs.getInt("quantita"));
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}	
			
				if (c.getUtente()!=null)
					return true;
				else
					return false;
	}

	@Override
	public ArrayList<Prodotto> getProdotti(String username) {
		ArrayList<Prodotto> prodotti = new ArrayList<Prodotto>();
		try {
			Connection con = dbSource.getConnection();
			String query = "select * from prodotto inner join carrello on (id=id_prodotto and taglia=taglia_prodotto and utente=?);";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1,username);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {				
				Prodotto prodotto=new Prodotto();
				prodotto.setId(rs.getInt("id"));				
				prodotto.setPrezzo(rs.getFloat("prezzo"));
				prodotto.setNome(rs.getString("nome"));
				prodotto.setTaglia(rs.getInt("taglia"));
				prodotto.setDescrizione(rs.getString("descrizione"));
				prodotto.setQuantita(rs.getInt("quantita"));
				prodotto.setCategoria(rs.getString("categoria"));
				prodotto.setImg(rs.getString("img"));
				prodotti.add(prodotto);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return prodotti;
	}

	@Override
	public ArrayList<Carrello> getCarrelliUtente(String username) {
		ArrayList<Carrello> carrelliUtente = new ArrayList<Carrello>();
		try {
			Connection con = dbSource.getConnection();
			String query = "select * from carrello where utente=?;";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, username);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {				
				Carrello c = new Carrello();
				c.setUtente(rs.getString("utente"));				
				c.setIdProdotto(rs.getInt("id_prodotto"));
				c.setTagliaProdotto(rs.getInt("taglia_prodotto"));
				c.setQuantita(rs.getInt("quantita"));
				c.setPrezzo(rs.getFloat("prezzo"));
				carrelliUtente.add(c);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return carrelliUtente;
	}

	public float sommaTotale(String username) {
		float somma=0;
		try {
			Connection con = dbSource.getConnection();
			String query = "select prezzo, quantita from carrello where utente=?;";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, username);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {				
				float quantita = rs.getInt("quantita");
				float prezzo = rs.getFloat("prezzo");
				somma += (quantita*prezzo);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return somma;
	}
}
