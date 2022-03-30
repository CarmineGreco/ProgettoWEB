package Demo.eShop.persistance.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Demo.eShop.model.Prodotto;
import Demo.eShop.persistance.DBSource;
import Demo.eShop.persistance.dao.ListaPreferitiDAO;


public class ListaPreferitiDAOJDBC implements ListaPreferitiDAO {
	DBSource dbSource;
	
	public ListaPreferitiDAOJDBC(DBSource dbSource) {
		this.dbSource = dbSource;
	}

	@Override
	public boolean savePreferito(String utente, int idProdotto) {
		Connection conn;

		try {
			conn = dbSource.getConnection();
			String query = "insert into preferiti values(?,?);"; 
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, utente);
			st.setInt(2, idProdotto);
			st.executeUpdate();
			st.close();						
		} catch (SQLException e) {
			  return false;
		}
		return true;
	}
	
	

	@Override
	public boolean existPreferito(String utente, Integer idProdotto) {
			Prodotto prodotto = new Prodotto();		
		try {
			Connection conn = dbSource.getConnection();
			String query = "select prodotto.* from preferiti,device where preferiti.utente=? and preferiti.prodotto=? and preferiti.prodotto=prodotto.id;";
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, utente);
			st.setInt(2, idProdotto);			
			ResultSet rs = st.executeQuery();
			if (rs.next()) {				
				prodotto.setId(rs.getInt("id"));				
				prodotto.setPrezzo(rs.getFloat("prezzo"));
				prodotto.setNome(rs.getString("nome"));
				prodotto.setTaglia(rs.getInt("taglia"));
				prodotto.setDescrizione(rs.getString("descrizione"));
				prodotto.setQuantita(rs.getInt("quantita"));
				prodotto.setCategoria(rs.getString("categoria"));
				prodotto.setImg(rs.getString("img"));	
				return true;							
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}			
				return false;			
				
	}

	@Override
	public List<Prodotto> getPreferiti(String utente) {
		List<Prodotto> preferiti = new ArrayList<Prodotto>();
		
		try {
			Connection conn = dbSource.getConnection();
			String query = "select prodotto.* from preferiti.prodotto where preferiti.utente=? and preferiti.prodotto=prodotto.id;";
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, utente);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Prodotto prodotto = new Prodotto();
				prodotto.setId(rs.getInt("id"));				
				prodotto.setPrezzo(rs.getFloat("prezzo"));
				prodotto.setNome(rs.getString("nome"));
				prodotto.setTaglia(rs.getInt("taglia"));
				prodotto.setDescrizione(rs.getString("descrizione"));
				prodotto.setQuantita(rs.getInt("quantita"));
				prodotto.setCategoria(rs.getString("categoria"));
				prodotto.setImg(rs.getString("img"));	
				
				preferiti.add(prodotto);				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	return preferiti;
	}

	@Override
	public void deletePreferito(String email, Integer idDevice) {
		Connection connection = null;
		try {
			connection = this.dbSource.getConnection();
			String delete = "delete FROM listapreferiti WHERE utente=? and device=?;";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setString(1, email);
			statement.setInt(2, idDevice);
			statement.executeUpdate();
			statement.close();
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
	
	

}