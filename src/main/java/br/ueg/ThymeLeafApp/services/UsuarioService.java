/**
 * 
 */
package br.ueg.ThymeLeafApp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.ueg.ThymeLeafApp.model.Usuario;
import br.ueg.ThymeLeafApp.repositories.UsuarioRepository;

/**
 * @author tghstronda
 *
 */
@Service
public class UsuarioService {

	private final UsuarioRepository usuarioRepository;
	
	public UsuarioService(UsuarioRepository usuarioRepository)
	{
		this.usuarioRepository = usuarioRepository;
	}
	
	public void salvaUsuario(Usuario usuario)
	{
		usuarioRepository.save(usuario);
	}
	
	public List<Usuario> listaUsuarios() 
	{
		List<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios = (List<Usuario>) usuarioRepository.findAll();
		return usuarios;
	}
}
