/**
 * 
 */
package br.ueg.thymeleafapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.ueg.thymeleafapp.model.Atividade;

/**
 * @author tghstronda
 *
 */
public interface AtividadeRepository extends JpaRepository<Atividade, Long>{

}
