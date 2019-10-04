/**
 * 
 */
package br.ueg.thymeleafapp.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author tghstronda
 *
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.ueg.thymeleafapp.model.Atividade;
import br.ueg.thymeleafapp.repositories.UsuarioContatoRepository;
import br.ueg.thymeleafapp.services.AtividadeService;

@Controller
@RequestMapping("/atividade")
public class AtividadeController {
	
	@Autowired
	private UsuarioContatoRepository usuarioContatoRepository;
	private final AtividadeService atividadeService;
	
	public AtividadeController(AtividadeService atividadeService) {
		this.atividadeService = atividadeService;
	}

	@PostMapping
	public String salvarAtividade(@ModelAttribute Atividade atividade) {
		atividadeService.salvar(atividade);
		ModelAndView model = new ModelAndView("home");
		model.addObject("atividades",this.atividadeService.listAll());
		model.addObject("usuarioSelect", this.usuarioContatoRepository.findAll());
		return "redirect:/usuarioContato/"+atividade.getIdUsuarioContato();
	}
	@PostMapping("/update")
	public String updateAtividade(@ModelAttribute Atividade atividade) {
		atividadeService.editarAtividade(atividade);
		return "redirect:/atividade/edit/"+atividade.getId();
	}
	@DeleteMapping("/delete/{id}")
	public boolean deletarAtividade(@PathVariable("id") Long id) {
		boolean bo_deletado = this.atividadeService.deleteById(id);
		return bo_deletado;
	}
	@GetMapping("/edit/{id}")
	public ModelAndView editAtividade(@PathVariable("id") Long id) {
		Optional<Atividade> atividade = this.atividadeService.findById(id);
		ModelAndView model = new ModelAndView("edited");
		model.addObject("atividade",atividade);
		model.addObject("usuarioSelect", this.usuarioContatoRepository.findAll());
		return model;
	}

}
