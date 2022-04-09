package test;

import java.sql.*;
import java.util.List;

import dados.ConnectionJDBC;
import dados.PersonaDAO;
import domain.Persona;

public class TestManejoPersonas {
	public static void main(String[] args) {
		
		Connection connection = null;
		
		try {
			connection = ConnectionJDBC.getConnection();
			//Veirificando se o autocommit está true, caso sim setamos ele como false
			if(connection.getAutoCommit()) {
				connection.setAutoCommit(false);
			}
			
			
			PersonaDAO personaDAO = new PersonaDAO(connection);
			
			Persona personaAtualizar = new Persona();
			personaAtualizar.setIdPersona(2);
			personaAtualizar.setNombre("Karla");
			personaAtualizar.setApellido("Gomez");
			personaAtualizar.setEmail("kgomes@mail.com");
			personaAtualizar.setTelefono("77113445678");
			
			personaDAO.atualizar(personaAtualizar);
			
			System.out.println("Pessoa atualizada:" + personaAtualizar);
			
			
			Persona personaNueva = new Persona();
			
			personaNueva.setNombre("Carlos");
			//Gerando erro para que a transação não seja efetivada e seja dado o rollback
			//Este campo so pode receber ate 45 caracteres
			personaNueva.setApellido("Ramirez1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111");
			
			//Caso em que funciona normal a transação sem precisar dar rollback
			//personaNueva.setApellido("Ramirez");
			
			personaDAO.insertar(personaNueva);
			
			System.out.println("Pessoa inserida:" + personaNueva);
			
			connection.commit();
			
		} catch (SQLException e) {
			e.printStackTrace(System.out);
			System.out.println("Chamando o rollback");
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace(System.out);
			}
			
		}
		
		

	}
}
