package test;

import java.util.List;

import dados.PersonaDAO;
import domain.Persona;

public class TestManejoPersonas {
	public static void main(String[] args) {
		PersonaDAO personaDAO = new PersonaDAO();
		
		
		//Insertando um novo obj do tipo persona.
//		Persona personaNueva = new Persona("Carlos", "Esparza", "cesparza@mail.com", "554456587");
//		personaDAO.insertar(personaNueva);
		
//		//Atualizando um obj tipo persona pelo id_persona
//		Persona personaAtualizar = new Persona(6,"Juan Carlos", "Esparza", "jcesparza@mail.com", "554456587");
//		personaDAO.atualizar(personaAtualizar);
		
		// Deletar uma persona
		Persona personaDeletar = new Persona(6,"Juan Carlos", "Esparza", "jcesparza@mail.com", "554456587");
		personaDAO.deletar(personaDeletar);
		
		//Listando personas
		List<Persona> personas = personaDAO.selecionar();

//      Usando lambda	
		personas.forEach(persona -> {
			System.out.println("persona com lambda = " + persona);
		});
		
//      Usando foreach 	
//		for(Persona persona:personas) {
//			System.out.println("persona com foreach = " + persona);
//		}
		
		

	}
}
