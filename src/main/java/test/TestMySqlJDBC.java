package test;

import java.sql.Connection;
import java.sql.*;

public class TestMySqlJDBC {
	public static void main(String[] args) {
		//String de conexao
		String url = "jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
		
		
		try {
			//Define o driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Criando conexao
			Connection connection = DriverManager.getConnection(url,"root","feltex");
			
			//Criando o statement (Declaração da instrucao)
			Statement instruction = connection.createStatement();
			
			// Definindo uma sentença sql 
			String sql = "SELECT id_persona, nombre, apellido, email, telefono FROM persona ";
			
			//Executando a instrução com a sentença sql
			ResultSet result = instruction.executeQuery(sql);
			
			// Iterando resultado, o next() verifica se ainda ha algum elemento para iterar
			// Caso não haja mais elementos a loop para
			while (result.next()) {
				System.out.print("Id persona:" + result.getInt("id_persona"));
				System.out.print(" Nombre:" + result.getString("nombre"));
				System.out.print(" Apellido:" + result.getString("apellido"));
				System.out.print(" Email:" + result.getString("email"));
				System.out.print(" Telefono:" + result.getString("telefono"));
				System.out.println("");
			}
			
			result.close();
			instruction.close();
			connection.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
