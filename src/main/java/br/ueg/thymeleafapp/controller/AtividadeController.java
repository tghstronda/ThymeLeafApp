/**
 * 
 */
package br.ueg.thymeleafapp.controller;

/**
 * @author tghstronda
 *
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.ueg.thymeleafapp.model.Atividade;
import br.ueg.thymeleafapp.model.UsuarioContato;
import br.ueg.thymeleafapp.services.AtividadeService;
import br.ueg.thymeleafapp.services.UsuarioContatoService;

@Controller
public class AtividadeController {

	private final AtividadeService atividadeService;
	private final UsuarioContatoService usuarioContatoService;
	
	
	public AtividadeController(AtividadeService atividadeService, UsuarioContatoService usuarioContatoService) {
		this.atividadeService = atividadeService;
		this.usuarioContatoService = usuarioContatoService;
	}

	@PostMapping(("**/atividade/{usuarioContatoId}"))
	public ModelAndView salvarAtividade(Atividade atividade, @PathVariable("usuarioContatoId") Long usuarioContatoId) {
		UsuarioContato usuarioContato = usuarioContatoService.findById(usuarioContatoId);
		atividade.setUsuarioContato(usuarioContato);
		atividadeService.salvar(atividade);
		
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("usuarios",usuarioContato);
		modelAndView.addObject("atividadeForm", new Atividade());
		modelAndView.addObject("atividades", atividadeService.listAll());
		return modelAndView;	
	}
}
