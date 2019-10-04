package br.ueg.thymeleafapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.ueg.thymeleafapp.model.LoginForm;
import br.ueg.thymeleafapp.model.UsuarioContato;
import br.ueg.thymeleafapp.services.UsuarioContatoService;

@Controller
public class LoginController {

	private final UsuarioContatoService usuarioContatoService;

	public LoginController(UsuarioContatoService usuarioContatoService) {
		this.usuarioContatoService = usuarioContatoService;
	}
	
	@GetMapping("/")
	public String index() {
		return "redirect:/login";
	}

	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView model = new ModelAndView("login");
		model.addObject("loginForm", new LoginForm());
		return model;
	}

	@PostMapping("/login")
	public String loginRedirect(@ModelAttribute("loginForm") 
			LoginForm loginForm) {

		String username = loginForm.getUsername();
		String password = loginForm.getPassword();
		
		UsuarioContato usuarioContato = usuarioContatoService
				.login(username, password);
		
		if (usuarioContato != null) {
			return "redirect:/usuarioContato/" + usuarioContato.getId();
		}

		return "redirect:/login";
	}

}
