package br.ueg.thymeleafapp.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.ueg.thymeleafapp.model.Atividade;
import br.ueg.thymeleafapp.model.UsuarioContato;
import br.ueg.thymeleafapp.services.AtividadeService;
import br.ueg.thymeleafapp.services.UsuarioContatoService;

@Controller
@RequestMapping("/usuarioContato")
public class UsuarioContatoController {
	
	@Autowired
	private final UsuarioContatoService usuarioContatoService;
	private final AtividadeService atividadeService;
	
	public UsuarioContatoController(UsuarioContatoService usuarioContatoService, AtividadeService atividadeService) {
		this.usuarioContatoService = usuarioContatoService;
		this.atividadeService = atividadeService;
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
		ModelAndView ModelAndView = new ModelAndView("home");
		UsuarioContato usuarioContato = usuarioContatoService.findById(id);
		ModelAndView.addObject("usuarios", usuarioContato);
		ModelAndView.addObject("atividadeForm", new Atividade());
		ModelAndView.addObject("atividades", this.atividadeService.listAll());
		return ModelAndView;
	}

}
