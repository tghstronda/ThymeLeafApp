package br.ueg.thymeleafapp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ueg.thymeleafapp.model.UsuarioContato;
import br.ueg.thymeleafapp.repositories.UsuarioContatoRepository;

@Service
public class UsuarioContatoService {

	private final UsuarioContatoRepository usuarioContatoRepository;

	@Autowired
	public UsuarioContatoService(UsuarioContatoRepository usuarioContatoRepository) {
		this.usuarioContatoRepository = usuarioContatoRepository;
	}

	public void salvaUsuario(UsuarioContato usuarioContato) {
		usuarioContatoRepository.save(usuarioContato);
	}
	
	public List<UsuarioContato> listaUsuarios(){
		List<UsuarioContato> contatosDeUsuarios = new ArrayList<UsuarioContato>();
				contatosDeUsuarios = (List<UsuarioContato>) usuarioContatoRepository.findAll();
		return contatosDeUsuarios;
	}
	
	public UsuarioContato findById(long id) {
		return usuarioContatoRepository.getOne(id);
		//return usuarioContatoRepository.getOne(id);
	}
	
	public UsuarioContato login(String username, String password) {
		return (UsuarioContato) usuarioContatoRepository.findByLogin(username, password);
	}
}
