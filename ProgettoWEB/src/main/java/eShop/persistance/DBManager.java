package eShop.persistance;

import eShop.dao.CommentoDAO;
import eShop.dao.ProdottoDAO;
import eShop.dao.UtenteDAO;
import eShop.dao.jdbc.CommentoDAOJDBC;
import eShop.dao.jdbc.ProdottoDAOJDBC;
import eShop.dao.jdbc.UtenteDAOJDBC;

public class DBManager {
	private static DBManager instance = null;
	static DBSource dataSource;
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
			dataSource=new DBSource("jdbc:postgresql://localhost:5432/postgres/Databases/postgres","postgres","progettoweb");
		} 
		catch (Exception e) {
			System.err.println("PostgresDAOFactory.class: failed to load MySQL JDBC driver\n"+e);
			e.printStackTrace();
		}
	}
	
	public static DBManager getInstance() {
		if (instance == null) {
			instance = new DBManager();
		}
		return instance;
	}
	
	private DBManager() {
	}
	
	public static DBSource getDataSource() {
		return dataSource;
	}
	
	public UtenteDAO utenteDAO() {
		return new UtenteDAOJDBC(dataSource);
	}
	
	public ProdottoDAO deviceDAO() {
		return new ProdottoDAOJDBC(dataSource);
	}
	
	public CommentoDAO commentoDAO() {
		return new CommentoDAOJDBC(dataSource);
	}
}
