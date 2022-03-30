package Demo.eShop.persistance;


import Demo.eShop.persistance.dao.CommentoDAO;
import Demo.eShop.persistance.dao.ListaPreferitiDAO;
import Demo.eShop.persistance.dao.ProdottoDAO;
import Demo.eShop.persistance.dao.UtenteDAO;
import Demo.eShop.persistance.dao.jdbc.CommentoDAOJDBC;
import Demo.eShop.persistance.dao.jdbc.ListaPreferitiDAOJDBC;
import Demo.eShop.persistance.dao.jdbc.ProdottoDAOJDBC;
import Demo.eShop.persistance.dao.jdbc.UtenteDAOJDBC;



public class DBManager {
	private static DBManager instance = null;
	static DBSource dataSource;
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
			dataSource=new DBSource("jdbc:postgresql://localhost:5432/postgres","postgres","progettoweb");
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
	
	public ProdottoDAO prodottoDAO() {
		return new ProdottoDAOJDBC(dataSource);
	}
	
	public CommentoDAO commentoDAO() {
		return new CommentoDAOJDBC(dataSource);
	}
	
	public ListaPreferitiDAO listaPreferitiDAO() {
		return new ListaPreferitiDAOJDBC(dataSource);
	}
}
