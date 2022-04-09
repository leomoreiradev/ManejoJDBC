package dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class ConnectionJDBC {
	
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
	private static final String JDBC_USER = "root";
	private static final String JDBC_PASSWORD = "feltex";
	
	//Metodo para chamar uma conexao
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
	}
	
	//Metodo para fechar o obj ResultSet
	public static void close(ResultSet resultset) throws SQLException {
		resultset.close();
	}
	
	//Metodo para fechar o obj Statement
	public static void close(Statement statement) throws SQLException {
		statement.close();
	}
	
	//Metodo para fechar o obj PreparedStatement
	public static void close(PreparedStatement preparedStatement) throws SQLException {
		preparedStatement.close();
	}
	
	public static void close(Connection connection) throws SQLException {
		connection.close();
	}
	
	
	
	
	
	
}
