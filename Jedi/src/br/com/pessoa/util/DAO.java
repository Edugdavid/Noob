package br.com.pessoa.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {

	private static DAO instance;

	private final String user = "postgres";
	private final String passwd = "postgres";
	private final String dataBase = "pessoa";

	private static Connection connection = null;

	public DAO() {
	}

	public static synchronized DAO getInstance() {
		if (instance == null) {
			return instance = new DAO();
		}
		return instance;
	}

	public Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("org.postgresql.Driver");
		return connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dataBase, user, passwd);
	}

	public void close() throws SQLException {
		if (connection != null) {
			connection.close();
		}
	}

	public Boolean closed() throws SQLException {
		return connection.isClosed();
	}
}
