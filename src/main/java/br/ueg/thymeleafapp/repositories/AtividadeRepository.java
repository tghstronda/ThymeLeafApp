/**
 * 
 */
package br.ueg.thymeleafapp.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.ueg.thymeleafapp.model.Atividade;

/**
 * @author tghstronda
 *
 */
public interface AtividadeRepository extends PagingAndSortingRepository<Atividade, Long>{

}
