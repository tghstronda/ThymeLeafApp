/**
 * 
 */
package br.ueg.ThymeLeafApp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.ueg.ThymeLeafApp.model.UserContato;
import br.ueg.ThymeLeafApp.repositories.ContatoRepository;

/**
 * @author tghstronda
 *
 */
@Service
public class ContatoService {

private final ContatoRepository contatoRepository;
	
	public ContatoService(ContatoRepository contatoRepository)
	{
		this.contatoRepository = contatoRepository;
	}
	
	public void salvaContato(UserContato usercontato)
	{
		contatoRepository.save(usercontato);
	}
	
	public List<UserContato> listaContato() 
	{
		List<UserContato> contatos = new ArrayList<UserContato>();
		contatos = (List<UserContato>) contatoRepository.findAll();
		return contatos;
	}
}
