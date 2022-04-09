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
	private static final String SQL_INSERT = "INSERT INTO persona(nombre, apellido, email, telefono) values(?, ?, ?, ?)";
	private static final String SQL_UPDATE = "UPDATE persona SET nombre = ?, apellido = ?, email = ?, telefono = ? WHERE id_persona = ?";
	private static final String SQL_DELETE = "DELETE FROM persona WHERE id_persona = ?";
	  
	public List<Persona> selecionar() {
		//Definindo variaveis
		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Persona persona = null;
		List<Persona> personas = new ArrayList<Persona>();
		
		//Esse ConnectionJDBC.getConnection(); pode lan�ar uma exception, portanto estamos tratando a execption
		try {
			
			//Criando uma conexao
			connection = ConnectionJDBC.getConnection();
			
			//Preparando a instrucao
			stmt = connection.prepareStatement(SQL_SELECT);
			
			//Executando a instrucao com a senten�a SQL
			rs = stmt.executeQuery(SQL_SELECT);
			
			//Enquanto houver regitro ele vai iterar usando o next() para verificar se tem um proximo elemento
			while(rs.next()) {
				
				//Recuperando cada campo do registro
				int idPersona = rs.getInt("id_persona");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String email = rs.getString("email");
				String telefono = rs.getString("telefono");
				
				//Preenchendo o obj / converter o registro em obj JAVA
				persona = new Persona(idPersona, nombre, apellido, email, telefono);
				
				//Adicionando o obj a lista
				personas.add(persona);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}
		finally {
			
			try {
				//Fechado os objs
				ConnectionJDBC.close(rs);
				ConnectionJDBC.close(stmt);
				ConnectionJDBC.close(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return personas;
	}
	
	public int insertar(Persona persona) {
		Connection connection = null;
		PreparedStatement stmt = null;
		int registros = 0;
		try {
			//Criando a conexao
			connection = ConnectionJDBC.getConnection();
			
			//Preparando a instrucao
			stmt = connection.prepareStatement(SQL_UPDATE);
			
			//Setando os paramentos na query onde tem o (?) 
			stmt.setString(1, persona.getNombre());
			stmt.setString(2, persona.getApellido());
			stmt.setString(3, persona.getEmail());
			stmt.setString(4, persona.getTelefono());
			
			
			//Executando a instrucao com a sentenca SQL
			registros = stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}
		finally {
			try {
				ConnectionJDBC.close(stmt);
				ConnectionJDBC.close(connection);
			} catch (SQLException e) {
				e.printStackTrace(System.out);
			}	
		}
		
		return registros;
		
	}
	
	public int atualizar(Persona persona) {
		Connection connection = null;
		PreparedStatement stmt = null;
		int registros = 0;
		try {
			//Criando a conexao
			connection = ConnectionJDBC.getConnection();
			
			//Preparando a instrucao
			stmt = connection.prepareStatement(SQL_UPDATE);
			
			//Setando os paramentos na query onde tem o (?) 
			stmt.setString(1, persona.getNombre());
			stmt.setString(2, persona.getApellido());
			stmt.setString(3, persona.getEmail());
			stmt.setString(4, persona.getTelefono());
			stmt.setInt(5, persona.getIdPersona());
			
			
			//Executando a instrucao com a sentenca SQL
			registros = stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}
		finally {
			try {
				ConnectionJDBC.close(stmt);
				ConnectionJDBC.close(connection);
			} catch (SQLException e) {
				e.printStackTrace(System.out);
			}	
		}
		
		return registros;
		
	}
	
	
	public int deletar(Persona persona) {
		Connection connection = null;
		PreparedStatement stmt = null;
		int registros = 0;
		try {
			//Criando a conexao
			connection = ConnectionJDBC.getConnection();
			
			//Preparando a instrucao
			stmt = connection.prepareStatement(SQL_DELETE);
			
			//Setando os paramentos na query onde tem o (?) 
			stmt.setInt(1, persona.getIdPersona());
			
			
			//Executando a instrucao com a sentenca SQL
			registros = stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}
		finally {
			try {
				ConnectionJDBC.close(stmt);
				ConnectionJDBC.close(connection);
			} catch (SQLException e) {
				e.printStackTrace(System.out);
			}	
		}
		
		return registros;
		
	}
	
	
}
