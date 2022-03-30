package Demo.eShop.persistance.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Demo.eShop.model.Carrello;
import Demo.eShop.model.Prodotto;
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
			conn = dbSource.getConnection();
			String query = "insert into carrello values(?,?,?,?);";
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, c.getUtente());
			st.setInt(2, c.getIdProdotto());
			st.setInt(3, c.getTagliaProdotto());
			st.setInt(4, c.getQuantita());
			st.executeUpdate();
			st.close();
			
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
			String update = "update carrello SET id_prodotto = ?, taglia_prodotto = ?, quantita = ? WHERE utente=?;";
			PreparedStatement st = connection.prepareStatement(update);			
			st.setInt(1, c.getIdProdotto());
			st.setInt(2, c.getTagliaProdotto());
			st.setInt(3, c.getQuantita());
			st.setString(4, c.getUtente());
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
}
