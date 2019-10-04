/**
 * 
 */
package br.ueg.thymeleafapp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ueg.thymeleafapp.model.Atividade;
import br.ueg.thymeleafapp.repositories.AtividadeRepository;

/**
 * @author tghstronda
 *
 */
@Service
public class AtividadeService {

	private final AtividadeRepository atividadeRepository;

	public AtividadeService(AtividadeRepository atividadeRepository) {
		this.atividadeRepository = atividadeRepository;
	}
	
	public List<Atividade> listAll(){
		return (List<Atividade>) atividadeRepository.findAll();
	}
	
	public void salvar(Atividade atividade) {
		this.atividadeRepository.save(atividade);
	}
	public void editarAtividade(Atividade atividade) {
		this.atividadeRepository.save(atividade);
	}
	public Optional<Atividade> findById(Long id) {
		return this.atividadeRepository.findById(id);
	}
	public boolean deleteById(Long id) {
		atividadeRepository.deleteById(id);
		return true;
	}
}
