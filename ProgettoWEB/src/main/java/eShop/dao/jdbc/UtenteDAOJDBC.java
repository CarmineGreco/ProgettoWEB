package eShop.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCrypt;
import eShop.dao.UtenteDAO;
import eShop.model.Utente;
import eShop.persistance.DBSource;

public class UtenteDAOJDBC implements UtenteDAO {
	DBSource dbSource;

	public UtenteDAOJDBC(DBSource dbSource) {
		this.dbSource = dbSource;
	}

	@Override
	public boolean save(Utente utente) {
		Connection conn;

		try {
			conn = dbSource.getConnection();

			String query = "insert into utente values(?,?,?,?,?,?);"; // prendiamo la query
			PreparedStatement st = conn.prepareStatement(query); // creiamo lo statement
			st.setString(1, utente.getUsername());
			st.setString(2, BCrypt.hashpw(utente.getPassword(), BCrypt.gensalt(12)));
			st.setBoolean(3, utente.isAdmin());
			st.setString(4, utente.getEmail());
			st.setString(5, utente.getNome());
			st.setString(6, utente.getCognome());
			st.executeUpdate();
			
		} catch (SQLException e) {
			  return false;
		}
		
		return true;
	}

	@Override
	public Utente findByPrimaryKey(String username) {
		Utente utente = new Utente();
			
			try {
				Connection conn = dbSource.getConnection();
				String query = "select * from utente where username=?";
				PreparedStatement st = conn.prepareStatement(query);
				st.setString(1, username);
				ResultSet rs = st.executeQuery();
				while (rs.next()) {
					utente.setEmail(rs.getString("email"));
					utente.setNome(rs.getString("nome"));
					utente.setCognome(rs.getString("cognome"));
					utente.setPassword(rs.getString("password"));
					utente.setUsername(rs.getString("username"));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		return utente;
	}
	
	
	
	@Override
	public List<Utente> findByName(String cercaNome) {
		
		List<Utente> utenti = new ArrayList<Utente>();
		String cerca="%"+cercaNome+"%";
		
		try {
			Connection conn = dbSource.getConnection();
			String query = "select * from utente where nome ILIKE ? or cognome ILIKE ? or email ILIKE ? or username ILIKE ?";
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, cerca);
			st.setString(2, cerca);
			st.setString(3, cerca);
			st.setString(3, cerca);
			st.setString(4, cerca);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				String email = rs.getString("email");
				String nome = rs.getString("nome");
				String cognome = rs.getString("cognome");
				String password = rs.getString("password");
				String username = rs.getString("username");								
				Utente utente = new Utente();
				
				utente.setEmail(email);
				utente.setNome(nome);
				utente.setCognome(cognome);
				utente.setPassword(password);
				utente.setUsername(username);
				
				if(!utente.getEmail().equals("admin@admin.it")) 
					utenti.add(utente);					
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return utenti;
	}

	@Override
	public List<Utente> findAllOtherUsers(String username) {
		List<Utente> utenti = new ArrayList<Utente>();
		
			try {
				Connection conn = dbSource.getConnection();
				String query = "select * from utente where username!=?";
				PreparedStatement st = conn.prepareStatement(query);
				st.setString(1, username);
				ResultSet rs = st.executeQuery();
				while (rs.next()) {
					String email1 = rs.getString("email");
					String nome = rs.getString("nome");
					String cognome = rs.getString("cognome");
					String password = rs.getString("password");
					String user = rs.getString("username");									
					Utente utente = new Utente();
					
					utente.setEmail(email1);
					utente.setNome(nome);
					utente.setCognome(cognome);
					utente.setPassword(password);
					utente.setUsername(user);
					
					utenti.add(utente);					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return utenti;
	}
	
	@Override
	public boolean existsUser(String username) {
		Utente utente = new Utente();
			
			try {
				Connection conn = dbSource.getConnection();
				String query = "select * from utente where username=?";
				PreparedStatement st = conn.prepareStatement(query);
				st.setString(1, username);
				ResultSet rs = st.executeQuery();
				while (rs.next()) {
					utente.setEmail(rs.getString("email"));
					utente.setNome(rs.getString("nome"));
					utente.setCognome(rs.getString("cognome"));
					utente.setPassword(rs.getString("password"));
					utente.setUsername(rs.getString("username"));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		
			if (utente.getUsername()!=null)
				return true;
			else
				return false;
	}
	

	@Override
	public String findUsername(String email) {
		String username = null;
		
		try {
			Connection conn = dbSource.getConnection();
			String query = "select username from utente where email=?";
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, email);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				username = rs.getString("username");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return username;
	}
	

	@Override
	public List<Utente> findAll() {
		List<Utente> utenti = new ArrayList<Utente>();
			
			try {
				Connection conn = dbSource.getConnection();
				String query = "select * from utente";
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(query);
				while (rs.next()) {
					String email = rs.getString("email");
					String nome = rs.getString("nome");
					String cognome = rs.getString("cognome");
					String password = rs.getString("password");
					String username = rs.getString("username");
					
					System.out.println(email + nome + cognome + password);
					Utente utente = new Utente();
					
					utente.setEmail(email);
					utente.setNome(nome);
					utente.setCognome(cognome);
					utente.setPassword(password);
					
					utenti.add(utente);
					System.out.println("creato");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return utenti;
	}

	@Override
	public void update(Utente old, Utente newu) {////////////to check
		
		Connection connection = null;
		
		try {
			connection = this.dbSource.getConnection();
			String update = "update utente SET nome = ?, cognome = ?, password = ?, username = ? WHERE email=?";
			PreparedStatement statement = connection.prepareStatement(update);
			
			statement.setString(1, newu.getNome());			
			statement.setString(2, newu.getCognome());			
			statement.setString(3, BCrypt.hashpw(newu.getPassword(), BCrypt.gensalt(12)));		
			statement.setString(4, newu.getUsername());					
			statement.setString(7, old.getEmail());
			statement.executeUpdate();
			
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
	public void setPassword(String email, String password) {
		
		Connection connection = null;
		
		try {
			connection = this.dbSource.getConnection();
			String update = "update utente SET password = ? WHERE email=?";
			PreparedStatement statement = connection.prepareStatement(update);
			
			statement.setString(1, BCrypt.hashpw(password, BCrypt.gensalt(12)));			
			statement.setString(2, email);			
			statement.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		} 
	}
	
	
	@Override
	public void updateWithoutPsw(Utente old, Utente newu) {////////////to check
		
		Connection connection = null;
		
		try {
			connection = this.dbSource.getConnection();
			String update = "update utente SET nome = ?, cognome = ?, username = ? WHERE email=?";
			PreparedStatement statement = connection.prepareStatement(update);
			
			statement.setString(1, newu.getNome());			
			statement.setString(2, newu.getCognome());			
			statement.setString(3, newu.getUsername());							
			statement.setString(6, old.getEmail());
			statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
	}

	@Override
	public void delete(String email) { 
		Connection connection = null;
		
		try {
			connection = this.dbSource.getConnection();
			String delete = "delete FROM utente WHERE email=? ";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setString(1, email);
			statement.executeUpdate();		
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
	public boolean checkPassword(String email, String password) {
		String password_hash=null;
		
		try {
			Connection conn = dbSource.getConnection();
			String query = "select password from utente where email=?";
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, email);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				password_hash = rs.getString("password");
			}
			st.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return BCrypt.checkpw(password, password_hash);
	}
	

	@Override
	public String getUsername(String email) {
		String username=null;
		try {
			Connection conn = dbSource.getConnection();
			String query = "select utente.username from utente where email=?";
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, email);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				username = rs.getString("username");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return username;
	}
	

	@Override
	public boolean existsUsername(String username) {
		String check = null;
		try {
			Connection conn = dbSource.getConnection();
			String query = "select utente.username from utente where username=?";
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, username);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				check = rs.getString("username");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (check==null)
			return false;
		else
			return true;
	}

}
