package br.ueg.thymeleafapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.ueg.thymeleafapp.model.UsuarioContato;
import br.ueg.thymeleafapp.services.UsuarioContatoService;

@Controller
@RequestMapping("/usuarioContato")
public class UsuarioContatoController {
	
private final UsuarioContatoService usuarioContatoService;
	
	public UsuarioContatoController(UsuarioContatoService usuarioContatoService) {
		this.usuarioContatoService = usuarioContatoService;
	}

	@GetMapping
	public ModelAndView addUsuario() {
		ModelAndView model = new ModelAndView("formUsuario");
		model.addObject("usuarioContato", new UsuarioContato());
		return model;
	}
	
	@PostMapping
	public String saveContatoUsuario(UsuarioContato usuarioContato) {
		usuarioContatoService.salvaUsuario(usuarioContato);
		return "redirect:/login";
	}
	
	@GetMapping("/{id}")
	public ModelAndView homeUsuario(@PathVariable("id") Long id) {
		ModelAndView model = new ModelAndView("usuario");
		model.addObject("usuario", usuarioContatoService.findById(id));
		return model;
	}
}
