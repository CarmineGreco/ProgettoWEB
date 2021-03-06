package Demo.eShop.persistance.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Demo.eShop.model.Prodotto;
import Demo.eShop.persistance.DBSource;
import Demo.eShop.persistance.dao.ProdottoDAO;


public class ProdottoDAOJDBC implements ProdottoDAO{


	DBSource dbSource;
	
	public ProdottoDAOJDBC(DBSource dbSource) {
		this.dbSource= dbSource;
	}
	
	@Override
	public void save(Prodotto prodotto) {
		Connection conn;
		try {
			conn = dbSource.getConnection();
			String query = "insert into prodotto values(?,?,?,?,?,?,?);";
			PreparedStatement st = conn.prepareStatement(query);
			st.setInt(1, prodotto.getId());
			st.setFloat(2, prodotto.getPrezzo());
			st.setString(3, prodotto.getNome());
			st.setInt(4, prodotto.getTaglia());
			st.setString(5, prodotto.getDescrizione());
			st.setInt(6, prodotto.getQuantita());
			st.setString(7, prodotto.getCategoria());
			st.executeUpdate();
			st.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Prodotto findByPrimaryKey(Integer idProdotto) {
		Prodotto prodotto = new Prodotto();
		try {
			
			Connection con = dbSource.getConnection();
			String query = "select * from prodotto where id=?;";
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, idProdotto);
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
			st.close();
			
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return prodotto;
	}

	@Override
	public List<Prodotto> findAll() {
		List<Prodotto> prodotti = new ArrayList <Prodotto>();
		try {
			Connection con = dbSource.getConnection();
			String query = "select * from prodotto order by id,taglia";
			PreparedStatement st = con.prepareStatement(query);
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
				prodotti.add(prodotto);				
			}
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prodotti;
	}

	@Override
	public void update(Prodotto prodotto) {
		Connection connection = null;
		try {
			if(prodotto.getQuantita() != 0) {
				connection = this.dbSource.getConnection();
				String update = "update prodotto SET prezzo = ?, nome = ?, quantita=? WHERE id=? and taglia=?;";
				PreparedStatement st = connection.prepareStatement(update);			
				st.setFloat(1, prodotto.getPrezzo());
				st.setString(2, prodotto.getNome());
				st.setInt(3, prodotto.getQuantita());
				st.setInt(4, prodotto.getId());
				st.setInt(5, prodotto.getTaglia());
				st.executeUpdate();
				st.close();
				}
			else {
				try {
					connection = this.dbSource.getConnection();
					String delete = "delete FROM prodotto WHERE id = ? and taglia = ?;";
					PreparedStatement statement = connection.prepareStatement(delete);
					statement.setInt(1, prodotto.getId());
					statement.setInt(2, prodotto.getTaglia());
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
		} catch (SQLException e) {
			e.printStackTrace();			
		}
		
	}

	@Override
	public void delete(int idProdotto) {
		Connection connection = null;
		try {
			connection = this.dbSource.getConnection();
			String delete = "delete FROM prodotto WHERE id = ?;";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setInt(1, idProdotto);
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

	@Override
	public List<Prodotto> findByTipology(String categoria) {
		List<Prodotto> prodotti = new ArrayList <Prodotto>();
		try {
			Connection con = dbSource.getConnection();
			String query = "select id from prodotto where categoria=? group by id;";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, categoria);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Prodotto prodotto = findByPrimaryKey(rs.getInt("id"));
//				prodotto.setId(rs.getInt("id"));				
//				prodotto.setPrezzo(rs.getFloat("prezzo"));
//				prodotto.setNome(rs.getString("nome"));
//				prodotto.setTaglia(rs.getInt("taglia"));
//				prodotto.setDescrizione(rs.getString("descrizione"));
//				prodotto.setQuantita(rs.getInt("quantita"));
//				prodotto.setCategoria(rs.getString("categoria"));
//				prodotto.setImg(rs.getString("img"));	
				prodotti.add(prodotto);			
			}
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prodotti;
	}

	@Override
	public List<Prodotto> sortPrezzo(String categoria) {
		List<Prodotto> prodotti = new ArrayList <Prodotto>();
		try {
			Connection con = dbSource.getConnection();
			String query = "select * from prodotto where categoria=? and taglia=? order by prezzo";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, categoria);
			st.setInt(2, 40);
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
				prodotti.add(prodotto);				
			}
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prodotti;
	}

	@Override
	public int getQuantitaPerTaglia(int id, int taglia) {
		int quantita=-1;
		try {
			Connection con = dbSource.getConnection();
			String query = "select quantita from prodotto where id=? and taglia=?";
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1,id);
			st.setInt(2,taglia);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				quantita=rs.getInt("quantita");
			}
			st.close();
			return quantita;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return quantita;
	}

	@Override
	public void modificaQuantita(int id, int taglia, int quantita) {
		try {
			Connection con = dbSource.getConnection();
			String query = "update prodotto SET quantita=? where id=? and taglia=?;";
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, quantita);
			st.setInt(2,id);
			st.setInt(3,taglia);
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public List<Prodotto> risultatiProdotto(String string) {
		List<Prodotto> prodotti = new ArrayList <Prodotto>();
		try {
			Connection con = dbSource.getConnection();
			String query = "select *  from prodotto where (nome ILIKE ? or descrizione ILIKE ? or categoria ILIKE ? or img ILIKE ?) and taglia=?"; 
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, string);
			st.setString(2, string);
			st.setString(3, string);
			st.setString(4, string);
			st.setInt(5, 40);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Prodotto p=new Prodotto();
				p.setId(rs.getInt("id"));
				p.setPrezzo(rs.getFloat("prezzo"));
				p.setNome(rs.getString("nome"));
				p.setTaglia(rs.getInt("taglia"));
				p.setDescrizione(rs.getString("descrizione"));
				p.setCategoria(rs.getString("categoria"));
				p.setQuantita(rs.getInt("quantita"));
				p.setImg(rs.getString("img"));
				prodotti.add(p);
			}
			st.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prodotti;
	}
}
