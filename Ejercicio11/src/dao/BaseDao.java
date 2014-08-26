package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import exception.AppDaoException;

public abstract class BaseDao {
	public static final String URL = "jdbc:derby://localhost/test";
	public static final String USUARIO = "user";
	public static final String CLAVE = "123";
	
	protected Connection con;
	
	static {
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public BaseDao() {
		try {
			this.con = DriverManager.getConnection(URL, USUARIO, CLAVE);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppDaoException(e);
		}
	}
	
	@Override
	protected void finalize() throws Throwable {
		if (con != null)
			con.close();
	}
	

}
