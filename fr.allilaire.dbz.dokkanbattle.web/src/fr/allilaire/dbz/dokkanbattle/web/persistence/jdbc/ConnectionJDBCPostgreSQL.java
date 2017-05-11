package fr.allilaire.dbz.dokkanbattle.web.persistence.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ConnectionJDBCPostgreSQL {

	/**
	 * URL de connection
	 */
	private static String url = ConnectionJDBCPostgreSQL.init("url");

	/**
	 * Nom du user
	 */
	private static String user = ConnectionJDBCPostgreSQL.init("user");

	/**
	 * Mot de passe du user
	 */
	private static String passwd = ConnectionJDBCPostgreSQL.init("password");
	
	private static String driverClassName = ConnectionJDBCPostgreSQL.init("driver");

	private static String init(String property) {
		try {
			Properties p = new Properties();
			p.load(ConnectionJDBCPostgreSQL.class.getResourceAsStream("jdbc.properties"));
			return p.getProperty(property);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Statement createStatement() throws SQLException {
		Class<?> driverClass;
		try {
			driverClass = Class.forName(ConnectionJDBCPostgreSQL.driverClassName);
			DriverManager.registerDriver((Driver) driverClass.newInstance());
			Connection connection = DriverManager.getConnection(url, user, passwd);
			Statement statement = connection.createStatement();
			return statement;
		} catch (ReflectiveOperationException e) {
			throw new SQLException(e);
		}
	}
	
	public static PreparedStatement createPreparedStatement(String query) throws SQLException {
		Connection connection = DriverManager.getConnection(url, user, passwd);
		PreparedStatement statement = connection.prepareStatement(query);
		return statement;
	}
	
	public static void closeJDBC(Statement statement, ResultSet resultSet) {
		try {
			if (resultSet != null && !resultSet.isClosed()) {
				resultSet.close();
			}
			if (statement != null && !statement.isClosed()) {
				statement.close();
			}
			Connection connection = statement.getConnection();
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}