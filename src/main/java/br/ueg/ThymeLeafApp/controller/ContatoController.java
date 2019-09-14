/**
 * 
 */
package br.ueg.ThymeLeafApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.ueg.ThymeLeafApp.model.UserContato;
import br.ueg.ThymeLeafApp.services.ContatoService;

/**
 * @author tghstronda
 *
 */
@Controller
public class ContatoController {

	private final ContatoService contatoService;

	// Instanciando a classe usuario service
	public ContatoController(ContatoService contatoService) {
		this.contatoService = contatoService;

	}

	@GetMapping("/contatos") // metodo para listar usuarios
	public ModelAndView ListarContatos() {
		ModelAndView model = new ModelAndView("contatos");
		model.addObject("contatos", contatoService.listaContato());
		model.addObject("contato",new UserContato());
		// addobject adiciona um usuario na tela
		// chamando a lista de usuarios no
		return model;
	}

	@PostMapping("/contatos") // inserir os dados no usuario
	public String salvarContato(UserContato usercontato) {
		contatoService.salvaContato(usercontato);
		return "redirect:/contatos";// redirect ele para uma pasta
	}
}
