/**
 * 
 */
package br.ueg.ThymeLeafApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.ueg.ThymeLeafApp.model.Usuario;
import br.ueg.ThymeLeafApp.services.UsuarioService;

/**
 * @author tghstronda
 *
 */
@Controller
public class UsuarioController {

	private final UsuarioService usuarioService;

	// Instanciando a classe usuario service
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;

	}

	@GetMapping("/usuarios") // metodo para listar usuarios
	public ModelAndView ListarUsuarios() {
		ModelAndView model = new ModelAndView("usuario");
		model.addObject("usuarios", usuarioService.listaUsuarios());
		model.addObject("usuario",new Usuario());
		// addobject adiciona um usuario na tela
		// chamando a lista de usuarios no
		return model;
	}

	@PostMapping("/usuario") // inserir os dados no usuario
	public String salvarUsuario(Usuario usuario) {
		usuarioService.salvaUsuario(usuario);
		return "redirect:/usuarios";// redirect ele para uma pasta
	}

}