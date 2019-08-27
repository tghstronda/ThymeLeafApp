/**
 * 
 */
package br.ueg.ThymeLeafApp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.ueg.ThymeLeafApp.model.Usuario;

/**
 * @author tghstronda
 *
 */
@Service
public class UsuarioService {

	public List<Usuario> listUsuarios() 
	{
		List<Usuario> usuarios = new ArrayList<>();
		Usuario usuario1 =  new Usuario();
		usuario1.setId(1L);
		usuario1.setName("Adri");
		usuario1.setPassword("adriano");	
		
		Usuario usuario2 =  new Usuario();
		usuario2.setId(1L);
		usuario2.setName("Adriana");
		usuario2.setPassword("adriano");
		

		Usuario usuario3 =  new Usuario();
		usuario3.setId(1L);
		usuario3.setName("Adry");
		usuario3.setPassword("adriano");
		
		Usuario usuario4 =  new Usuario();
		usuario4.setId(50L);
		usuario4.setName("AtividadeNinja");
		usuario4.setPassword("swordfish");
		
		usuarios.add(usuario1);
		usuarios.add(usuario2);
		usuarios.add(usuario3);
		usuarios.add(usuario4);
		
		
		return usuarios;		
	}
}
