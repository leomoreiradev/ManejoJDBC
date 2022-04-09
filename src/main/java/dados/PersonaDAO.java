package dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Persona;

public class PersonaDAO {
	private static final String SQL_SELECT = "SELECT id_persona, nombre, apellido, email, telefono FROM persona";
	
	public List<Persona> selecionar() {
		//Definindo variaveis
		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Persona persona = null;
		List<Persona> personas = new ArrayList<Persona>();
		
		//Esse ConnectionJDBC.getConnection(); pode lançar uma exception, portanto estamos tratando a execption
		try {
			
			//Criando uma conexao
			connection = ConnectionJDBC.getConnection();
			
			//Preparando a instrução
			stmt = connection.prepareStatement(SQL_SELECT);
			
			//Executando a instrução com a sentença SQL
			rs = stmt.executeQuery(SQL_SELECT);
			
			//Enquanto houver regitro ele vai iterar usando o next() para verificar se tem um proximo elemento
			while(rs.next()) {
				
				int id_persona = rs.getInt("id_persona");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String email = rs.getString("email");
				String telefono = rs.getString("telefono");
				
				
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}
		return null;
	}
}
